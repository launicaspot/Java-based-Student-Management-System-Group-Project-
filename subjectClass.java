//Class stores data about a subject

public class Subject
  {
    private String subjectName;      //Name of the subject
    private Double subjectGrade;     //Holds grade

    public Subject(String name, Double grade)
    {
      subjectName = name;
      subjectGrade = grade;
    }
    public String getName() 
    { 
      return name; 
    }

    public final void setName(String name) 
    {
        if (name == null || name.isBlank()) 
        {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }
        this.name = name.trim();
    }
