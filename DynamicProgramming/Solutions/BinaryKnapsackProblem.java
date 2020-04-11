package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Utils.Pair;

/**
 * BinaryKnapsackProblem
 * This is NP Hard problem, therefore, we can only produced 'reasonable' solution to this problem
 * Assum that all weights are positive and in between 1...totalWeight for any given item;
 * complexity: O(n*W), W can be exponantial in the value, there for this can be 2^n
 */


public class BinaryKnapsackProblem {

    public static ArrayList<Pair<Integer, Integer>> maxBinaryKnapsackProblem(int numberOfItems, int totalWeightAllowed, ArrayList<Pair<Integer, Integer>> items){

        ArrayList<Pair<Integer, Integer>> reulst = new ArrayList<>();

        // First value int the piar = profit, Second value in the pair = weight
        Collections.sort(items, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(final Pair<Integer, Integer> o1, final Pair<Integer, Integer> o2) {
                if(o1.second > o2.second){
                    return 1;
                }
                
                if(o1.second < o2.second){
                    return -1;
                }
                
                return 0;
            }
        });

        int[][] temp = new int[numberOfItems + 1][totalWeightAllowed + 1];

        for(int i = 1; i <= numberOfItems; i++){

            Pair<Integer, Integer> currentItem = items.get(i - 1);
            
            for(int j = 1; j <= totalWeightAllowed; j++){
                if(currentItem.first <= j){
                    temp[i][j] = Math.max(currentItem.first + temp[i][j - currentItem.second], temp[i - 1][j]);
                }
                else{
                    temp[i][j] = temp[i - 1][j];
                }
            }
        }

        System.out.println("temp[numberOfItems][totalWeightAllowed]");
        return reulst;
    }

	public static char[] maxBinaryKnapsackProblem(int numberOfItems, int totalWeightAllowed,
			List<Pair<Integer, Integer>> items) {
		return null;
	}
    
}