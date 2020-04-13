package SortingProblems;

import java.util.Arrays;

/**
 * Main
 */
public class Main {

    private static void printArray(int[] arr) {
        System.out.print("[");
        for(Integer i: arr){
            System.out.print(i + " ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {  
        int[] arr = {6, 2, 7, 50, 23, 11, 10, 8, 9, 32, 0, 54};
        int[] arr1 = {6, 2, 7, 50, 23, 11, 10, 8, 9, 32, 0, 54};
        int[] arr2 = {170, 45, 75, 90, 802, 24, 2, 66};
        Double[] arr3 = {0.12, 0.17, 0.21, 0.23, 0.26, 0.19, 0.94, 0.21, 0.12, 0.23, 0.68};

        MergeSort.mergeSort(arr);
        printArray(arr);
        LinearSort.countingSort(arr1);
        printArray(arr);
        LinearSort.radixSort(arr2, 10);
        printArray(arr2);
        LinearSort.bucketSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}