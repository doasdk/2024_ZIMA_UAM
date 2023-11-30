package pl.psi.gui;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class MapTile extends StackPane
{

    public static final int RECTANGLE_SIZE = 60;
    private final Rectangle rect;

    MapTile()
    {
        rect = new Rectangle( RECTANGLE_SIZE, RECTANGLE_SIZE );
        rect.setFill( Color.WHITE );
        rect.setStroke( Color.RED );
        getChildren().add( rect );
    }

    void setRedColor(){
        rect.setFill(Color.RED);
    }

    public void setColor(Color aColor) {
        rect.setFill(aColor);
    }
}
