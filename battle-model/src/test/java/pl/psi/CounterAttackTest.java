// ******************************************************************
//
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
// ******************************************************************

package pl.psi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.psi.CreatureTest.NOT_IMPORTANT;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class CounterAttackTest {

    @Test
    void defenderShouldCounterAttack(){
        //given
        Creature attacker = new Creature( 20, 20, 10, 20 );
        Creature defender = new Creature( 20, 20, 10, 20 );

        //when
        attacker.attack(defender);

        //then
        assertThat(attacker.getCurrentHp()).isEqualTo(10);
    }

    @Test
    void defenderShouldNotCounterAttackIfDied(){
        //given
        Creature attacker = new Creature( 20, 20, 50, 20 );
        Creature defender = new Creature( 20, 20, 10, 20 );

        //when
        attacker.attack(defender);

        //then
        assertThat(attacker.getCurrentHp()).isEqualTo(20);
    }

    @Test
    void defenderShouldNotCounterAttackToSecondAttacker(){
        //given
        Creature attacker1 = new Creature( 20, 20, 5, 20 );
        Creature attacker2 = new Creature( 20, 20, 5, 20 );
        Creature defender = new Creature( 20, 20, 10, 20 );

        //when
        attacker1.attack(defender);
        attacker2.attack(defender);

        //then
        assertThat(attacker1.getCurrentHp()).isEqualTo(10);
        assertThat(attacker2.getCurrentHp()).isEqualTo(20);
    }
}
