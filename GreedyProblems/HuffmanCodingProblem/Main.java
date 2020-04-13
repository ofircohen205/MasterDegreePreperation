import java.util.*;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        Random rand = new Random();
        HashMap<String, Integer> letters = new HashMap<>();
        ArrayList<HuffmanNode> elements = new ArrayList<>();
        HuffmanCodingProblem hcp = new HuffmanCodingProblem();
        
        int index = 0;
        while(index < 10) {
            int frequency = rand.nextInt(100);
            String value = String.valueOf((char)(rand.nextInt(26) + 'a'));
            if(letters.get(value) == null){
                letters.put(value, frequency);
                HuffmanNode node = new HuffmanNode(value, frequency);
                elements.add(node);
                index++;
            }
        }
        hcp.getQueue().setElements(elements);
        System.out.println(hcp.getQueue());
        hcp.makeHeap();
        System.out.println("-----");
        System.out.println(hcp.getQueue());
        System.out.println("-----");
        hcp.solve();
        // System.out.println(hcp.solve());
    }
}