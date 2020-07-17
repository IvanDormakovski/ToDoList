import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class JDBCConnection {
    private static String url = "jdbc:mysql://localhost:3306/todolist?autoReconnect=true&useSSL=false&?serverTimezone= + TimeZone.getDefault().getID()";
    private static String user = "root";
    private static String password = "10Lin20PasX7q";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return connection;
    }
}