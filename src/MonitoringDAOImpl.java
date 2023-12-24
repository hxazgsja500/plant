import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MonitoringDAOImpl implements MonitoringDAO {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=plant;encrypt=false";
    private static final String JDBC_USER = "han";
    private static final String JDBC_PASSWORD = "123456";

    private Connection connection;

    public MonitoringDAOImpl() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Monitoring> getAllMonitoring() {
        List<Monitoring> monitoringList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM Monitoring";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Monitoring monitoring = new Monitoring();
                monitoring.setMonitoringID(resultSet.getInt("MonitoringID"));
                monitoring.setMonitoringTime(resultSet.getTimestamp("MonitoringTime").toLocalDateTime());
                monitoring.setPersonnel(resultSet.getString("Personnel"));
                monitoring.setLocation(resultSet.getString("Location"));
                monitoring.setObjectID(resultSet.getInt("ObjectID"));
                monitoring.setDeviceID(resultSet.getInt("DeviceID"));
                // 根据表结构添加其他属性
                monitoringList.add(monitoring);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return monitoringList;
    }

    @Override
    public Monitoring getMonitoringByID(int monitoringID) {
        // 实现根据ID查询单个监测信息的方法，类似于 getAllMonitoring 方法
        // 省略具体实现
        return null;
    }

    // 其他操作方法根据需要添加

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

