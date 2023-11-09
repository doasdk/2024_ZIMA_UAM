// ******************************************************************
//  
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//  
// ******************************************************************

package pl.psi;

import lombok.Getter;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
@Getter
public class Creature
{
    private int attack;
    private int defence;
    private int damage;
    private int hp;
    private int moveRange;
    private DamageCalculator damageCalculator;
    private boolean canCounterAttack = true;

    public Creature( int aAttack, int aDefence, int aDamage, int aHp )
    {
        this( aAttack, aDefence, aDamage, aHp, new DamageCalculator() );
    }

    public Creature( int aAttack, int aDefence, int aDamage, int aHp, DamageCalculator aDamageCalculator )
    {
        this( aAttack, aDefence, aDamage, aHp, aDamageCalculator, 1 );
    }

    public Creature( int aAttack, int aDefence, int aDamage, int aHp, DamageCalculator aDamageCalculator,
        int aMoveRange )
    {
        attack = aAttack;
        defence = aDefence;
        damage = aDamage;
        hp = aHp;
        damageCalculator = aDamageCalculator;
        moveRange = aMoveRange;
    }

    public void attack( Creature aDefender )
    {
        aDefender.hp = aDefender.hp - damageCalculator.calculateDamage( this, aDefender.defence );
        if( aDefender.hp > 0 && aDefender.canCounterAttack )
        {
            aDefender.canCounterAttack = false;
            hp = hp - damageCalculator.calculateDamage( aDefender, defence );
        }
    }
}
