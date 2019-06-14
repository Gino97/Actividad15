package kruskal;

import disjointSet.DisjointSet;
import disjointSet.HeuristicDisjointSet;
import grafo.Grafo;
import grafo.Pesado;
import kruskal.sorter.MergeSorter;
import kruskal.sorter.Sorter;
import lista.ListaDoble;
import lista.PositionList;

import java.util.List;

public class KruskalOrdenadoSinHeuristica {
    public PositionList<Pesado> kruskal(Grafo grafo) {
        PositionList<Pesado> listaResultado = new ListaDoble<>();
        List<Pesado> arcos = grafo.getArcos();

        Sorter sorter = new MergeSorter();
        arcos = sorter.sort(arcos);

        //Esto debería cambiar para que use conjuntos disjuntos sin heurística
        DisjointSet conjuntos = new HeuristicDisjointSet(grafo.getNodos());

        for (Pesado arco:arcos) {
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
