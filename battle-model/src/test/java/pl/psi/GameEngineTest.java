package pl.psi;

import java.util.List;

import org.junit.jupiter.api.Test;

import pl.psi.artifacts.Artifact;
import pl.psi.artifacts.ArtifactClass;
import pl.psi.artifacts.ArtifactSlots;
import pl.psi.creatures.CastleCreatureFactory;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class GameEngineTest
{
    @Test
    void shoudWorksHeHe()
    {
        final CastleCreatureFactory creatureFactory = new CastleCreatureFactory();
        final GameEngine gameEngine =
            new GameEngine( new Hero( List.of( creatureFactory.create( 1, false, 5 ) ),  List.of(new Artifact("Sword of Hellfire ", 6, ArtifactSlots.HAND, ArtifactClass.ATTACK, "Increases attack power") )),
                new Hero( List.of( creatureFactory.create( 1, false, 5 )),  List.of(new Artifact("Centaur's Ax", 2, ArtifactSlots.HAND, ArtifactClass.ATTACK, "Increases attack power")  ) ));

        gameEngine.attack( new Point( 1, 1 ) );
    }
}
