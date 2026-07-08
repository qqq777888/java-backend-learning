import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/java_backend_learning?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
        String username = "root";
        String password = "465778";

        // 1. 获取数据库连接
        Connection connection = DriverManager.getConnection(url, username, password);

        // 2. 编写删除 SQL
        String sql = "delete from student where id = ?";

        // 3. 创建 PreparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 4. 给 ? 设置具体值
        preparedStatement.setString(1, "006");

        // 5. 执行删除
        int rows = preparedStatement.executeUpdate();

        System.out.println("删除成功，影响行数：" + rows);

        // 6. 关闭资源
        preparedStatement.close();
        connection.close();
    }
}