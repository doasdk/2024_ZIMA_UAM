// ******************************************************************
//  
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//  
// ******************************************************************

package pl.psi;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class Board
{
    // lokalizacja kreatur - gdzie jest kreatura
    // lokalizacja kreatur - dodawanie
    // move

    private final Map< Point, Creature > map = new HashMap<>();

    Optional< Point > getCreatureLocation( Creature aCreature )
    {
        return map.entrySet()
            .stream()
            .filter( entry -> entry.getValue()
                .equals( aCreature ) )
            .map( Map.Entry::getKey )
            .findAny();
    }

    Optional< Creature > getCreature( Point aPoint )
    {
        return Optional.ofNullable( map.get( aPoint ) );
    }

    public void add( Creature aCreature, Point aPoint )
    {
        map.put( aPoint, aCreature );
    }

    public void move( Creature aCreature, Point aPoint )
    {
        Optional<Point> oldPoint = getCreatureLocation(aCreature);
        oldPoint.ifPresent(p -> {
            map.remove(p);
            map.put( aPoint, aCreature );
        });
    }


    public void canMove(Point aPoint) {
    }
}
