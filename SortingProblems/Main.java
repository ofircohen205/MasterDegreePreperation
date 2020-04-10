/**
 * Main
 */
public class Main {

    public static void main(String[] args) {  
        int[] arr = {1, 2, 12, 33, 22,  10};
        // MergeSort.mergeSort(arr);
        QuickSort.quickSort(arr);
        for(Integer i: arr){
            System.out.print(i + " ");
        }
    }
}