import java.util.List;

public interface PlantDAO {
    List<Plant> getAllPlants();
    Plant getPlantByID(int plantID);
    // 其他操作方法...
}


