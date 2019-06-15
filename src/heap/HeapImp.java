package heap;

import grafo.Pesado;

import java.util.List;

public class HeapImp implements Heap {
    private Pesado[] heap;
    private int size;

    public HeapImp(List<Pesado> list) {
        heap = new Pesado[list.size() + 1];
        size = list.size();
        heap[0] = null;
        int cont = 1;
        for (Pesado arco :list){
            heap[cont++]= arco;
        }

        minHeap();
    }
    // Function to build the min heap using
    // the minHeapify
    private void minHeap() {
        for (int pos = Math.floorDiv(size , 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    // Function to return the position of
    // the parent for the node currently
    // at pos
    private int parent(int pos) {
        return pos / 2;
    }

    // Function to return the position of the
    // left child for the node currently at pos
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Function to return the position of
    // the right child for the node currently
    // at pos
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Function that returns true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Function to swap two nodes of the heap
    private void swap(int fpos, int spos) {
        Pesado tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // Function to heapify the node at pos
    private void minHeapify(int pos) {

        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (heap[pos].getPeso() > heap[leftChild(pos)].getPeso()
                    || heap[pos].getPeso() > heap[rightChild(pos)].getPeso()) {

                // Swap with the left child and heapify
                // the left child
                if (heap[leftChild(pos)].getPeso() < heap[rightChild(pos)].getPeso()) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    // Function to remove and return the minimum
    // element from the heap
    public Pesado removeMin() {
        Pesado popped = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return popped;
    }
}