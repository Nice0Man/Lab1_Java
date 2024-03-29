package lab_2;

/**
 * Represents an unlimited queue of string elements.
 * Elements are added to the tail of the queue and removed from the head.
 */
public class Queue {

    private Node head;
    private Node tail;

    // Nested class Node for representing elements of the queue
    private static final class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Adds a new element to the tail of the queue.
     *
     * @param data the string element to add
     */
    public void add(String data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    /**
     * Removes and returns the element at the head of the queue.
     *
     * @return the string element removed from the head of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public String remove() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        String removedData = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return removedData;
    }
}
