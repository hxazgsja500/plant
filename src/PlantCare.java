public class PlantCare {
    private int careID;
    private int plantID;
    private String careStrategy;

    public int getCareID() {
        return careID;
    }

    public void setCareID(int careID) {
        this.careID = careID;
    }

    public int getPlantID() {
        return plantID;
    }

    public void setPlantID(int plantID) {
        this.plantID = plantID;
    }

    public String getCareStrategy() {
        return careStrategy;
    }

    public void setCareStrategy(String careStrategy) {
        this.careStrategy = careStrategy;
    }

    @Override
    public String toString() {
        return "PlantCare{" +
                "careID=" + careID +
                ", plantID=" + plantID +
                ", careStrategy='" + careStrategy + '\'' +
                '}';
    }
}


