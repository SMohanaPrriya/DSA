package datastructures.Stack.Arrays;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrays {
    List<String> stack = new ArrayList<>();

    String peek() {
        return stack.get(stack.size()-1);
    }

    void push(String item) {
        stack.add(item);
    }

    String pop() {
        if (stack.isEmpty()) {
            return "Stack is empty";
        }
        int top = stack.size()-1;
        String returnValue = stack.get(top);
        stack.remove(top);
        return returnValue;
    }

    void printStack() {
        int top = stack.size()-1;
        System.out.printf("Stack: %s", stack.get(top));
        for(int i = stack.size()-2; i >= 0; i--) {
            System.out.printf(" <-- %s ", stack.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingArrays newStack = new StackUsingArrays();
        newStack.push("There!");
        newStack.push("Hi");
        newStack.push("Hello");
        newStack.printStack();
        System.out.println(newStack.peek());
        System.out.println(newStack.pop());
        System.out.println(newStack.peek());
        newStack.printStack();
    }


}
