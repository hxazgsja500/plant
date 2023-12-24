import java.time.LocalDateTime;

public class Maintenance {
    private int taskID;
    private String taskName;
    private LocalDateTime executionTime;
    private String executionLocation;
    private String personnel;
    private String taskDescription;
    private int maintenanceObjectID;

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalDateTime executionTime) {
        this.executionTime = executionTime;
    }

    public String getExecutionLocation() {
        return executionLocation;
    }

    public void setExecutionLocation(String executionLocation) {
        this.executionLocation = executionLocation;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getMaintenanceObjectID() {
        return maintenanceObjectID;
    }

    public void setMaintenanceObjectID(int maintenanceObjectID) {
        this.maintenanceObjectID = maintenanceObjectID;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "taskID=" + taskID +
                ", taskName='" + taskName + '\'' +
                ", executionTime=" + executionTime +
                ", executionLocation='" + executionLocation + '\'' +
                ", personnel='" + personnel + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", maintenanceObjectID=" + maintenanceObjectID +
                '}';
    }
}


