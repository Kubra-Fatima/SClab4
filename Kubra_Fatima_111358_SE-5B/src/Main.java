import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Hp-pc on 3/15/2017.
 */
public class Main {
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://localhost/";
        String DB_USER = "root";
        String DB_PASS = "helloworld";

        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reservation.cust ");

            while(rs.next())
                System.out.println(rs.getString("first_name"));

        } catch(Exception e){
            e.printStackTrace();
        } finally {

        }
    }
}
