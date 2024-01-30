package pl.psi.creatures;

import com.google.common.collect.Range;

public interface CreatureStatisticIf {
    String getName();
    int getAttack();
    int getArmor();
    int getMaxHp();
    int getMoveRange();
    Range< Integer > getDamage();
    void setDamage(final Range< Integer > aDamage);
    void setArmor(int newArmor);
    int getTier();
    String getDescription();
    boolean isUpgraded();
}
