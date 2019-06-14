package heap;

import grafo.Pesado;

import java.util.List;

public class HeapImp implements Heap {
    private Pesado[] array;
    private int size;

    public HeapImp(List<Pesado> list) {
        array = new Pesado[list.size()];
        size = 0;
        makeHeap(list);
    }

    private void makeHeap(List<Pesado> list) {
        //Apa
    }

    @Override
    public Pesado removeMin() {
        return null;
    }

    @Override
    public void add(Pesado p) {
        //Añadir blablabla

        size++;
    }
}
