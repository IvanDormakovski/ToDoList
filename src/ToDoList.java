import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private String dataBase = "c:\\Users\\Admin\\IdeaProjects\\ToDoList\\DataBase.txt";
    private List<Task> tasks = new ArrayList<>();

    {
        try (BufferedReader readerDataBase = new BufferedReader(new FileReader(dataBase))) {
            while (readerDataBase.ready()) {
                tasks.add(new Task(readerDataBase.readLine(), Boolean.parseBoolean(readerDataBase.readLine()), readerDataBase.readLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        boolean isWork = true;
        while (isWork) {
            ConsoleHelper.write("Choose operation: \n 1) Add new task \n 2) Show task list \n " +
                    "3) Select completed task \n 4) Delete task \n 5) Rename task \n 0) Exit");
            int numberOperation = ConsoleHelper.readInt();
            switch (numberOperation) {
                case 1:
                    addNewTask();
                    break;
                case 2:
                    showTaskList();
                    break;
                case 3:
                    selectCompletedTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    renameTask();
                    break;
                case 0:
                    exit();
                    isWork = false;
            }
        }
    }

    public void addNewTask() {
        ConsoleHelper.write("Write your task:");
        tasks.add(new Task(ConsoleHelper.readString()));
    }

    public void showTaskList() {
        ConsoleHelper.write("Choose operation: \n 1) Show all tasks \n 2) Show all done tasks \n 3) Show all isn't done tasks \n 0) Back");
        int numberOperation = ConsoleHelper.readInt();
        switch (numberOperation) {
            case 1:
                showAllTasks();
                break;
            case 2:
                showAllDoneTasks();
                break;
            case 3:
                showAllNotDoneTasks();
                break;
            case 0:
                break;
        }
    }

    public void showAllTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            ConsoleHelper.write("ID=" + i + " " + tasks.get(i).toString());
        }
    }

    public void showAllDoneTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isDone()) {
                ConsoleHelper.write("ID=" + i + " " + tasks.get(i).toString());
            }
        }
    }

    public void showAllNotDoneTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            if (!tasks.get(i).isDone()) {
                ConsoleHelper.write("ID=" + i + " " + tasks.get(i).toString());
            }
        }
    }

    public void selectCompletedTask() {
        ConsoleHelper.write("Enter ID to select completed task:");
        showAllNotDoneTasks();
        int id = ConsoleHelper.readInt();
        if (!tasks.get(id).isDone()) {
            tasks.get(id).setDone(true);
        }
    }

    public void deleteTask() {
        ConsoleHelper.write("Enter ID to delete:");
        showAllTasks();
        int id = ConsoleHelper.readInt();
        tasks.remove(id);
    }

    public void renameTask() {
        ConsoleHelper.write("Enter ID to rename:");
        showAllTasks();
        int id = ConsoleHelper.readInt();
        tasks.get(id).setName(ConsoleHelper.readString());
    }

    public void exit() {
        try (BufferedWriter writerDataBase = new BufferedWriter(new FileWriter(dataBase))) {
            for (int i = 0; i < tasks.size(); i++) {
                writerDataBase.write(tasks.get(i).getName());
                writerDataBase.newLine();
                writerDataBase.write(String.valueOf(tasks.get(i).isDone()));
                writerDataBase.newLine();
                writerDataBase.write(tasks.get(i).getTaskAddDate());
                writerDataBase.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConsoleHelper.write("Good Bye. Have a nice day!");
    }
}
