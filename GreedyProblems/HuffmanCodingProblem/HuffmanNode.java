
public class HuffmanNode implements Comparable {

    private String value;
    private int frequency;
    private HuffmanNode left, right;

    public HuffmanNode() {
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(String value, int frequency) {
        this.value = value;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(String value, int frequency, HuffmanNode left, HuffmanNode right) {
        this.value = value;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public HuffmanNode getLeft() {
        return this.left;
    }

    public void setLeft(HuffmanNode node) {
        this.left = node;
    }

    public HuffmanNode getRight() {
        return this.right;
    }

    public void setRight(HuffmanNode node) {
        this.right = node;
    }

    @Override
    public String toString() {
        StringBuilder retVal = new StringBuilder();
        retVal.append("[Character: ").append(this.value).append(", Frequency: ").append(this.frequency).append("]");
        return retVal.toString();
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) o;
            if(this.getFrequency() >= node.getFrequency()) {
                return 1;
            }
            return -1;
        } else {
            return 0;
        }
    }
}