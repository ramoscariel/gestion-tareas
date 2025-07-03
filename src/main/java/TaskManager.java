import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<String> tasks = new ArrayList<>();

    public void addTask(String taskDescription) {
        if (taskDescription == null || taskDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        if (tasks.contains(taskDescription)) {
            throw new IllegalArgumentException("Duplicate task.");
        }
        tasks.add(taskDescription);
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }

    public String removeTask(int index) {
        if (index < 1 || index > tasks.size()) {
            throw new IndexOutOfBoundsException("Invalid task ID.");
        }
        return tasks.remove(index - 1);
    }
}