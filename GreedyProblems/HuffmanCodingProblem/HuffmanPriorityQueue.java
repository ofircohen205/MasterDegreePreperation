import java.util.*;

public class HuffmanPriorityQueue {
    
    private ArrayList<HuffmanNode> elements;
    private int size;
    private boolean isMinimum = true;

    public HuffmanPriorityQueue() {
        this.elements = new ArrayList<HuffmanNode>();
        this.size = 0;
    }

    public HuffmanPriorityQueue(ArrayList<HuffmanNode> array, boolean isMinimun) {
        this.elements = array;
        this.isMinimum = isMinimun;
        setSize(array.size());
    }

    public ArrayList<HuffmanNode> getElements() {
        return this.elements;
    }

    public void setElements(ArrayList<HuffmanNode> elements) {
        this.elements = elements;
        setSize(elements.size());
    }

    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public boolean isMinimum() {
        return isMinimum;
    }

    public void setMinimum(boolean isMinimum) {
        this.isMinimum = isMinimum;
    }

    public void heapify(int index) {
        while(true) {
            int max = index;
            if(2*index <= getSize() && getElements().get(2*index).getFrequency() > getElements().get(max).getFrequency()) {
                max = 2*index;
            }
            if(2*index + 1 <= getSize() && getElements().get(2*index + 1).getFrequency() > getElements().get(max).getFrequency()) {
                max = 2*index + 1;
            }
            if(max == index) {
                return;
            }
            Collections.swap(getElements(), index, max);
            index = max;
        }
    }

    public void addElement(HuffmanNode element) {
        getElements().add(getSize(), element);
        setSize(getSize() + 1);
        int index = getSize();
        HuffmanNode parent = getElements().get(index / 2);
        while(index > 0 && element.getFrequency() > parent.getFrequency()) {
            Collections.swap(getElements(), index, index / 2);
            index /= 2;
        }
    }

    public void deleteElement(HuffmanNode element) {
        int index = getElements().indexOf(element);
        Collections.swap(getElements(), index, getSize()-1);
        heapify(index);
        setSize(getSize() - 1);
    }

    public HuffmanNode extractMin() {
        HuffmanNode min = getElements().get(0);
        Collections.swap(getElements(), 0, getSize()-1);
        heapify(0);
        setSize(getSize() - 1);
        return min;
    }

    public void makeHeap() {
        for(int i = (getElements().size() / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    @Override
    public String toString() {
        String retVal = "";
        for (HuffmanNode huffmanNode : elements) {
            retVal += huffmanNode.toString() + "\n";
        }
        
        return retVal;
    }

}