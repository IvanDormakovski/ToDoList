import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Task {
    private String name;
    private boolean isDone;
    private String taskAddDate;

    public Task(String name, boolean isDone, String taskAddDate) {
        this.name = name;
        this.isDone = isDone;
        this.taskAddDate = taskAddDate;
    }

    public Task(String name) {
        this.name = name;
        this.isDone = false;
        this.taskAddDate = new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getTaskAddDate() {
        return taskAddDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDone(boolean done) {
        isDone = done;
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
