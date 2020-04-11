import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CoinChangeProblem {
    private ArrayList<Coin> coins = new ArrayList<Coin>();
    private int change;

    public CoinChangeProblem(int change) {
        this.change = change;
    }

    public int getChange() {
        return this.change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public void createCoin(int value) {
        Coin coin = new Coin(value);
        getCoins().add(coin);
    }

    public ArrayList<Coin> getCoins() {
        return this.coins;
    }

    public void solve() {
        Collections.sort(getCoins(), new Comparator<Coin>() {
            public int compare(Coin c1, Coin c2) {
                if(c1.getValue() >= c2.getValue()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });


        int[] numOfCoins = new int[getCoins().size()];
        Arrays.fill(numOfCoins, 0);

        int index = getCoins().size() - 1;
        while(this.change > 0) {
            int value = getCoins().get(index).getValue();
            numOfCoins[index] = this.change / value;
            setChange(this.change % value);
            index--;
        }

        printSolve(numOfCoins);
    }

    private void printSolve(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            System.out.print("[" + getCoins().get(i).toString());
            System.out.print(", Times " + arr[i] + "]");
            if(i < arr.length -1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}