package GreedyProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * KnapsackProblem
 * Complexity: O(nLog(n)) Why?
 * The major part of this algorithm is sorting the items by their specific weight
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


class Item implements Comparable {

    private int profit, weight, specificWeight;
    
    public Item(int profit, int weight){
        this.profit = profit;
        this.weight = weight;
        this.specificWeight = profit / weight;
    }

    public int getProfit() {
        return profit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpecificWeight() {
        return specificWeight;
    }

    public void setSpecificWeight(int specificWeight) {
        this.specificWeight = specificWeight;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Item){
            if(this.getSpecificWeight() >= ((Item) o).getSpecificWeight()){
                return 1;
            }
            else{
                return -1;
            }  
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Item [profit=" + profit + ", weight=" + weight + ", specificWeight=" + specificWeight + "]";
    }

}

public class KnapsackProblem {

    private ArrayList<Item> items = new ArrayList<Item>();
    private int totalWeight;

    public KnapsackProblem(int totalWeight){
        this.totalWeight = totalWeight;
    }

    public int getTotalWeight(){
        return this.totalWeight;
    }

    public void createItem(int profit, int weight){
        Item item = new Item(profit, weight);
        items.add(item);
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public ArrayList<Pair<Item, Double>> solve(){
        ArrayList<Pair<Item, Double>> selected = new ArrayList<Pair<Item, Double>>();

        Collections.sort(this.items, new Comparator<Item>() {
            public int compare(Item i1, Item i2) {
               return i2.compareTo(i1);
            }
         });

        int index = 0;

        while(totalWeight > 0){

            int weight = items.get(index).getWeight();
            totalWeight = totalWeight - weight;

            if(totalWeight > 0){
                selected.add(new Pair<Item, Double>(items.get(index), Double.valueOf(1)));
            }
            else{ 
                double temp = (totalWeight + weight);
                double fracture = temp / weight;
                selected.add(new Pair<Item, Double>(items.get(index), fracture));
            }

            index++;
        }
        
        return selected;
    }

}