import java.util.List;

public interface MonitoringResultsDAO {
    List<MonitoringResult> getAllResults();
    void insertResult(MonitoringResult result);
    void updateResult(MonitoringResult result);
    void deleteResult(int resultID);
}

