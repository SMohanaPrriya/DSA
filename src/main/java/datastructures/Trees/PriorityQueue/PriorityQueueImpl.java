package datastructures.Trees.PriorityQueue;

import java.util.ArrayList;

public class PriorityQueueImpl {

    ArrayList<PriorityQueueNode> pQueue = new ArrayList<>();

    public void enqueue(String value, int priority) {
        PriorityQueueNode newNode = new PriorityQueueNode(value, priority);
        boolean isPresent = false;

        for(int i=0; i<pQueue.size(); i++) {
            if(pQueue.get(i).getPriority() > newNode.getPriority()) {
                pQueue.add(i, newNode);
                isPresent = true;
                break;
            }
        }
        if(!isPresent) {
            pQueue.add(newNode);
        }
    }

    public String dequeue() {
        if(pQueue.isEmpty()) {
            return "Empty Queue";
        }
        String removedValue = pQueue.get(0).getValue();
        pQueue.remove(0);
        return  removedValue;
    }

    public void printQueue() {
        for(int i=0; i<pQueue.size(); i++) {
            System.out.printf(" <-- %s ", pQueue.get(i).getValue());
        }
        System.out.println();
    }

    String getFront() {
        if(!pQueue.isEmpty()) {
            return pQueue.get(0).getValue();
        }
        return null;
    }

    String getRear() {
        if(!pQueue.isEmpty()) {
            return pQueue.get(pQueue.size()-1).getValue();
        }
        return  null;
    }

    public static void main(String[] args) {
        PriorityQueueImpl priorityQueue = new PriorityQueueImpl();
        priorityQueue.enqueue("piyush", 3);
        priorityQueue.enqueue("rohan", 1);
        priorityQueue.enqueue("jeet", 2);
        priorityQueue.enqueue("john", 5);
        priorityQueue.enqueue("Dave", 4);
        priorityQueue.printQueue();
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.getFront());
        System.out.println(priorityQueue.getRear());
    }
}
