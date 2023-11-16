// ******************************************************************
//  
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//  
// ******************************************************************

package pl.psi;

import java.beans.PropertyChangeEvent;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class DoubleDamageAfterTurnCreature extends Creature
{
    private final Creature decorated;

    public DoubleDamageAfterTurnCreature( Creature aCreature )
    {
        decorated = aCreature;
    }

    @Override
    public int getAttack()
    {
        return decorated.getAttack();
    }

    @Override
    public int getDefence()
    {
        return decorated.getDefence();
    }

    @Override
    public int getDamage()
    {
        return decorated.getDamage();
    }

    @Override
    public int getHp()
    {
        return decorated.getHp();
    }

    @Override
    public int getCurrentHp()
    {
        return decorated.getCurrentHp();
    }

    @Override
    public int getMoveRange()
    {
        return decorated.getMoveRange();
    }

    @Override
    public DamageCalculator getDamageCalculator()
    {
        return decorated.getDamageCalculator();
    }

    @Override
    public boolean isCanCounterAttack()
    {
        return decorated.isCanCounterAttack();
    }

    @Override
    public void attack( Creature aDefender )
    {
        decorated.attack( aDefender );
    }

    @Override
    protected void setCurrentHp( int currentHp )
    {
        decorated.setCurrentHp( currentHp );
    }

    @Override
    public void propertyChange( PropertyChangeEvent aEvent )
    {
        if( aEvent.getPropertyName()
            .equals( TurnQueue.END_OF_TURN ) )
        {
            decorated.setDamage( decorated.getDamage() * 2 );
        }
        decorated.propertyChange( aEvent );
    }
}
