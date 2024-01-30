package pl.psi.creatures;

import com.google.common.collect.Range;

import lombok.Builder;
import lombok.Getter;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
@Getter
@Builder
public class CreatureStats implements CreatureStatisticIf{
    private final String name;
    private final int attack;
    private int armor;
    private final int maxHp;
    private final int moveRange;
    private Range< Integer > damage;
    private final int tier;
    private final String description;
    private final boolean isUpgraded;

    @Override
    public void setDamage(Range<Integer> aDamage) {
        damage = aDamage;
    }

    @Override
    public void setArmor(int newArmor) {
        armor = newArmor;
    }
}
