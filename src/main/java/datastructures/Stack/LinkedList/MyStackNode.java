package datastructures.Stack.LinkedList;

public class MyStackNode {

    private int value;
    private MyStackNode next;

    public MyStackNode(int value, MyStackNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public MyStackNode getNext() {
        return next;
    }
}
