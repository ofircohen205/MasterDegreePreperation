/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 5));
    }

    public static boolean recursiveBinarySearch(E[] arr, int low, int high, E query){
        if(low > high){
            return false;
        }
        
        int mid = (low + high) / 2;

        if(arr[mid] == query){
            return true;
        }
        
        if(arr[mid] < query){
            low = mid + 1;
        }
        else if(arr[mid] > query){
            high = mid - 1;
        }

        return recursiceBinarySearch(arr, low, high, query);
    }
}