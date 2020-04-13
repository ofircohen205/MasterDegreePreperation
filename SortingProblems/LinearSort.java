package SortingProblems;

import java.util.*;

public class LinearSort {

    // Time complexity - O(n)
    public static void countingSort(int[] arr) {
        // create the counting array
        int maxVal = Arrays.stream(arr).max().getAsInt();
        int[] counting = new int[maxVal+1];
        for(int i = 0; i < arr.length; i++) {
            counting[arr[i]]++;
        }

        for(int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }

        // create the new sorted array
        int[] newArr = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            newArr[counting[arr[i]] - 1] = arr[i];
            counting[arr[i]]--;
        }

        // override the old array with the new array
        for(int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
    }


    public static void radixSort(int[] arr, int base) {
        int maxVal = Arrays.stream(arr).max().getAsInt();

        for(int digit = 1; maxVal / digit > 0; digit *= base) {
            radixCountSort(arr, digit, base);
        }
    }

    private static void radixCountSort(int[] arr, int digit, int base) {
        // create the counting array
        int[] counting = new int[base+1];
        for(int i = 0; i < arr.length; i++) {
            counting[(arr[i] / digit) % base]++;
        }

        for(int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }

        // create the new sorted array
        int[] newArr = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            newArr[counting[(arr[i] / digit) % base] - 1] = arr[i];
            counting[(arr[i] / digit) % base]--;
        }

        // override the old array with the new array
        for(int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
    }


    public static void bucketSort(Double[] arr) {
        ArrayList<ArrayList<Double>> buckets = new ArrayList<ArrayList<Double>>();
        while(buckets.size() < arr.length) {
            buckets.add(new ArrayList<Double>());
        }

        for(int i = 0; i < arr.length; i++) {
            int index = (int)(arr[i] * arr.length);
            buckets.get(index).add(arr[i]);
        }

        int pointer = 0;
        for(ArrayList<Double> bucket : buckets) {
            Collections.sort(bucket);
            for(Double value : bucket) {
                arr[pointer] = value;
                pointer++;
            }
        }
    }
}