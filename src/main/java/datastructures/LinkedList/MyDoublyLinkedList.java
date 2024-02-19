package datastructures.LinkedList;

public class MyDoublyLinkedList {
    private int length;
    private MyDoublyNode head;
    private MyDoublyNode tail;

    public int getLength() {
        return length;
    }

    public MyDoublyNode getHead() {
        return head;
    }

    public MyDoublyNode getTail() {
        return tail;
    }

    MyDoublyLinkedList(int value) {
        length = 1;
        head = tail = new MyDoublyNode(value, null, null);
        printDoublyLinkedList();
    }

    private int getIndexWithinRange(int index) {
        return Math.max(Math.min(index, length), 0);
    }

    public void prepend(int value) {
        MyDoublyNode newNode = new MyDoublyNode(value, getHead(), null);
        head.setPrevious(newNode);
        head = newNode;
        length++;
    }

    public void append(int value) {
        MyDoublyNode newNode = new MyDoublyNode(value, null, getTail());
        tail.setNext(newNode);
        tail = newNode;
        length++;
    }

    public MyDoublyNode traverseToTheIndex(int index) {
        MyDoublyNode nodeToReturn = getHead();
        for(int i=0; i<index; i++, nodeToReturn = nodeToReturn.getNext());
        return nodeToReturn;
    }

    public void insert(int index, int value) {
        index = getIndexWithinRange(index);
        if(index == 0) {
            prepend(value);
        } else if (index == getLength()) {
            append(value);
        } else {
            MyDoublyNode previousToIndex = traverseToTheIndex(index-1);
            MyDoublyNode newNode = new MyDoublyNode(value, previousToIndex.getNext(), previousToIndex);
            previousToIndex.setNext(newNode);
            previousToIndex.getNext().setPrevious(newNode);
            length++;
        }
        printDoublyLinkedList();
    }

    void printDoublyLinkedList() {
        MyDoublyNode node = getHead();
        System.out.printf("Length: %d, DLL: %d", getLength(), node.getValue());
        node = node.getNext();
        while(node!=null) {
            System.out.printf(" <--> %d", node.getValue());
            node = node.getNext();
        }
        System.out.println();
    }

    int deleteDoublyLinkedList(int index) {
        int value;
        index = getIndexWithinRange(index);
        if(index == 0) {
            value = getHead().getValue();
            head = getHead().getNext();
            head.setPrevious(null);
        } else {
            MyDoublyNode previousNode = traverseToTheIndex(index-1);
            MyDoublyNode nodeToDelete = previousNode.getNext();
            value = nodeToDelete.getValue();
            previousNode.setNext(nodeToDelete.getNext());
            tail = previousNode; //deletion of last node.
            if(index!=getLength()-1) {
                nodeToDelete.getNext().setPrevious(previousNode);
                tail = nodeToDelete.getNext(); //deletion of in-between item.
            }
        }
        length--;
        printDoublyLinkedList();
        return  value;
    }

    public static void main(String[] args) {
        MyDoublyLinkedList list = new MyDoublyLinkedList(50);
        //index + 1 = position
        list.insert(0, 10); //add as first item.
        list.insert(2, 20); //add as third item.
        list.insert(2, 30); //add as third item.
        list.insert(3, 40);
        list.deleteDoublyLinkedList(0);
        list.deleteDoublyLinkedList(2);
        list.deleteDoublyLinkedList(list.getLength()-1);
    }
}
