import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Student> studentMap = new HashMap<>();

        Student s1 = new Student("001", "张三", 18, "13800000000");
        Student s2 = new Student("002", "李四", 20, "13900000000");

        studentMap.put(s1.getId(), s1);
        studentMap.put(s2.getId(), s2);

        Student student = studentMap.get("001");

        if (student != null) {
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getPhone());
        } else {
            System.out.println("学生不存在");
        }
    }
}