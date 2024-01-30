package pl.psi;

import java.util.List;
import java.util.Map;

import pl.psi.artifacts.Artifact;
import pl.psi.creatures.Creature;

import lombok.Getter;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class Hero
{
    @Getter
    private final List< Creature > creatures;
//    private final Map<Creature, List<Artifact>> mapForArtifacts;
    private final List<Artifact> artifactsList;
    public Hero( final List<Creature> aCreatures, List<Artifact> aArtifactsList )
    {
        creatures = aCreatures;
        this.artifactsList = aArtifactsList;

    }


    public void applyArtifacts(Creature aCreatureToApplyArtifact){

        for (Artifact artifact : artifactsList) {
            if (aCreatureToApplyArtifact.equipOnCreature(artifact)) {
                switch (artifact.getArtifactClass()) {
                    case ATTACK:
                        aCreatureToApplyArtifact.increaseAttackDamage(artifact.getPower());
                    case DEFENCE:
                        aCreatureToApplyArtifact.increaseDefence(artifact.getPower());

                }

            }
        }
    }



}
