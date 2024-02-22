package datastructures.Trees.PriorityQueue;

public class PriorityQueueNode {
    String value;
    int priority;

    PriorityQueueNode(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    String getValue() {
        return this.value;
    }

    int getPriority() {
        return this.priority;
    }
}
