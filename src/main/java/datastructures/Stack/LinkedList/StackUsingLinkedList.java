package datastructures.Stack.LinkedList;

import java.util.EmptyStackException;

public class StackUsingLinkedList {

    private int length;
    private MyStackNode top;
    
    public StackUsingLinkedList() {
        top = null;
        length = 0;
    }

    public MyStackNode getTop() {
        return top;
    }

    public int getLength() {
        return length;
    }

    //peek - information about the top node
    public int peek() {
        if(getLength() == 0) {
            throw new EmptyStackException();
        }
        return getTop().getValue();
    }

    //push - insertion at the top
    void push (int value) {
        top = new MyStackNode(value, getTop());
        length++;
    }

    int pop() {
        if(getLength() == 0) {
            throw new EmptyStackException();
        }
        int returnValue = getTop().getValue();
        top = getTop().getNext();
        length--;
        return  returnValue;
    }

    void printStack() {
        if (getTop() == null) {
            return;
        }
        MyStackNode currentNode = getTop();
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while(currentNode!=null) {
            System.out.printf(" --> %d ", currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        System.out.println("Peek operation : "+ stack.peek());
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.printStack();
        System.out.println("Peek operation : "+ stack.peek());
        System.out.println("Pop operation : "+stack.pop());
        stack.printStack();
    }
}
