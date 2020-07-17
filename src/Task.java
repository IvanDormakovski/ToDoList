import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task {
    private int id;
    private String name;
    private String description;
    private boolean isDone;
    private Date taskAddDate;


    public Task(int id, String name, String description, boolean isDone, Date taskAddDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isDone = isDone;
        this.taskAddDate = taskAddDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public Date getTaskAddDate() {
        return taskAddDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", isDone=" + isDone +
                ", taskAddDate='" + taskAddDate + '\'' +
                '}';
    }
}
