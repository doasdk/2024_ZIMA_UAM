package pl.psi.gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pl.psi.Creature;
import pl.psi.GameEngine;
import pl.psi.Point;

public class MainBattleController implements PropertyChangeListener
{
    private final GameEngine gameEngine;
    @FXML
    private GridPane gridMap;
    @FXML
    private Button passButton;

    public MainBattleController()
    {
        gameEngine = new GameEngine();
    }

    @FXML
    private void initialize()
    {
        refreshGui();
    }

    private void refreshGui()
    {

        gridMap.getChildren()
            .clear();
        for( int x = 0; x < 15; x++ )
        {
            for( int y = 0; y < 10; y++ )
            {
                Point point = new Point( x, y );
                Optional< Creature > creature = gameEngine.getCreature( point );
                final MapTile mapTile = new MapTile();
                creature.ifPresent( c -> { mapTile.setRedColor(); } );
                if( gameEngine.canMove( point ) )
                {
                    mapTile.addEventHandler( MouseEvent.MOUSE_CLICKED, ( e ) -> {
                        gameEngine.move( point );
                        refreshGui();
                    } );
                    mapTile.setColor(Color.GRAY);

                }
                if (gameEngine.isActiveCreature(point)){
                    mapTile.setColor(Color.GREEN);
                }
                gridMap.add( mapTile, x, y );
            }
        }

    }

    @Override
    public void propertyChange( PropertyChangeEvent evt )
    {
        refreshGui();
    }
}
