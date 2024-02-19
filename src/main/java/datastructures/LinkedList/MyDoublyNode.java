package datastructures.LinkedList;

public class MyDoublyNode {
    private int value;
    private MyDoublyNode next;
    private MyDoublyNode previous;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyDoublyNode getNext() {
        return next;
    }

    public void setNext(MyDoublyNode next) {
        this.next = next;
    }

    public MyDoublyNode getPrevious() {
        return previous;
    }

    public void setPrevious(MyDoublyNode previous) {
        this.previous = previous;
    }

    public MyDoublyNode(int newValue) {
        value = newValue;
        next = previous = null;
    }

    public MyDoublyNode(int newValue, MyDoublyNode nextNode, MyDoublyNode previousNode) {
        value = newValue;
        next = nextNode;
        previous = previousNode;
    }
}
