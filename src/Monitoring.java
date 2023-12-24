import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Monitoring {
    private int monitoringID;
    private LocalDateTime monitoringTime;
    private String personnel;
    private String location;
    private int objectID;
    private int deviceID;

    public int getMonitoringID() {
        return monitoringID;
    }

    public void setMonitoringID(int monitoringID) {
        this.monitoringID = monitoringID;
    }

    public LocalDateTime getMonitoringTime() {
        return monitoringTime;
    }

    public void setMonitoringTime(LocalDateTime monitoringTime) {
        this.monitoringTime = monitoringTime;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }
    //输出时的写法
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return "Monitoring{" +
                "monitoringID=" + monitoringID +
                ", monitoringTime=" + (monitoringTime != null ? monitoringTime.format(formatter) : null) +
                ", personnel='" + personnel + '\'' +
                ", location='" + location + '\'' +
                ", objectID=" + objectID +
                ", deviceID=" + deviceID +
                '}';
    }
    // 根据需要添加其他属性和方法
}

