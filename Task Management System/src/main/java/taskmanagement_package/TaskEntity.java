package taskmanagement_package;

public class TaskEntity {
	private int id;
    private String title;
    private String description;
    private String duedate;
    private String priority;
    private boolean completed;


    public TaskEntity(int id, String title,String description, String duedate, String priority, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duedate = duedate;
        this.priority = priority;
        this.completed = completed;
    }


    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getDuedate() {
        return duedate;
    }
    public String getPriority() {
        return priority;
    }
    public boolean getCompleted() {
        return completed;
    }
    
}
