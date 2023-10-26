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
public class ReduceArmorDamageCalculator extends DamageCalculator
{
    private final double factor;

    public ReduceArmorDamageCalculator( double aFactor )
    {
        super();
        factor = aFactor;
    }

    @Override
    int calculateDamage( Creature aAttacker, int aDefence )
    {
        return super.calculateDamage( aAttacker, (int)(aDefence * factor) );
    }
}
