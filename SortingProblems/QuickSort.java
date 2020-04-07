
public class QuickSort {

    /*
    Quick sort implementation, complexity : nlog(n) in avarage, for the wrong pivot choice can becom n^2
    */
    private static int parition(int[] arr, int low, int high){
        
        int pivot = arr[low];
        int i = low, j = high;

        while(i < j){
            
            while(arr[i] <= pivot){
                i++;
            }
            
            while(arr[j] > pivot){
                j--;
            }
            
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high){

        if(low < high){
            int j = parition(arr, low, high);
            quickSort(arr, low, j);
            quickSort(arr, j + 1, high);
        }

    }
}