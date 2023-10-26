// ******************************************************************
//
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
// ******************************************************************

package pl.psi;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class DamageCalculator {


    int calculateDamage( Creature aAttacker, int aDefence )
    {
        int delta = aAttacker.getAttack() - aDefence;
        if( delta >= 0 )
        {
            return aAttacker.getDamage() + (int)(delta * 0.05 * aAttacker.getDamage());
        }
        else
        {
            return aAttacker.getDamage() + (int)(delta * 0.025 * aAttacker.getDamage());
        }
    }
}
