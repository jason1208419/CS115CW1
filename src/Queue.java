
/**
 * A class that implements a queue.
 *
 * @author 689591
 */
import java.util.NoSuchElementException;

/**
 * A class that implements a queue.
 */
public class Queue {

    private QueueElement head;
    private QueueElement tail;

    /**
     * Constructs an empty Queue.
     */
    public Queue() {
        head = null;
        tail = null;
    }

    /**
     * Returns true if the queue is empty
     *
     * @return Return true or false
     */
    public boolean isEmpty() {
        return ((head == null) && (tail == null));
    }

    /**
     * Returns the element at the head of the queue
     *
     * @return The head of the queue
     */
    public Object peek() throws NoSuchElementException {
        if (isEmpty()) {//throw exception if queue is empty
            throw new NoSuchElementException("Queue Empty");
        } else {//get the data of the head of queue if queue is not empty
            return head.getElement();
        }
    }

    /**
     * Removes the front element of the queue
     */
    public void dequeue() throws NoSuchElementException {
        if (isEmpty()) {//throw exception if queue is empty
            throw new NoSuchElementException("Queue Empty");
        } else {//remove the data of the head of queue if queue is not empty
            head = head.getNext();
            if (head == null) {//set tail to null if the queue become empty after dequeue
                tail = null;
            }
        }
    }

    /**
     * Puts an element on the back of the queue.
     *
     * @param element The element which is going to enqueue
     */
    public void enqueue(Object element) {
        QueueElement newNode = new QueueElement(element, null);
        if (isEmpty()) {//set head to newNode if queue is empty
            head = newNode;
        } else {//only add new Node to the end of the queue if queue is not empty
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    /**
     * Method to print the full contents of the queue in order from head to
     * tail.
     */
    public void print() {
        String fullQueue = "";
        if (isEmpty()) {//tell the user the queue is empty if the queue is empty
            System.out.println("The queue is empty.");
        } else {//if queue is not empty, add the element in the end to print out
            QueueElement current = head;
            fullQueue += current.getElement() + ",\n";
            while (current.getNext() != null) {//add element in the end to print out until queue is empty
                current = current.getNext();
                fullQueue += current.getElement() + ",\n";
            }
            System.out.println(fullQueue);
        }
    }
}
