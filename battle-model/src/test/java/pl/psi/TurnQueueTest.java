// ******************************************************************
//  
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//  
// ******************************************************************

package pl.psi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
class TurnQueueTest
{
    private static int MOVE_RANGE;

    @BeforeEach
    void setup()
    {
        MOVE_RANGE = 0;
    }

    // @ParameterizedTest
    // @MethodSource( "queueShouldHasProperlySizeArgs" )
    // void queueShouldHasProperlySize( List< Creature > c1, List< Creature > c2, int result )
    // {
    // TurnQueue queue = new TurnQueue( c1, c2 );
    //
    // assertThat( queue.size() ).isEqualTo( result );
    // }
    //
    // private static Stream<Arguments> queueShouldHasProperlySizeArgs() {
    // return Stream.of(
    // Arguments.of(List.of( dummyCreature(),dummyCreature(),dummyCreature() ),List.of(
    // dummyCreature(),dummyCreature() ), 5),
    // Arguments.of(List.of( dummyCreature(), dummyCreature(),dummyCreature(),dummyCreature() ),List.of(
    // dummyCreature(),dummyCreature() ), 5)
    // );
    // }

    @Test
    void queueShouldBeInitializedAutomatically()
    {
        List< Creature > c1 = List.of( dummyCreature(), dummyCreature() );
        List< Creature > c2 = List.of( dummyCreature(), dummyCreature(), dummyCreature() );
        TurnQueue queue = new TurnQueue( c1, c2 );

        assertCurrentMoveRange( queue, 5 );
        queue.next();
        assertCurrentMoveRange( queue, 4 );
        queue.next();
        assertCurrentMoveRange( queue, 3 );
        queue.next();
        assertCurrentMoveRange( queue, 2 );
        queue.next();
        assertCurrentMoveRange( queue, 1 );

        // NEW ROUND
        queue.next();
        assertCurrentMoveRange( queue, 5 );
    }

    private static void assertCurrentMoveRange( TurnQueue queue, int expected )
    {
        assertThat( queue.getCurrentCreature()
            .getMoveRange() ).isEqualTo( expected );
    }

    private static Creature dummyCreature()
    {
        MOVE_RANGE++;
        return new Creature( 1, 1, 1, 1, new DamageCalculator(), MOVE_RANGE );
    }

}