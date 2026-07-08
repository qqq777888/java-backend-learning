import java.util.List;
import java.util.Scanner;

public class JdbcStudentManager {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDao studentDao = new StudentDao();

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("===== 数据库学生管理系统 =====");
            System.out.println("1. 查询所有学生");
            System.out.println("2. 根据学号查询学生");
            System.out.println("3. 新增学生");
            System.out.println("4. 修改学生");
            System.out.println("5. 删除学生");
            System.out.println("0. 退出");
            System.out.print("请输入选择：");

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    queryAllStudents();
                    break;
                case "2":
                    queryStudentById();
                    break;
                case "3":
                    addStudent();
                    break;
                case "4":
                    updateStudent();
                    break;
                case "5":
                    deleteStudent();
                    break;
                case "0":
                    System.out.println("系统已退出");
                    return;
                default:
                    System.out.println("输入错误，请重新选择");
            }
        }
    }

    private static void queryAllStudents() throws Exception {
        List<JdbcStudent> students = studentDao.findAll();

        if (students.isEmpty()) {
            System.out.println("暂无学生数据");
            return;
        }

        for (JdbcStudent student : students) {
            System.out.println(student);
        }
    }

    private static void queryStudentById() throws Exception {
        System.out.print("请输入学号：");
        String id = scanner.next();

        JdbcStudent student = studentDao.findById(id);

        if (student == null) {
            System.out.println("没有找到该学生");
        } else {
            System.out.println(student);
        }
    }

    private static void addStudent() throws Exception {
        System.out.print("请输入学号：");
        String id = scanner.next();

        JdbcStudent existStudent = studentDao.findById(id);
        if (existStudent != null) {
            System.out.println("该学号已存在，不能重复添加");
            return;
        }

        System.out.print("请输入姓名：");
        String name = scanner.next();

        System.out.print("请输入年龄：");
        int age = scanner.nextInt();

        System.out.print("请输入手机号：");
        String phone = scanner.next();

        JdbcStudent student = new JdbcStudent();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setPhone(phone);

        int rows = studentDao.add(student);

        if (rows > 0) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
    }

    private static void updateStudent() throws Exception {
        System.out.print("请输入要修改的学号：");
        String id = scanner.next();

        JdbcStudent existStudent = studentDao.findById(id);
        if (existStudent == null) {
            System.out.println("该学生不存在，无法修改");
            return;
        }

        System.out.print("请输入新姓名：");
        String name = scanner.next();

        System.out.print("请输入新年龄：");
        int age = scanner.nextInt();

        System.out.print("请输入新手机号：");
        String phone = scanner.next();

        JdbcStudent student = new JdbcStudent();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setPhone(phone);

        int rows = studentDao.update(student);

        if (rows > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    private static void deleteStudent() throws Exception {
        System.out.print("请输入要删除的学号：");
        String id = scanner.next();

        JdbcStudent existStudent = studentDao.findById(id);
        if (existStudent == null) {
            System.out.println("该学生不存在，无法删除");
            return;
        }

        int rows = studentDao.delete(id);

        if (rows > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}