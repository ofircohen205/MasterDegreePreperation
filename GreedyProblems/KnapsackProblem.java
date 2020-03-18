package GreedyProblems;

import java.util.ArrayList;

/**
 * KnapsackProblem
 */

/**
 * InnerKnapsackProblem
 */
class Item {

    private int price, weight;
    
    public Item(int price, int weight){
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public void createItem(int price, int weight){
        Item item = new Item(price, weight);
        items.add(item);
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

}