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
        
    }
}