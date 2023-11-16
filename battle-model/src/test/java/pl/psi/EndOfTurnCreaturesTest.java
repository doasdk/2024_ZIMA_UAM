// ******************************************************************
//  
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//  
// ******************************************************************

package pl.psi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class EndOfTurnCreaturesTest
{

    public static final int SELF_HEALER_START_HP = 10;

    @Test
    void creatureShouldHasFullHealAfterTurn()
    {
        Creature attacker = new Creature( 1, 1, 1, 1 );
        Creature selfHealer = new SelfHealAfterTurnCreature( new Creature( 1, 1, 1, 10 ) );

        TurnQueue turnQueue = new TurnQueue( List.of( attacker ), List.of( selfHealer ) );
        attacker.attack( selfHealer );
        turnQueue.next();
        turnQueue.next();

        assertThat( selfHealer.getCurrentHp() ).isEqualTo( SELF_HEALER_START_HP );
    }

    @Test
    void shouldCorrectAttackDecoratedCreature()
    {
        Creature attacker = new Creature( 1, 1, 1, 1 );
        Creature selfHealer = new SelfHealAfterTurnCreature( new Creature( 1, 1, 1, 10 ) );

        attacker.attack( selfHealer );

        assertThat( selfHealer.getCurrentHp() ).isEqualTo( 9 );
    }

    @Test
    void decoratorInsideDecorator()
    {
        Creature attacker = new Creature( 1, 1, 1, 1 );
        Creature selfHealerAndDoubleDamage =
            new DoubleDamageAfterTurnCreature( //
                    new SelfHealAfterTurnCreature( //
                            new Creature( 1, 1, 1, 10 ) ) );

        TurnQueue turnQueue = new TurnQueue( List.of( attacker ), List.of( selfHealerAndDoubleDamage ) );
        attacker.attack( selfHealerAndDoubleDamage );
        turnQueue.next();
        turnQueue.next();

        assertThat( selfHealerAndDoubleDamage.getCurrentHp() ).isEqualTo( SELF_HEALER_START_HP );
        assertThat( selfHealerAndDoubleDamage.getDamage() ).isEqualTo( 2 );
    }
}
