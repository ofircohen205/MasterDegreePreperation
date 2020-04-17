import java.util.ArrayList;

public class RodCuttingProblem {

    private ArrayList<Integer> rod;
    private int price;

    public RodCuttingProblem() {
        rod = new ArrayList<Integer>();
        price = -1;
    }

    public ArrayList<Integer> getRod() {
        return this.rod;
    }

    public void addPiece(Integer value) {
        getRod().add(value);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void solve() {
        int rodSize = getRod().size();
        ArrayList<Integer> values = new ArrayList<>();
        while(values.size() <= rodSize) {
            values.add(0);
        }

        for(int i = 1; i <= rodSize; i++) {
            int maxValue = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++) {
                maxValue = Math.max(maxValue, getRod().get(j) + values.get(i-j-1));
            }
            values.set(i, maxValue);
        }

        setPrice(values.get(rodSize));
    }
    
}