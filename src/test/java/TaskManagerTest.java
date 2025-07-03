import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void testAddAndRetrieveTasks() {
        TaskManager manager = new TaskManager();
        manager.addTask("Buy groceries");
        manager.addTask("Clean room");
        assertEquals(2, manager.getTasks().size());
        assertTrue(manager.getTasks().contains("Buy groceries"));
    }

    @Test
    void testAddDuplicateTaskThrowsException() {
        TaskManager manager = new TaskManager();
        manager.addTask("Task A");
        assertThrows(IllegalArgumentException.class, () -> manager.addTask("Task A"));
    }

    @Test
    void testAddEmptyTaskThrowsException() {
        TaskManager manager = new TaskManager();
        assertThrows(IllegalArgumentException.class, () -> manager.addTask("  "));
    }

    @Test
    void testRemoveTaskValidId() {
        TaskManager manager = new TaskManager();
        manager.addTask("Do laundry");
        String removed = manager.removeTask(1);
        assertEquals("Do laundry", removed);
        assertEquals(0, manager.getTasks().size());
    }

    @Test
    void testRemoveTaskInvalidIdThrowsException() {
        TaskManager manager = new TaskManager();
        manager.addTask("Something");
        assertThrows(IndexOutOfBoundsException.class, () -> manager.removeTask(2));
    }
}