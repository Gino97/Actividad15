package kruskal;

import disjointset.DisjointSet;
import disjointset.NoHeuristicDisjointSet;
import grafo.Grafo;
import grafo.Pesado;
import heap.Heap;
import heap.HeapImp;
import lista.ListaDoble;
import lista.PositionList;

import java.util.List;

public class KruskalMinHeapSinHeuristica implements Kruskal {
    public PositionList<Pesado> kruskal(Grafo grafo) {
        PositionList<Pesado> listaResultado = new ListaDoble<>();
        List<Pesado> arcos = grafo.getArcos();
        Heap heap = new HeapImp(arcos);

        DisjointSet conjuntos = new NoHeuristicDisjointSet(grafo.getNodos());

        while (conjuntos.size()!=1) {
            Pesado arco = heap.removeMin();
            int conjNodo1 = conjuntos.findSet(arco.getNodo1());
            int conjNodo2 = conjuntos.findSet(arco.getNodo2());

            if (conjNodo1 != conjNodo2) {
                listaResultado.addFirst(arco);
                conjuntos.union(conjNodo1, conjNodo2);
            }
        }

        return listaResultado;
    }
}
