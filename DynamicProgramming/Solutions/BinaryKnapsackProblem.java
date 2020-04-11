package Solutions;

import java.util.ArrayList;

/**
 * BinaryKnapsackProblem
 */
class Pair<F, S> {

    public final F first;
    public final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public String toString() {
        return "Pair{" + String.valueOf(first) + ", " + String.valueOf(second) + "}";
    }
}

public class BinaryKnapsackProblem {

    public static ArrayList<Pair<String, Integer>> maxBinaryKnapsackProblem(int numberOfItems, int totalWeightAllowed, ArrayList<Pair<String, Integer>> items){

        ArrayList<Pair<String, Integer>> reulst = new ArrayList<>();

        return reulst;
    }
    
}