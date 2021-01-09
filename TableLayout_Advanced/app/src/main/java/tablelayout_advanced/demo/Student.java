package tablelayout_advanced.demo;

public class Student {
    private static int idCounter = 0;
    private String id;
    private String name;
    private String major;

    public Student(String name, String major) {
        this.id = String.valueOf(idCounter++);
        this.name = name;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }
}
