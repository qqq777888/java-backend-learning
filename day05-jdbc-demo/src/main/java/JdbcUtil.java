import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    static {
        try {
            Properties properties = new Properties();

            InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");

            properties.load(inputStream);

            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取数据库连接
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }

    // 关闭资源：查询用
    public static void close(ResultSet resultSet, Statement statement, Connection connection) throws Exception {
        if (resultSet != null) {
            resultSet.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

    // 关闭资源：新增、修改、删除用
    public static void close(Statement statement, Connection connection) throws Exception {
        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
}