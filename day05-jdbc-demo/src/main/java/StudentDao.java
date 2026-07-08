import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    // 查询所有学生
    public List<Student> findAll() throws Exception {
        Connection connection = JdbcUtil.getConnection();

        String sql = "select id, name, age, phone, create_time from student";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> students = new ArrayList<>();

        while (resultSet.next()) {
            Student student = new Student();

            student.setId(resultSet.getString("id"));
            student.setName(resultSet.getString("name"));
            student.setAge(resultSet.getInt("age"));
            student.setPhone(resultSet.getString("phone"));
            student.setCreateTime(resultSet.getString("create_time"));

            students.add(student);
        }

        JdbcUtil.close(resultSet, preparedStatement, connection);

        return students;
    }

    // 根据学号查询学生
    public Student findById(String id) throws Exception {
        Connection connection = JdbcUtil.getConnection();

        String sql = "select id, name, age, phone, create_time from student where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        Student student = null;

        if (resultSet.next()) {
            student = new Student();

            student.setId(resultSet.getString("id"));
            student.setName(resultSet.getString("name"));
            student.setAge(resultSet.getInt("age"));
            student.setPhone(resultSet.getString("phone"));
            student.setCreateTime(resultSet.getString("create_time"));
        }

        JdbcUtil.close(resultSet, preparedStatement, connection);

        return student;
    }

    // 新增学生
    public int add(Student student) throws Exception {
        Connection connection = JdbcUtil.getConnection();

        String sql = "insert into student(id, name, age, phone, create_time) values (?, ?, ?, ?, now())";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, student.getId());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.setString(4, student.getPhone());

        int rows = preparedStatement.executeUpdate();

        JdbcUtil.close(preparedStatement, connection);

        return rows;
    }

    // 修改学生
    public int update(Student student) throws Exception {
        Connection connection = JdbcUtil.getConnection();

        String sql = "update student set name = ?, age = ?, phone = ? where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, student.getAge());
        preparedStatement.setString(3, student.getPhone());
        preparedStatement.setString(4, student.getId());

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