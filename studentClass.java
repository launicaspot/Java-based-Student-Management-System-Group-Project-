public class Student {
    private final String id;      // immutable unique ID
    private String name;
    private final Map<String, Subject> subjects = new HashMap<>(); // key: lowercased subject name

    public Student(String id, String name) 
    {
        if (id == null || id.isBlank()) 
            throw new IllegalArgumentException("ID required.");
        if (name == null || name.isBlank()) 
            throw new IllegalArgumentException("Name required.");
        this.id = id.trim();
        this.name = name.trim();
    }

    public String getId() 
    { 
        return id; 
    }

    public String getName() 
    {
        return name; 
    }

    public void setName(String name) 
    {
        if (name == null || name.isBlank()) 
            throw new IllegalArgumentException("Name required.");
        this.name = name.trim();
    }

