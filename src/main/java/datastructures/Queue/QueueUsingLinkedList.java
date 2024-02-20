package datastructures.Queue;

public class QueueUsingLinkedList {
    private int length;
    private QueueNode first;
    private QueueNode last;

    public int getLength() {
        return length;
    }

    public QueueNode getFirst() {
        return first;
    }

    public QueueNode getLast() {
        return last;
    }

    QueueUsingLinkedList() {
        length = 0;
        first = last = null;
    }

    String peek() {
        return  first == null ? "Empty Queue" : first.getValue();
    }

    void enqueue(String item) {
        QueueNode newNode = new QueueNode(item, null);
        if(first == null && last == null) {
            first = last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    String dequeue() {
        if(first == last && last == null) {
            return "Empty Queue";
        }
        String returnValue = first.getValue();
        first = first.getNext();
        if(first == last) {
            last = null;
        }
        return returnValue;
    }

    void printQueue() {
        QueueNode temp = getFirst();
        System.out.printf("Queue: %s", temp.getValue());
        temp = temp.getNext();
        while(temp!=null) {
            System.out.printf(" <-- %s ", temp.getValue());
            temp = temp.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList newQueue = new QueueUsingLinkedList();
        newQueue.enqueue("There!");
        newQueue.enqueue("Hi");
        newQueue.enqueue("Hello");
        newQueue.printQueue();
        System.out.printf("Peek Value: %s %n", newQueue.peek());
        System.out.printf("Dequeue Value: %s %n", newQueue.dequeue());
        newQueue.printQueue();
        System.out.printf("Dequeue Value: %s %n", newQueue.dequeue());
        System.out.printf("Dequeue Value: %s %n", newQueue.dequeue());
        System.out.printf("Dequeue Value: %s %n", newQueue.dequeue());
        System.out.printf("Dequeue Value: %s %n", newQueue.dequeue());
    }

}
