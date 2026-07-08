import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    // 查询所有学生
    public List<JdbcStudent> findAll() throws Exception {
        Connection connection = JdbcUtil.getConnection();

        String sql = "select id, name, age, phone, create_time from student";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<JdbcStudent> jdbcStudents = new ArrayList<>();

        while (resultSet.next()) {
            JdbcStudent jdbcStudent = new JdbcStudent();

            jdbcStudent.setId(resultSet.getString("id"));
            jdbcStudent.setName(resultSet.getString("name"));
            jdbcStudent.setAge(resultSet.getInt("age"));
            jdbcStudent.setPhone(resultSet.getString("phone"));
            jdbcStudent.setCreateTime(resultSet.getString("create_time"));

            jdbcStudents.add(jdbcStudent);
        }

        JdbcUtil.close(resultSet, preparedStatement, connection);

        return jdbcStudents;
    }

    // 根据学号查询学生
    public JdbcStudent findById(String id) throws Exception {
        Connection connection = JdbcUtil.getConnection();

        String sql = "select id, name, age, phone, create_time from student where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        JdbcStudent jdbcStudent = null;

        if (resultSet.next()) {
            jdbcStudent = new JdbcStudent();

            jdbcStudent.setId(resultSet.getString("id"));
            jdbcStudent.setName(resultSet.getString("name"));
            jdbcStudent.setAge(resultSet.getInt("age"));
            jdbcStudent.setPhone(resultSet.getString("phone"));
            jdbcStudent.setCreateTime(resultSet.getString("create_time"));
        }

        JdbcUtil.close(resultSet, preparedStatement, connection);

        return jdbcStudent;
    }

    // 新增学生
    public int add(JdbcStudent jdbcStudent) throws Exception {
        Connection connection = JdbcUtil.getConnection();

        String sql = "insert into student(id, name, age, phone, create_time) values (?, ?, ?, ?, now())";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, jdbcStudent.getId());
        preparedStatement.setString(2, jdbcStudent.getName());
        preparedStatement.setInt(3, jdbcStudent.getAge());
        preparedStatement.setString(4, jdbcStudent.getPhone());

        int rows = preparedStatement.executeUpdate();

        JdbcUtil.close(preparedStatement, connection);

        return rows;
    }

    // 修改学生
    public int update(JdbcStudent jdbcStudent) throws Exception {
        Connection connection = JdbcUtil.getConnection();

        String sql = "update student set name = ?, age = ?, phone = ? where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, jdbcStudent.getName());
        preparedStatement.setInt(2, jdbcStudent.getAge());
        preparedStatement.setString(3, jdbcStudent.getPhone());
        preparedStatement.setString(4, jdbcStudent.getId());

        int rows = preparedStatement.executeUpdate();

        JdbcUtil.close(preparedStatement, connection);

        return rows;
    }

    // 删除学生
    public int delete(String id) throws Exception {
        Connection connection = JdbcUtil.getConnection();

        String sql = "delete from student where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, id);

        int rows = preparedStatement.executeUpdate();

        JdbcUtil.close(preparedStatement, connection);

        return rows;
    }
}