import java.util.Arrays;
import java.util.List;

import Solutions.*;
import Utils.Pair;

public class Main {

    public static void main(String[] args) {
        
        int[] dims = {5, 4, 4, 6, 6, 2, 2, 7};
        System.out.println(MatrixMult.minMatrixMult(dims));
        List<Pair<Integer, Integer>> items = Arrays.asList(new Pair<Integer,Integer>(1, 2), new Pair<Integer,Integer>(2, 3), new Pair<Integer,Integer>(5, 4), new Pair<Integer,Integer>(6, 5));
        System.out.println(BinaryKnapsackProblem.maxBinaryKnapsackProblem(4, 8, items));    
    }
}