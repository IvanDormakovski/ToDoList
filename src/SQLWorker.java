import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SQLWorker {

    public void addNewTask(String name, String description) {
        try (Connection connection = JDBCConnection.getConnection()) {
            String sqlRequest = "INSERT tasks (Task, Description, isDone, addDate) Values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setBoolean(3, false);
//            preparedStatement.setDate(4, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date())));
            preparedStatement.setObject(4, new Timestamp(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Task> showAllTasks() {
        List<Task> taskArrayList = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection()) {
            String sqlRequest = "SELECT * FROM tasks";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String task = resultSet.getString("Task");
                String description = resultSet.getString("Description");
                boolean isDone = resultSet.getBoolean("isDone");
                Date addDate = resultSet.getDate("addDate");
                taskArrayList.add(new Task(id, task, description, isDone, addDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskArrayList;
    }

    public void deleteTask(int id) {
        try (Connection connection = JDBCConnection.getConnection()) {
            String sqlRequest = "DELETE FROM tasks WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void renameTask(int id, String newTaskName) {
        try (Connection connection = JDBCConnection.getConnection()) {
            String sqlRequest = "UPDATE tasks SET Task = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setString(1, newTaskName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectCompletedTask(int id) {
        try (Connection connection = JDBCConnection.getConnection()) {
            String sqlRequest = "UPDATE tasks SET isDone = true WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
