import java.sql.Connection;
import java.sql.DriverManager;

public class DAObese implements DAO {

    public Connection getConnection() {
        String URL="jdbc:sqlserver://localhost:1433;databaseName=plant;encrypt=false";
        Connection con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(URL,"han","123456");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}