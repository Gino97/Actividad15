package kruskal;
import grafo.Grafo;
import lista.PositionList;
import grafo.Pesado;

public interface Kruskal {

     PositionList<Pesado> kruskal(Grafo grafo);
}
