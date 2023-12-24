import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MonitoringResultsDAOImpl implements MonitoringResultsDAO {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=plant;encrypt=false";
    private static final String JDBC_USER = "han";
    private static final String JDBC_PASSWORD = "123456";

    public Connection connection;

    public MonitoringResultsDAOImpl() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MonitoringResult> getAllResults() {
        List<MonitoringResult> results = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM MonitoringResults";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                MonitoringResult result = new MonitoringResult();
                result.setResultID(resultSet.getInt("ResultID"));
                result.setMonitoringID(resultSet.getInt("MonitoringID"));
                result.setIndicatorID(resultSet.getInt("IndicatorID"));
                result.setResultValue(resultSet.getDouble("ResultValue"));
                results.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public void insertResult(MonitoringResult result) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO MonitoringResults (MonitoringID, IndicatorID, ResultValue) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, result.getMonitoringID());
            preparedStatement.setInt(2, result.getIndicatorID());
            preparedStatement.setDouble(3, result.getResultValue());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateResult(MonitoringResult result) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE MonitoringResults SET ResultValue = ? WHERE ResultID = ?")) {
            preparedStatement.setDouble(1, result.getResultValue());
            preparedStatement.setInt(2, result.getResultID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteResult(int resultID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM MonitoringResults WHERE ResultID = ?")) {
            preparedStatement.setInt(1, resultID);

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

