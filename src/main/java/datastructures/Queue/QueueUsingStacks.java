package datastructures.Queue;

import java.util.Stack;

public class QueueUsingStacks {

    public Stack<Integer> queueStack = new Stack<>();
    public Stack<Integer> reverseStack = new Stack<>();

    void enqueueFromStack (int value) {
        if(queueStack.isEmpty()) {
            queueStack.push(value);
        } else {
            while(!queueStack.isEmpty()) {
                reverseStack.push(queueStack.pop());
            }
            reverseStack.push(value);
            while(!reverseStack.isEmpty()) {
                queueStack.push(reverseStack.pop());
            }
        }
    }

    Integer dequeueFromStack() {
        return queueStack.isEmpty() ? null : queueStack.pop();
    }

    Integer peek() {
        return queueStack.isEmpty() ? null : queueStack.get(queueStack.size()-1);
    }

    void printQueueFromStack() {
        if(queueStack.isEmpty()) {
            return;
        }
        for (int i=queueStack.size()-1; i>=0 ; i--) {
            System.out.print(queueStack.get(i)+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueueFromStack(1);
        queue.enqueueFromStack(2);
        queue.enqueueFromStack(3);
        queue.printQueueFromStack();
        System.out.println(queue.dequeueFromStack());
        queue.printQueueFromStack();
        System.out.println(queue.peek());
    }
}
