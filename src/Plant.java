public class Plant {
    private int plantID;
    private String diseaseName;
    private String alias;
    private String familyName;
    private String speciesName;
    private String morphologicalFeatures;
    private String cultivationTechniques;
    private String applicationValue;
    private int imageID;

    public void setPlantID(int plantID) {
        this.plantID = plantID;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public void setMorphologicalFeatures(String morphologicalFeatures) {
        this.morphologicalFeatures = morphologicalFeatures;
    }

    public void setCultivationTechniques(String cultivationTechniques) {
        this.cultivationTechniques = cultivationTechniques;
    }

    public void setApplicationValue(String applicationValue) {
        this.applicationValue = applicationValue;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
    @Override
    public String toString() {
        return "Plant{" +
                "plantID=" + plantID +
                ", diseaseName='" + diseaseName + '\'' +
                ", alias='" + alias + '\'' +
                ", familyName='" + familyName + '\'' +
                ", speciesName='" + speciesName + '\'' +
                ", morphologicalFeatures='" + morphologicalFeatures + '\'' +
                ", cultivationTechniques='" + cultivationTechniques + '\'' +
                ", applicationValue='" + applicationValue + '\'' +
                ", imageID=" + imageID +
                '}';
    }
}
