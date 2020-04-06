package Heap;

import java.util.ArrayList;
/**
 * Heap
 * Number of leafs = 2^(h - 1)
 * The root is at index 0
 * Left son at 2K index, Right son at 2K + 1 index
 * You can find the father of the K elemnt using  bound(k/2)
 */
public class Heap<T extends Comparable<T>>{

    private ArrayList<T> elements;
    private int size;
    private boolean isMinimum = true;

    public Heap(){
        this.elements = new ArrayList<T>();
        this.size = 0;
    }

    public Heap(ArrayList<T> array, boolean isMinimum){
        this.elements = array;
        this.isMinimum = isMinimum;
        
        // Adding to heap
    }

    /*
     Add element to Heap, Complexity : log(n)
    */
    public void add(T element){

    }

    /*
     Remove element to Heap, Complexity : log(n)
    */
    public void remove(T element){

    }

    public ArrayList<T> getElements() {
        return elements;
    }

    public void setElements(ArrayList<T> elements) {
        this.elements = elements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isMinimum() {
        return isMinimum;
    }

    public void setMinimum(boolean isMinimum) {
        this.isMinimum = isMinimum;
    }
}