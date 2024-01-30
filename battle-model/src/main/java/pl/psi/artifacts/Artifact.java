package pl.psi.artifacts;


public class Artifact {
    private int id;
    private String name;
    private int power;
    private String imageURL;
    private ArtifactSlots slot;
    private ArtifactClass artifactClass;
    private String effect;


    public Artifact(String name, int power,/* String imageURL,*/ ArtifactSlots aSlot, ArtifactClass artifactClass,  String effect) {
        this.name = name;
        this.power = power;
//        this.imageURL = imageURL;
        this.slot = aSlot;
        this.artifactClass = artifactClass;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getImageURL() {
        return imageURL;
    }

    public ArtifactClass getArtifactClass() {
        return artifactClass;
    }

    public String getEffect() {
        return effect;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setSlot(String slot) {
        this.slot = ArtifactSlots.valueOf(slot);
    }

    public void setArtifactClass(String artifactClass) {
        this.artifactClass = ArtifactClass.valueOf(artifactClass);
    }


    public void setEffect(String effect) {
        this.effect = effect;
    }


    public ArtifactSlots getSlot() {
        return this.slot;
    }
}
