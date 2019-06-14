package heap;

import grafo.Pesado;

public interface Heap {
    Pesado removeMin();
    void add(Pesado p);
}
