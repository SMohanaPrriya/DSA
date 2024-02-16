package datastructures.hashtables;

//Google Question
//Given an array = [2,5,1,2,3,5,1,2,4]: It should return 2
//Given an array = [2,1,1,2,3,5,1,2,4]: It should return 1
//Given an array = [2,3,4,5]: It should return null
//Given an array = [2,5,5,2,3,5,1,2,4]: return 5 because the pairs are before 2,2

import java.util.HashSet;

public class FirstRecurringItem {

    Integer getFirstRecurringCharacter(int[] arr) {
        HashSet<Integer> list = new HashSet<>();
        //or can directly assign values like
        //HashSet<Integer> list = new HashSet<>(Arrays.asList(arr));
        for (int item : arr) {
            if (!list.contains(item)) {
                list.add(item);
            } else {
                return item;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,5,1,2,3,5,1,2,4};
        int[] arr2 = {2,1,1,2,3,5,1,2,4};
        int[] arr3 = {2,3,4,5};
        int[] arr4 = {2,5,5,2,3,5,1,2,4};
        FirstRecurringItem item = new FirstRecurringItem();
        System.out.println("First Recurring in arr1: "+item.getFirstRecurringCharacter(arr1));
        System.out.println("First Recurring in arr2: "+item.getFirstRecurringCharacter(arr2));
        System.out.println("First Recurring in arr3: "+item.getFirstRecurringCharacter(arr3));
        System.out.println("First Recurring in arr4: "+item.getFirstRecurringCharacter(arr4));
    }
}
