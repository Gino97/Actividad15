package heap;

import grafo.Pesado;

import java.util.ArrayList;
import java.util.List;

public class HeapTester {
    public static void main(String args[]) {
        List<Pesado> lista = new ArrayList<>();
        lista.add(new Pesado(1, 2, 3));
        lista.add(new Pesado(1, 2, 2));
        lista.add(new Pesado(1, 2, 1));
        lista.add(new Pesado(1, 2, 4));
        lista.add(new Pesado(1, 2, 6));
        lista.add(new Pesado(1, 2, 5));
        lista.add(new Pesado(1, 2, 8));
        lista.add(new Pesado(1, 2, 7));

        Heap heap = new HeapImp(lista);

        for (int i=0; i<=lista.size()-1; i++) {
            System.out.println(heap.removeMin().getPeso());
        }
    }
}
