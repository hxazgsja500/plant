import java.util.List;

public interface MonitoringDAO {
    List<Monitoring> getAllMonitoring();
    Monitoring getMonitoringByID(int monitoringID);

    // 其他操作根据需要添加
}
