public class CountInversions {

    public static int countInversions(int[] arr) {
        return mergeSortCountInversions(arr, 0, arr.length-1);
    }

    private static int mergeSortCountInversions(int[] arr, int lower, int upper) {
        int counter = 0;
        
        if(lower < upper) {
            int middle = (upper + lower) / 2;
            
            counter += mergeSortCountInversions(arr, lower, middle);
            counter += mergeSortCountInversions(arr, middle+1, upper);
            counter += mergeAndCount(arr, lower, middle, upper);
        }

        return counter;
    }

    private static int mergeAndCount(int[] arr, int lower, int middle, int upper) {
        int swaps = 0;

        int[] left = new int[middle - lower + 1];
        int[] right = new int[upper - middle];

        for(int i = 0; i < left.length; i++) {
            left[i] = arr[i + lower];
        }

        for(int i = 0; i < right.length; i++) {
            right[i] = arr[i + middle + 1];
        }

        int i = 0, j = 0, k = lower;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (middle + 1) - (lower - i);
            }
        }

        while(i < left.length) {
            arr[k++] = left[i++];
        }

        while(j < right.length) {
            arr[k++] = right[j++];
        }

        return swaps;
    }
}