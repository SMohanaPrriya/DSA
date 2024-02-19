package datastructures.LinkedList;

public class MySinglyLinkedList {

    private int length;
    private MySinglyNode head;
    private MySinglyNode tail;

    public int getLength() {
        return length;
    }

    public MySinglyNode getHead() {
        return head;
    }

    public MySinglyNode getTail() {
        return tail;
    }

    public MySinglyLinkedList(int value) {
        length = 1;
        head = new MySinglyNode(value);
        tail = getHead();
    }

    private int getIndex(int index) {
        return Math.max(Math.min(index, length - 1), 0);
    }

    //insertion at the beginning
    public void prepend(int value) {
        head = new MySinglyNode(value, getHead());
        length++;
    }

    //insertion at the end
    public void append(int value) {
        MySinglyNode newNode = new MySinglyNode(value);
        tail.setNext(newNode);
        tail = newNode;
        length++;
    }

    public MySinglyNode traverseToTheIndex(int index) {
        index = getIndex(index);
        MySinglyNode newNode = getHead();
        for(int i=0; i<index; i++, newNode = newNode.getNext());
        return newNode;
    }

    //insertion at any index from 0 to n.
    public void insertNodeToLinkedList(int index, int value) {
        index = getIndex(index);
        if(index == 0) {
            prepend(value);
        } else if (index == getLength()-1) {
            append(value);
        } else {
            MySinglyNode previous = traverseToTheIndex(index-1);
            MySinglyNode next = previous.getNext();
            MySinglyNode newNode = new MySinglyNode(value, next);
            previous.setNext(newNode);
            length++;
        }
        displayLinkedlist();
    }

    //deletion at any point
    public int deleteNode(int index) {
        index = getIndex(index);
        int value;
        if (index == 0) {
            value = getHead().getValue();
            head = getHead().getNext();
        } else {
            MySinglyNode previous = traverseToTheIndex(index-1);
            MySinglyNode nodeToDelete = previous.getNext();
            value = nodeToDelete.getValue();
            previous.setNext(nodeToDelete.getNext());
        }
        length--;
        displayLinkedlist();
        return value;
    }

    void displayLinkedlist() {
        System.out.printf("Length: %d Linked List: ", getLength());
        for( MySinglyNode temp = getHead(); temp != null; temp = temp.getNext()) {
            System.out.print(temp.getValue());
            if(temp.getNext()!=null) {
                System.out.print("-->");
            }
        }
        System.out.println();
    }

    void reverseLinkedList() {
        if(getHead() == getTail()) {
            displayLinkedlist();
        } else {
            MySinglyNode currentNode = getHead();
            MySinglyNode previousNode = null;
            MySinglyNode nextNode = null;
            while(currentNode!=null) {
                nextNode = currentNode.getNext();
                currentNode.setNext(previousNode);
                previousNode = currentNode;
                currentNode = nextNode;
            }
            head = previousNode;
            displayLinkedlist();
        }
    }

    public static void main(String[] args) {
        MySinglyLinkedList list = new MySinglyLinkedList(10);
        list.displayLinkedlist();
        list.append(20);
        list.displayLinkedlist();
        list.insertNodeToLinkedList(0, 30);
        list.insertNodeToLinkedList(5, 40);
        list.insertNodeToLinkedList(2, 50);
        int index = 2;
        System.out.printf("Deleted value: %d at the index: %d", list.deleteNode(index), index);
        System.out.println();
        list.reverseLinkedList();
    }
}
