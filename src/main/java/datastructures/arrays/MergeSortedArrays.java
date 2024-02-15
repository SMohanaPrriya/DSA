package datastructures.arrays;

/*.............. Merge Sorted Arrays ..............*/
// input: [0,3,4,31] and [4,6,30]
// output: [0, 3, 4, 4, 6, 30, 31]

public class MergeSortedArrays {

    public int[] mergeArrayOperation(int[] arr1, int[] arr2) {
        //Edge: either of the array is empty.
        if(arr1.length==0) return arr2;
        if(arr2.length==0) return arr1;
        
        //index and second of first array
        int i = 0;
        int j = 0;

        //index and creation of result array
        int k = 0;
        int[] finalArray = new int[arr1.length + arr2.length];

        while((i < arr1.length) && (j < arr2.length)) {
            if(arr1[i] < arr2[j]) {
                finalArray[k++] = arr1[i++];
            } else {
                finalArray[k++] = arr2[j++];
            }
        }

        //remaining items from the first array, when second array ran out of items.
        while(i < arr1.length) {
            finalArray[k++] = arr1[i++];
        }

        //remaining items from the second array, when first array ran out of items.
        while(j < arr2.length) {
            finalArray[k++] = arr2[j++];
        }
        
        return finalArray;
    }
    public static void main(String[] args) {
        int[] firstArray = {0,3,4,31};
        int[] secondArray = {4,6,30};
        int[] mergedArray = new MergeSortedArrays().mergeArrayOperation(firstArray, secondArray);
        for (int value : mergedArray) {
            System.out.print(value + " ");
        }
    }
}
