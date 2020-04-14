/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        BinaryKnapsackProblem bkp = new BinaryKnapsackProblem(15);
        bkp.createItem(10, 2);
        bkp.createItem(5, 3);
        bkp.createItem(15, 5);
        bkp.createItem(7, 7);
        bkp.createItem(6, 1);
        bkp.createItem(18, 4);
        bkp.createItem(3, 1);
        
        System.out.println(bkp.solve());
    }
}