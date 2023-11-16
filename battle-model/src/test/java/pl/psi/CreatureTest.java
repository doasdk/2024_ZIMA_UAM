// ******************************************************************
//  
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//  
// ******************************************************************

package pl.psi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
class CreatureTest
{

    public static final int NOT_IMPORTANT = 1;

    @Test
    void defenderShouldLostMoreHpThanDamageBecauseAttackIsGreaterThanDefence()
    {
        Creature attacker = new Creature( 20, NOT_IMPORTANT, 10, NOT_IMPORTANT );
        Creature defender = new Creature( NOT_IMPORTANT, 10, NOT_IMPORTANT, 20 );

        attacker.attack( defender );

        assertThat( defender.getCurrentHp() ).isEqualTo( 5 );
    }

    @Test
    void defenderShouldLostLessHpThanDamageBecauseAttackIsLowerThanDefence()
    {
        Creature attacker = new Creature( 10, NOT_IMPORTANT, 10, NOT_IMPORTANT );
        Creature defender = new Creature( NOT_IMPORTANT, 30, NOT_IMPORTANT, 20 );

        attacker.attack( defender );

        assertThat( defender.getCurrentHp() ).isEqualTo( 15 );
    }

    @Test
    void shouldIgnoreArmorToDealMaxDamage()
    {
        Creature attackerWithDefenceReduce = new Creature( 10, NOT_IMPORTANT, 10, NOT_IMPORTANT, new ReduceArmorDamageCalculator(0.5) );
        Creature defender = new Creature( NOT_IMPORTANT, 30, NOT_IMPORTANT, 20 );

        attackerWithDefenceReduce.attack( defender );

        assertThat( defender.getCurrentHp() ).isEqualTo( 11 );
    }
}