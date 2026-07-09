import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    // 查询所有学生
    // 查询所有学生
    public List<JdbcStudent> findAll() throws Exception {
        String sql = "select id, name, age, phone, create_time from student";

        List<JdbcStudent> students = new ArrayList<>();

        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                JdbcStudent student = new JdbcStudent();

                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreateTime(resultSet.getString("create_time"));

                students.add(student);
            }
        }

        return students;
    }

    // 根据学号查询学生
    // 根据学号查询学生
    public JdbcStudent findById(String id) throws Exception {
        String sql = "select id, name, age, phone, create_time from student where id = ?";

        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    JdbcStudent student = new JdbcStudent();

                    student.setId(resultSet.getString("id"));
                    student.setName(resultSet.getString("name"));
                    student.setAge(resultSet.getInt("age"));
                    student.setPhone(resultSet.getString("phone"));
                    student.setCreateTime(resultSet.getString("create_time"));

                    return student;
                }
            }
        }

        return null;
    }
    // 新增学生
    // 新增学生
    public int add(JdbcStudent student) throws Exception {
        String sql = "insert into student(id, name, age, phone, create_time) values (?, ?, ?, ?, now())";

        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getPhone());

            return preparedStatement.executeUpdate();
        }
    }

    // 修改学生
    // 修改学生
    public int update(JdbcStudent student) throws Exception {
        String sql = "update student set name = ?, age = ?, phone = ? where id = ?";

        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setString(4, student.getId());

            return preparedStatement.executeUpdate();
        }
    }

    // 删除学生
    // 删除学生
    public int delete(String id) throws Exception {
        String sql = "delete from student where id = ?";

        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, id);

            return preparedStatement.executeUpdate();
        }
    }
}