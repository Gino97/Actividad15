package conexo;

import disjointset.DisjointSet;
import disjointset.HeuristicDisjointSet;
import grafo.Grafo;
import grafo.Pesado;

import java.util.ArrayList;

public class ConexoDisjointSet implements Conexo{

    private Grafo grafo;
    private DisjointSet disjointSet;

    public ConexoDisjointSet(Grafo grafo){
        this.grafo = grafo;
        disjointSet = new HeuristicDisjointSet(grafo.getNodos());
    }

    public boolean conexo(){
        boolean conexo = false;
        ArrayList<Pesado> arcos = grafo.getArcos();
        for(int i=0; i<arcos.size() && disjointSet.size()>1; i++){
            int nodo1Parent = disjointSet.findSet(arcos.get(i).getNodo1());
            int nodo2Parent = disjointSet.findSet(arcos.get(i).getNodo2());
            if(nodo1Parent!=nodo2Parent) {
                disjointSet.union(nodo1Parent, nodo2Parent);
            }
        }
        if(disjointSet.size()==1){
            conexo = true;
        }
        return conexo;
    }

}
