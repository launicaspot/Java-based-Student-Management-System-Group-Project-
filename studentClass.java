import java.util.*;

public class StudentClass {
    private String id;
    priv
ate String name;
    private List<Subject> subjects;

    public StudentClass(String id, String name) {
        this.id = id;
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addOrUpdateSubject(String subjectName, double grade) {
        for (Subject s : subjects) {
            if (s.getName().equalsIgnoreCase(subjectName)) {
                s.setGrade(grade);
                return;
            }
        }
        subjects.add(new Subject(subjectName, grade));
    }

    public double getAverageGrade() {
        if (subjects.isEmpty()) return 0;
        double total = 0;
        for (Subject s : subjects) {
            total += s.getGrade();
        }
        return total / subjects.size();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Avg Grade: " + String.format("%.2f", getAverageGrade());
    }

    public String toFileString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",").append(name);
        for (Subject s : subjects) {
            sb.append(",").append(s.getName()).append(":").append(s.getGrade());
        }
        return sb.toString();
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        Student student = new Student(parts[0], parts[1]);
        for (int i = 2; i < parts.length; i++) {
            String[] sub = parts[i].split(":");
            student.addOrUpdateSubject(sub[0], Double.parseDouble(sub[1]));
        }
        return student;
    }
}

