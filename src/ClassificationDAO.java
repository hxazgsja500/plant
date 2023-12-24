import java.util.List;

public interface ClassificationDAO {
    List<Classification> getAllClassifications();
    Classification getClassificationByID(int nodeID);
    void insertClassification(Classification classification);
    void updateClassification(Classification classification);
    void deleteClassification(int nodeID);
}

