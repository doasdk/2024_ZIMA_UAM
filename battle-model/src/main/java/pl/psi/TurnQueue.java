// ******************************************************************
//
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
// ******************************************************************

package pl.psi;

import java.beans.PropertyChangeSupport;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Getter;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class TurnQueue
{

    public static final String END_OF_TURN = "END_OF_TURN";
    private final Queue< Creature > queue;
    private final List< Creature > creatures;
    @Getter
    private Creature currentCreature;
    private final PropertyChangeSupport propChangeSupport = new PropertyChangeSupport( this );

    public TurnQueue( List< Creature > aCreatures1, List< Creature > aCreatures2 )
    {
        creatures = Stream.concat( aCreatures1.stream(), aCreatures2.stream() )
            .collect( Collectors.toList() );
        creatures.forEach( propChangeSupport::addPropertyChangeListener );
        queue = new LinkedList<>();
        initializeQueue();
        next();
    }

    private void initializeQueue()
    {
        queue.addAll( creatures.stream()
            .sorted( Comparator.comparingInt( Creature::getMoveRange )
                .reversed() )
            .collect( Collectors.toList() ) );
    }

    public int size()
    {
        return queue.size();
    }

    public void next()
    {
        if( queue.isEmpty() )
        {
            initializeQueue();
            propChangeSupport.firePropertyChange( END_OF_TURN, null, null );
        }
        currentCreature = queue.poll();
    }
}
