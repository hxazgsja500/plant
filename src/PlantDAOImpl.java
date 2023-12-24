import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlantDAOImpl implements PlantDAO {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=plant;encrypt=false";
    private static final String JDBC_USER = "han";
    private static final String JDBC_PASSWORD = "123456";

    private Connection connection;

    public PlantDAOImpl() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Plant> getAllPlants() {
        //查询所有植物信息
        List<Plant> plants = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM Plants";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Plant plant = new Plant();
                plant.setPlantID(resultSet.getInt("PlantID"));
                plant.setDiseaseName(resultSet.getString("DiseaseName"));
                plant.setAlias(resultSet.getString("Alias"));
                plant.setFamilyName(resultSet.getString("FamilyName"));
                plant.setSpeciesName(resultSet.getString("SpeciesName"));
                plant.setMorphologicalFeatures(resultSet.getString("MorphologicalFeatures"));
                plant.setCultivationTechniques(resultSet.getString("CultivationTechniques"));
                plant.setApplicationValue(resultSet.getString("ApplicationValue"));
                plant.setImageID(resultSet.getInt("ImageID"));

                plants.add(plant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plants;
    }
    //根据ID查询植物信息
    @Override
    public Plant getPlantByID(int plantID) {
        Plant plant = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "SELECT * FROM Plants WHERE PlantID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, plantID);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    plant = new Plant();
                    plant.setPlantID(resultSet.getInt("PlantID"));
                    plant.setDiseaseName(resultSet.getString("DiseaseName"));
                    plant.setAlias(resultSet.getString("Alias"));
                    plant.setFamilyName(resultSet.getString("FamilyName"));
                    plant.setSpeciesName(resultSet.getString("SpeciesName"));
                    plant.setMorphologicalFeatures(resultSet.getString("MorphologicalFeatures"));
                    plant.setCultivationTechniques(resultSet.getString("CultivationTechniques"));
                    plant.setApplicationValue(resultSet.getString("ApplicationValue"));
                    plant.setImageID(resultSet.getInt("ImageID"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plant;
    }

    // 其他操作方法等

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

