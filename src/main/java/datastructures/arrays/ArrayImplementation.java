package datastructures.arrays;

import java.util.*;

public class ArrayImplementation {

    private Object[] arr;
    private int capacity;
    private int length;

    public ArrayImplementation () {
        capacity = 1;
        length = 0;
        arr = new Object[1];
    }

    //lookup: O(1) - get the value at an index.
    public Object get(int index) {
        return arr[index];
    }

    //to increase the capacity *2 - less frequent O(n) needed
    public void checkAndIncreaseCapacity() {
        if(length == capacity) {
            arr = Arrays.copyOf(arr, capacity*2);
            capacity *= 2;
        }
    }

    //push: O(1) - array insertion at the end.
    public void push(Object value) {
        checkAndIncreaseCapacity();
        arr[length++] = value;
    }

    //pop: O(1) - array deletion at the end
    public Object pop() {
        if(length>0) {
            Object poppedValue = arr[length - 1];
            arr = Arrays.copyOf(arr, --length);
            return poppedValue;
        }
        return null;
    }

    //insert: 0(n) - insertion at any given index.
    public void insert(int index, Object value) {
        //Edge: index within length range, higher than capacity cases.
        if(index==length) {
            push(value);
        } else {
            shiftArrayValues(index, true);
            arr[index] = value;
            length++;
        }
    }

    public void shiftArrayValues(int index, boolean increaseSize) {
        if(increaseSize) {
            checkAndIncreaseCapacity();
            for(int i=index; i<length; i++) {
                arr[i+1] = arr[i];
            }
        } else {
            for(int i=index; i<length-1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[length-1] = null;
            length--;
        }
    }

    //delete: o(n) - delete value at any given index.
    public Object delete(int index) {
        //Edge: empty array, negative index, higher than length index cases.
        if(index==length-1) {
            return pop();
        } else {
            Object returnValue = arr[index];
            shiftArrayValues(index, false);
            return returnValue;
        }
    }

    public void displayAll() {
        System.out.println("------------------------------");
        for (int i = 0; i < length; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
        System.out.println("Length: " + length + " Capacity: " + capacity + ".");
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        ArrayImplementation m = new ArrayImplementation();
        m.push("Hello");
        m.push("Prriya!");
        m.push("Welcome");
        m.push("hola");
        m.push("amigo");
        m.displayAll();
        System.out.println("poppped value: "+ m.pop());
        m.displayAll();
        int index = 0;
        System.out.println("Deleting value: "+ m.delete(index)+ " at index: "+index);
        m.displayAll();
        index = 1;
        System.out.println("Deleting value: "+ m.delete(index)+ " at index: "+index);
        m.displayAll();
        m.insert(1, "Miss!");
        m.displayAll();
    }
}