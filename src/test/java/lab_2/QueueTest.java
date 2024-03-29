package lab_2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void add() {
        Queue queue = new Queue();

        // Add elements to the queue
        queue.add("First");
        queue.add("Second");
        queue.add("Third");

        // Check if elements are added correctly
        assertEquals("First", queue.remove());
        assertEquals("Second", queue.remove());
        assertEquals("Third", queue.remove());
    }

    @Test
    void remove_assert_throws() {
        Queue queue = new Queue();
        // Remove from an empty queue
        assertThrows(IllegalStateException.class, queue::remove);
    }

    @Test
    void remove() {
        Queue queue = new Queue();

        queue.add("One");
        queue.add("Two");
        queue.add("Three");

        assertEquals("One", queue.remove());
        assertEquals("Two", queue.remove());
        assertEquals("Three", queue.remove());
    }
}
