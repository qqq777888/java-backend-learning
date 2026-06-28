import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("====== 学生管理系统 ======");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 修改学生");
            System.out.println("4. 查询所有学生");
            System.out.println("5. 根据学号查询学生");
            System.out.println("0. 退出系统");
            System.out.print("请输入操作编号：");

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    deleteStudent();
                    break;
                case "3":
                    updateStudent();
                    break;
                case "4":
                    listStudents();
                    break;
                case "5":
                    findStudentById();
                    break;
                case "0":
                    System.out.println("系统已退出");
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }

    private static void addStudent() {
        System.out.print("请输入学号：");
        String id = scanner.next();

        if (getStudentById(id) != null) {
            System.out.println("学号已存在，添加失败");
            return;
        }

        System.out.print("请输入姓名：");
        String name = scanner.next();

        System.out.print("请输入年龄：");
        int age = scanner.nextInt();

        System.out.print("请输入手机号：");
        String phone = scanner.next();

        students.add(new Student(id, name, age, phone));
        System.out.println("添加成功");
    }

    private static void deleteStudent() {
        System.out.print("请输入要删除的学号：");
        String id = scanner.next();

        Student student = getStudentById(id);
        if (student == null) {
            System.out.println("学生不存在，删除失败");
            return;
        }

        students.remove(student);
        System.out.println("删除成功");
    }

    private static void updateStudent() {
        System.out.print("请输入要修改的学号：");
        String id = scanner.next();

        Student student = getStudentById(id);
        if (student == null) {
            System.out.println("学生不存在，修改失败");
            return;
        }

        System.out.print("请输入新姓名：");
        String name = scanner.next();

        System.out.print("请输入新年龄：");
        int age = scanner.nextInt();

        System.out.print("请输入新手机号：");
        String phone = scanner.next();

        student.setName(name);
        student.setAge(age);
        student.setPhone(phone);

        System.out.println("修改成功");
    }

    private static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("暂无学生数据");
            return;
        }

        for (Student student : students) {
            System.out.println(
                    "学号：" + student.getId()
                            + "，姓名：" + student.getName()
                            + "，年龄：" + student.getAge()
                            + "，手机号：" + student.getPhone()
            );
        }
    }

    private static void findStudentById() {
        System.out.print("请输入要查询的学号：");
        String id = scanner.next();

        Student student = getStudentById(id);
        if (student == null) {
            System.out.println("学生不存在");
            return;
        }

        System.out.println(
                "学号：" + student.getId()
                        + "，姓名：" + student.getName()
                        + "，年龄：" + student.getAge()
                        + "，手机号：" + student.getPhone()
        );
    }

    private static Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}