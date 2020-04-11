import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * KnapsackProblem
 * Complexity: O(nLog(n)) Why?
 * The major part of this algorithm is sorting the items by their specific weight
 */

public class BinaryKnapsackProblem {

    private ArrayList<Item> items = new ArrayList<>();
    private int totalWeight;

    public BinaryKnapsackProblem(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void createItem(int profit, int weight) {
        items.add(new Item(profit, weight));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Pair<Item, Integer>> solve() {
        ArrayList<Pair<Item, Integer>> selected = new ArrayList<Pair<Item, Integer>>();

        Collections.sort(items, new Comparator<Item>() {
            public int compare(Item item1, Item item2) {
                return item1.compareTo(item2);
            }
        });

        int index = 0;

        while(totalWeight > 0) {
            if(index > items.size()) {
                index = 0;
            }
            int weight = items.get(index).getWeight();
            totalWeight = totalWeight - weight;

            if(totalWeight > 0){
                selected.add(new Pair<Item, Integer>(items.get(index), Integer.valueOf(1)));
                items.remove(index);
            } else {
                break;
            }

            index++; 
        }

        return selected;
    }
}