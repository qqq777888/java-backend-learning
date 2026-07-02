import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class StudentManager {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static final HashMap<String, Student> studentMap = new HashMap<>();
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
        String id = inputStudentId();

        System.out.print("请输入姓名：");
        String name = scanner.next();

        int age = inputAge();

        String phone = inputPhone();

        Student student = new Student(id, name, age, phone);
        students.add(student);
        studentMap.put(id, student);
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
        studentMap.remove(id);
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

        int age = inputAge();

        String phone = inputPhone();

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
        return studentMap.get(id);
    }
    private static int inputAge() {
        while (true) {
            System.out.print("请输入年龄：");
            String ageStr = scanner.next();

            try {
                int age = Integer.parseInt(ageStr);

                if (age <= 0 || age > 120) {
                    System.out.println("年龄必须在 1 到 120 之间，请重新输入");
                    continue;
                }

                return age;
            } catch (NumberFormatException e) {
                System.out.println("年龄必须是数字，请重新输入");
            }
        }

    }
    private static String inputPhone() {
        while (true) {
            System.out.print("请输入手机号：");
            String phone = scanner.next();

            if (phone.length() != 11) {
                System.out.println("手机号必须是 11 位，请重新输入");
                continue;
            }

            boolean allDigit = true;
            for (int i = 0; i < phone.length(); i++) {
                char c = phone.charAt(i);
                if (c < '0' || c > '9') {
                    allDigit = false;
                    break;
                }
            }

            if (!allDigit) {
                System.out.println("手机号只能包含数字，请重新输入");
                continue;
            }

            return phone;

        }
    }
    private static String inputStudentId() {
        while (true) {
            System.out.print("请输入学号：");
            String id = scanner.next();

            if (id.length() < 3) {
                System.out.println("学号长度不能小于 3 位，请重新输入");
                continue;
            }

            if (getStudentById(id) != null) {
                System.out.println("学号已存在，请重新输入");
                continue;
            }

            return id;
        }
    }
}