// ******************************************************************
//  
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//  
// ******************************************************************

package pl.psi;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class GameEngine
{

    private final TurnQueue turnQueue;
    private final Board board = new Board();

    public GameEngine()
    {
        Creature c1 = new Creature();
        c1.setMoveRange( 5 );
        Creature c2 = new Creature();
        c1.setMoveRange( 4 );
        Creature c3 = new Creature();
        c1.setMoveRange( 3 );
        Creature c4 = new Creature();
        c1.setMoveRange( 2 );
        List< Creature > creatures1 = List.of( c1, c2 );
        List< Creature > creatures2 = List.of( c3, c4 );
        turnQueue = new TurnQueue( creatures1, creatures2 );

        board.add(c1, new Point(1,1));
        board.add(c2, new Point(2,2));
        board.add(c3, new Point(3,3));
        board.add(c4, new Point(4,4));
    }

    public Optional< Creature > getCreature( Point aPoint )
    {
        return board.getCreature( aPoint );
    }

    public boolean isActiveCreature(Point aPoint){
        return board.getCreature(aPoint).filter(c -> c.equals(turnQueue.getCurrentCreature())).isPresent();
    }

    public boolean canMove( Point aPoint )
    {
        return getCurrentCreatureLocation().filter( p -> aPoint.distance( p ) < turnQueue.getCurrentCreature()
            .getMoveRange() )
            .isPresent();
    }

    private Optional< Point > getCurrentCreatureLocation()
    {
        return board.getCreatureLocation( turnQueue.getCurrentCreature() );
    }

    public void move( Point aPoint )
    {
        board.move( turnQueue.getCurrentCreature(), aPoint );
    }
}
