public class Student {
    private String id;
    private String name;
    private double math;
    private double english;
    private double computer;

    public Student() {
    }

    public Student(String id, String name, double math, double english, double computer) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.english = english;
        this.computer = computer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getComputer() {
        return computer;
    }

    public void setComputer(double computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", math=" + math +
                ", english=" + english +
                ", computer=" + computer +
                '}';
    }
}
