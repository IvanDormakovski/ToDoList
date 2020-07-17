public class ToDoList {
    private SQLWorker sqlWorker = new SQLWorker();

    public void start() {
        boolean isWork = true;
        while (isWork) {
            ConsoleHelper.write("Choose operation: \n 1) Add new task \n 2) Show task list \n " +
                    "3) Delete task \n 4) Rename task \n 5) Select completed task \n 0) Exit");
            int numberOperation = ConsoleHelper.readInt();
            switch (numberOperation) {
                case 1:
                    addNewTask();
                    break;
                case 2:
                    showTaskList();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    renameTask();
                    break;
                case 5:
                    selectCompletedTask();
                    break;
                case 0:
                    exit();
                    isWork = false;
            }
        }
    }

    public void addNewTask() {
        ConsoleHelper.write("Write your task and press enter:");
        String task = ConsoleHelper.readString();
        ConsoleHelper.write("Write task's description and press enter:");
        String description = ConsoleHelper.readString();
        sqlWorker.addNewTask(task, description);
        ConsoleHelper.write("Task has been added.");
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
        for (Task task : sqlWorker.showAllTasks()) {
            ConsoleHelper.write(task.getId() + " | " + task.getName() + " | " + task.getDescription() +
                    " | " + task.isDone() + " | " + task.getTaskAddDate());
        }
    }

    public void showAllDoneTasks() {
        for (Task task : sqlWorker.showAllTasks()) {
            if (task.isDone()) {
                ConsoleHelper.write(task.getId() + " | " + task.getName() + " | " + task.getDescription() +
                        " | " + task.isDone() + " | " + task.getTaskAddDate());
            }
        }
    }

    public void showAllNotDoneTasks() {
        for (Task task : sqlWorker.showAllTasks()) {
            if (!task.isDone()) {
                ConsoleHelper.write(task.getId() + " | " + task.getName() + " | " + task.getDescription() +
                        " | " + task.isDone() + " | " + task.getTaskAddDate());
            }
        }
    }

    public void deleteTask() {
        ConsoleHelper.write("Choose operation: \n 1) Continue \n 0) Back");
        int numberOperation = ConsoleHelper.readInt();
        switch (numberOperation) {
            case 1:
                ConsoleHelper.write("Enter task's ID to delete:");
                showAllTasks();
                int id = ConsoleHelper.readInt();
                sqlWorker.deleteTask(id);
                ConsoleHelper.write("Task has been deleted.");
                break;
            case 0:
                break;
        }
    }

    public void renameTask() {
        ConsoleHelper.write("Choose operation: \n 1) Continue \n 0) Back");
        int numberOperation = ConsoleHelper.readInt();
        switch (numberOperation) {
            case 1:
                ConsoleHelper.write("Enter ID to rename:");
                showAllTasks();
                int id = ConsoleHelper.readInt();
                ConsoleHelper.write("Write the task's new name:");
                String newTaskName = ConsoleHelper.readString();
                sqlWorker.renameTask(id, newTaskName);
                ConsoleHelper.write("Task has been renamed.");
                break;
            case 0:
                break;
        }
    }

    public void selectCompletedTask() {
        ConsoleHelper.write("Choose operation: \n 1) Continue \n 0) Back");
        int numberOperation = ConsoleHelper.readInt();
        switch (numberOperation) {
            case 1:
                ConsoleHelper.write("Enter ID of the completed task:");
                showAllNotDoneTasks();
                int id = ConsoleHelper.readInt();
                sqlWorker.selectCompletedTask(id);
                ConsoleHelper.write("Task completed");
                break;
            case 0:
                break;
        }
    }

    public void exit() {
        ConsoleHelper.write("Good Bye. Have a nice day!");
    }
}
