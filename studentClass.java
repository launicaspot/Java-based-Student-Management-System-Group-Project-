import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable
{
    private int id;
    private String name;
    private List<Subject> subjects;

    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
        this.subjects = new ArrayList<>();
    }


    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public List<Subject> getSubjects()
    {
        return subjects;
    }

    public void addSubject(Subject subject)
    {
        this.subjects.add(subject);
    }

    public double calculateAverageGrade()
    {
        if (subjects.isEmpty())
        {
            return 0.0;
        }
        double sum = 0;
        for (Subject subject : subjects)
        {
            sum += subject.getGrade();
        }
        return sum / subjects.size();
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Average Grade=" + String.format("%.2f", calculateAverageGrade()) +
                ", Subjects=" + subjects +
                '}';
    }
}
