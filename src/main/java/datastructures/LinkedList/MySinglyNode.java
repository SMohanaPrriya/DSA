package datastructures.LinkedList;

public class MySinglyNode {

    private int value;
    private MySinglyNode next;

    public MySinglyNode(int value) {
        this.value = value;
        this.next = null;
    }

    public MySinglyNode(int value, MySinglyNode nextNode) {
        this.value = value;
        this.next = nextNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MySinglyNode getNext() {
        return next;
    }

    public void setNext(MySinglyNode next) {
        this.next = next;
    }
}
