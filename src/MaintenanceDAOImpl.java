import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDAOImpl implements MaintenanceDAO {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=plant;encrypt=false";
    private static final String JDBC_USER = "han";
    private static final String JDBC_PASSWORD = "123456";

    private Connection connection;

    public MaintenanceDAOImpl() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Maintenance> getAllMaintenance() {
        // 实现查询所有养护任务的逻辑
        List<Maintenance> tasks = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM Maintenance";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Maintenance task = new Maintenance();
                task.setTaskID(resultSet.getInt("TaskID"));
                task.setTaskName(resultSet.getString("TaskName"));
                task.setExecutionTime(resultSet.getTimestamp("ExecutionTime").toLocalDateTime());
                task.setExecutionLocation(resultSet.getString("ExecutionLocation"));
                task.setPersonnel(resultSet.getString("Personnel"));
                task.setTaskDescription(resultSet.getString("TaskDescription"));
                task.setMaintenanceObjectID(resultSet.getInt("MaintenanceObjectID"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    @Override
    public Maintenance getMaintenanceById(int taskID) {
        return null;
    }


    @Override
    public void insertMaintenance(Maintenance task) {
        // 实现插入养护任务的逻辑
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Maintenance (TaskName, ExecutionTime, ExecutionLocation, Personnel, TaskDescription, MaintenanceObjectID) VALUES (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, task.getTaskName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(task.getExecutionTime()));
            preparedStatement.setString(3, task.getExecutionLocation());
            preparedStatement.setString(4, task.getPersonnel());
            preparedStatement.setString(5, task.getTaskDescription());
            preparedStatement.setInt(6, task.getMaintenanceObjectID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMaintenance(Maintenance task) {
        // 实现更新养护任务的逻辑
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Maintenance SET TaskName = ?, ExecutionTime = ?, ExecutionLocation = ?, Personnel = ?, TaskDescription = ?, MaintenanceObjectID = ? WHERE TaskID = ?")) {
            preparedStatement.setString(1, task.getTaskName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(task.getExecutionTime()));
            preparedStatement.setString(3, task.getExecutionLocation());
            preparedStatement.setString(4, task.getPersonnel());
            preparedStatement.setString(5, task.getTaskDescription());
            preparedStatement.setInt(6, task.getMaintenanceObjectID());
            preparedStatement.setInt(7, task.getTaskID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMaintenance(int taskID) {
        // 实现删除养护任务的逻辑
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM Maintenance WHERE TaskID = ?")) {
            preparedStatement.setInt(1, taskID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

