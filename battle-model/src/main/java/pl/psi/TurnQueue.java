// ******************************************************************
//
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
// ******************************************************************

package pl.psi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class TurnQueue
{

    private final List< Creature > queue;

    public TurnQueue( List< Creature > aCreatures1, List< Creature > aCreatures2 )
    {
        queue = Stream.concat( aCreatures1.stream(), aCreatures2.stream() )
            .sorted( Comparator.comparingInt( Creature::getMoveRange )
                .reversed() )
            .collect( Collectors.toList() );
    }

    public int size()
    {
        return queue.size();
    }

    public Creature getCurrentCreature()
    {
        return queue.get( 0 );
    }
}
