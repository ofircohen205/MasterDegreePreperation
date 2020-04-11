/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        CoinChangeProblem ccp = new CoinChangeProblem(171);
        ccp.createCoin(8);
        ccp.createCoin(4);
        ccp.createCoin(2);
        ccp.createCoin(1);

        ccp.solve();
    }
}