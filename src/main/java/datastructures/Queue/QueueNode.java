package datastructures.Queue;

public class QueueNode {

    private String value;
    private QueueNode next;

    public QueueNode(String value, QueueNode next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}
