/**
 * Main
 */
public class Main {

    public static void main(String[] args) {  
        int[] arr = {6, 2, 7, 50, 23, 11, 10, 8, 9, 32, 0, 54};
        QuickSort.quickSort(arr);
        for(Integer i: arr){
            System.out.print(i + " ");
        }
    }
}