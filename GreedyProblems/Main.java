/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        KnapsackProblem kp = new KnapsackProblem(15);
        kp.createItem(10, 2);
        kp.createItem(5, 3);
        kp.createItem(15, 5);
        kp.createItem(7, 7);
        kp.createItem(6, 1);
        kp.createItem(18, 4);
        kp.createItem(3, 1);
        
        System.out.println(kp.solve());

        BinaryKnapsackProblem bkp = new BinaryKnapsackProblem(15);
        bkp.createItem(10, 2);
        bkp.createItem(5, 3);
        bkp.createItem(15, 5);
        bkp.createItem(7, 7);
        bkp.createItem(6, 1);
        bkp.createItem(18, 4);
        bkp.createItem(3, 1);
        
        System.out.println(bkp.solve());
        
        CoinChangeProblem ccp = new CoinChangeProblem(171);
        ccp.createCoin(8);
        ccp.createCoin(4);
        ccp.createCoin(2);
        ccp.createCoin(1);

        ccp.solve();
    }
}