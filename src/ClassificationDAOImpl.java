import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassificationDAOImpl implements ClassificationDAO {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=plant;encrypt=false";
    private static final String JDBC_USER = "han";
    private static final String JDBC_PASSWORD = "123456";

    private Connection connection;

    public ClassificationDAOImpl() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Classification> getAllClassifications() {
        List<Classification> classifications = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM Classification";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Classification classification = new Classification();
                classification.setNodeID(resultSet.getInt("NodeID"));
                classification.setParentID(resultSet.getInt("ParentID"));
                classification.setScientificName(resultSet.getString("ScientificName"));
                classification.setCommonName(resultSet.getString("CommonName"));
                classification.setProvince(resultSet.getString("Province"));
                classification.setCity(resultSet.getString("City"));
                classification.setCounty(resultSet.getString("County"));
                classification.setGrowthEnvironment(resultSet.getString("GrowthEnvironment"));

                classifications.add(classification);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classifications;
    }

    @Override
    public Classification getClassificationByID(int nodeID) {
        // 实现根据 NodeID 查询植物分类信息的方法...
        // 类似于 getAllClassifications，只是需要在 SQL 语句中添加条件
        return null;
    }

    @Override
    public void insertClassification(Classification classification) {
        // 实现插入植物分类信息的方法...
    }

    @Override
    public void updateClassification(Classification classification) {
        // 实现更新植物分类信息的方法...
    }

    @Override
    public void deleteClassification(int nodeID) {
        // 实现删除植物分类信息的方法...
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

