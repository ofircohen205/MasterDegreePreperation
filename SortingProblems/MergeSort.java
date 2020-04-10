public class MergeSort {

    /*
        Merge sort implementation, complexity : O(nlog(n))
    */
    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high){

        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];

        for(int i = 0; i < left.length; i++){
            left[i] = arr[i + low];
        }

        for(int i = 0; i < right.length; i++){
            right[i] = arr[mid + i + 1];
        }

        merge(arr, left, right, 0, 0, low);
    }

    private static void merge(int[] arr, int[] left, int[] right, int leftIndex, int rightIndex, int arrIndex){
        if(leftIndex == left.length && rightIndex == right.length){
            return;
        }
        
        if(leftIndex < left.length && rightIndex < right.length && left[leftIndex] <= right[rightIndex] || leftIndex < left.length && rightIndex >= right.length){
            arr[arrIndex] = left[leftIndex];
            leftIndex++;
        }

        else if(leftIndex < left.length && rightIndex < right.length && left[leftIndex] > right[rightIndex] || leftIndex >= left.length && rightIndex < right.length){
            arr[arrIndex] = right[rightIndex];
            rightIndex++;
        }

        merge(arr, left, right, leftIndex, rightIndex, ++arrIndex);
    }

}