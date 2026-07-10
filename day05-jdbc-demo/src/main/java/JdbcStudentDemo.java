import com.cc2022111694.dao.StudentDao;
import com.cc2022111694.entity.JdbcStudent;

import java.util.List;

public class JdbcStudentDemo {

    public static void main(String[] args) throws Exception {
        StudentDao studentDao = new StudentDao();

        // 1. 查询所有
        List<JdbcStudent> jdbcStudents = studentDao.findAll();
        for (JdbcStudent jdbcStudent : jdbcStudents) {
            System.out.println(jdbcStudent);
        }

        // 2. 根据 id 查询
        // Student student = studentDao.findById("001");
        // System.out.println(student);

        // 3. 新增
        // Student student = new Student();
        // student.setId("008");
        // student.setName("钱十二");
        // student.setAge(28);
        // student.setPhone("12900000000");
        // int rows = studentDao.add(student);
        // System.out.println("新增影响行数：" + rows);

        // 4. 修改
        // Student student = new Student();
        // student.setId("008");
        // student.setName("钱十三");
        // student.setAge(29);
        // student.setPhone("12800000000");
        // int rows = studentDao.update(student);
        // System.out.println("修改影响行数：" + rows);

        // 5. 删除
        // int rows = studentDao.delete("008");
        // System.out.println("删除影响行数：" + rows);
    }
}