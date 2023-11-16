// ******************************************************************
//  
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//  
// ******************************************************************

package pl.psi;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
@Getter
@Setter( AccessLevel.PROTECTED )
public class Creature implements PropertyChangeListener
{
    private int attack;
    private int defence;
    private int damage;
    private int hp;
    private int currentHp;
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
        currentHp = hp;
        damageCalculator = aDamageCalculator;
        moveRange = aMoveRange;
    }

    public Creature()
    {

    }

    public void attack( Creature aDefender )
    {
        int newCurrentHp =
            aDefender.getCurrentHp() - getDamageCalculator().calculateDamage( this, aDefender.getDefence() );
        aDefender.setCurrentHp( newCurrentHp );
        if( aDefender.getCurrentHp() > 0 && aDefender.isCanCounterAttack() )
        {
            aDefender.setCanCounterAttack( false );
            setCurrentHp( getDamageCalculator().calculateDamage( aDefender, getDefence() ) );
        }
    }

    @Override
    public void propertyChange( PropertyChangeEvent aEvent )
    {

    }
}
