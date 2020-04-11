
public class Item implements Comparable {
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