import java.util.List;

public interface MaintenanceDAO {

    List<Maintenance> getAllMaintenance();
    Maintenance getMaintenanceById(int taskID);
    void insertMaintenance(Maintenance maintenance);
    void updateMaintenance(Maintenance maintenance);
    void deleteMaintenance(int taskID);
}

