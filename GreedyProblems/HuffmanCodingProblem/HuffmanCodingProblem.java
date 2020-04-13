import java.util.*;
import java.util.regex.Pattern;

public class HuffmanCodingProblem {
    
    private HuffmanPriorityQueue queue;
    private static String treeOutput;

    public HuffmanCodingProblem() {
        this.queue = new HuffmanPriorityQueue();
    }

    public void addNode(String value, int frequency) {
        HuffmanNode node = new HuffmanNode(value, frequency);
        this.queue.addElement(node);
    }

    public void makeHeap() {
        this.queue.makeHeap();
    }

    public HuffmanPriorityQueue getQueue() {
        return this.queue;
    }

    public HuffmanPriorityQueue solve() {
        makeHeap();
        HuffmanNode root = null;

        while(getQueue().getSize() > 1) {
            HuffmanNode nodeA = getQueue().extractMin();
            HuffmanNode nodeB = getQueue().extractMin();
            System.out.println(nodeA);
            System.out.println(nodeB);

            String value = nodeA.getValue() + nodeB.getValue();
            int frequency = nodeA.getFrequency() + nodeB.getFrequency();
            HuffmanNode f = new HuffmanNode(value, frequency, nodeA, nodeB);
            root = f;

            getQueue().addElement(f);
        }

        // printHuffmanCoding(root, "");

        return getQueue();
    }

    private void printHuffmanCoding(HuffmanNode root, String code) {

        if(root.getLeft() == null && root.getRight() == null && Pattern.matches("[a-zA-Z]+", root.getValue())) {
            System.out.println(root.getValue() + ":" + code);
            return;
        }

        printHuffmanCoding(root.getLeft(), "0");
        printHuffmanCoding(root.getRight(), "1");
    }
}