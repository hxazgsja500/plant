import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlantCareDAOImpl implements PlantCareDAO {
    private Connection connection;

    // 构造方法中初始化数据库连接等操作

    @Override
    public List<PlantCare> getAllPlantCare() {
        List<PlantCare> plantCareList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PlantCare");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                PlantCare plantCare = new PlantCare();
                plantCare.setCareID(resultSet.getInt("CareID"));
                plantCare.setPlantID(resultSet.getInt("PlantID"));
                plantCare.setCareStrategy(resultSet.getString("CareStrategy"));
                plantCareList.add(plantCare);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plantCareList;
    }

    // 其他操作方法的实现
}

