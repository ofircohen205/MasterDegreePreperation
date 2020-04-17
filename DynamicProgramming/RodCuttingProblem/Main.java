
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        RodCuttingProblem rcp = new RodCuttingProblem();
        for(int item : arr) {
            rcp.addPiece(item);
        }
        rcp.solve();
        System.out.println(rcp.getPrice());
    }
}