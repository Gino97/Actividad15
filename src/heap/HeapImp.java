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

    //construye el heap
    private void minHeap() {
        for (int pos = Math.floorDiv(size , 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }


    //devuelve hijo izquierdo
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // devuelve hijo derecho
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean hasBothChildren(int pos) {
        return leftChild(pos)<=size && rightChild(pos)<=size ? true : false;
    }

    // swap enteo dos nodos
    private void swap(int fpos, int spos) {
        Pesado tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    //heapify de un nodo
    private void minHeapify(int pos) {

        if (hasBothChildren(pos)) {
            if (heap[pos].getPeso() > heap[leftChild(pos)].getPeso()
                    || heap[pos].getPeso() > heap[rightChild(pos)].getPeso()) {

                //swap con el hijo izquierdo y hace heapif

                if (heap[leftChild(pos)].getPeso() < heap[rightChild(pos)].getPeso()) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                //swap con el hijo derecho y hace heapif

                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        } else if (leftChild(pos)<=size && (heap[pos].getPeso() > heap[leftChild(pos)].getPeso())) {
            swap(pos, leftChild(pos));
        }
    }

    // retorna el minimo y lo remueve

    public Pesado removeMin() {
        Pesado popped = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return popped;
    }

    public void printHeap() {
        String string = "[";
        for (int i=1; i<=size; i++) {
            string = string + heap[i].getPeso()+", ";
        }

        System.out.println(string + "]");
    }
}