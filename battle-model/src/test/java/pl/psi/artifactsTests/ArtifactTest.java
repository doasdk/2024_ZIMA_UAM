package pl.psi.artifactsTests;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.psi.Hero;

import pl.psi.artifacts.Artifact;
import pl.psi.artifacts.ArtifactClass;
import pl.psi.artifacts.ArtifactSlots;
import pl.psi.creatures.Creature;
import pl.psi.creatures.CreatureStats;


import java.util.ArrayList;
import java.util.List;



public class ArtifactTest {
    @Test
    void attackShouldBeIncreasedWhenArtifactWithAttackAbilityAppplied(){
        Artifact artifactAttack1 = new Artifact("Centaur's Ax", 2, ArtifactSlots.HAND, ArtifactClass.ATTACK, "Increases attack power");
        Artifact artifactAttack2 = new Artifact("Sword of Hellfire", 6, ArtifactSlots.HAND, ArtifactClass.ATTACK, "Increases attack power");

        List<Artifact> attackArtifactList = new ArrayList<>();
        attackArtifactList.add(artifactAttack1);
        attackArtifactList.add(artifactAttack2);
//        final Creature attacker = new Creature.Builder().statistic(CreatureStats.builder()
//                        .maxHp(100)
//                        .damage(Range.closed(10, 10))
//                        .attack(10)
//                        .armor(0)
//                        .build())
//                .build();
        final Creature attackerForRef = new Creature.Builder().statistic(CreatureStats.builder()
                        .maxHp(100)
                        .damage(Range.closed(10, 10))
                        .attack(10)
                        .armor(0)
                        .build())
                .build();
        Hero attackers = new Hero(List.of(/*attacker,*/ attackerForRef), attackArtifactList);
//  final Creature defender2 = new Creature.Builder().statistic(CreatureStats.builder()
//                        .maxHp(100)
//                        .damage(Range.closed(0, 0))
//                        .attack(0)
//                        .armor(0)
//                        .build())
//                .build();
  final Creature defender3 = new Creature.Builder().statistic(CreatureStats.builder()
                        .maxHp(100)
                        .damage(Range.closed(0, 0))
                        .attack(0)
                        .armor(0)
                        .build())
                .build();
//        attackers.getCreatures().get(0).attack(defender2); //10 + 5 added damage
//        assertThat(defender2.getCurrentHp()).isEqualTo(85);

        attackers.applyArtifacts(attackers.getCreatures().get(0));
        attackers.getCreatures().get(0).attack(defender3);
        assertThat(defender3.getCurrentHp()).isEqualTo(82);

    }



    @Test
    void armorShouldBeIncreasedWhenArtifactsApplied(){
        Artifact artifactAttack1 = new Artifact("Sentinel's Shield", 2, ArtifactSlots.HAND, ArtifactClass.ATTACK, "Increases attack power");
        Artifact artifactAttack2 = new Artifact("Sword of Hellfire", 6, ArtifactSlots.HAND, ArtifactClass.ATTACK, "Increases attack power");
        Artifact artifactAttack3 = new Artifact("Sentinel's Shield", 30, ArtifactSlots.LEFT_HAND, ArtifactClass.DEFENCE, "Increases armor power");

        List<Artifact> defenceArtifactList = new ArrayList<>();
        defenceArtifactList.add(artifactAttack1);
        defenceArtifactList.add(artifactAttack2);
        defenceArtifactList.add(artifactAttack3);



        final Creature defender1 = new Creature.Builder().statistic(CreatureStats.builder()
                        .maxHp(100)
                        .damage(Range.closed(0, 0))
                        .attack(0)
                        .armor(0)
                        .build())
                .build();

        Hero defenders = new Hero(List.of(defender1), defenceArtifactList);
        defenders.applyArtifacts(defenders.getCreatures().get(0));
        assertThat(defender1.getAmount()).isEqualTo(30);



    }


}
