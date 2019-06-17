package conexo;

import cola.Cola;
import cola.ColaImp;
import grafo.Grafo;

import java.util.ArrayList;

public class ConexoBFS implements Conexo{

    private Grafo grafo;
    private int[] nodos;
    private char[] color;
    private ArrayList<Integer>[] listaAdyacencia;

    public ConexoBFS(Grafo grafo) {
        this.grafo = grafo;
        nodos = grafo.getNodos();
        listaAdyacencia = grafo.getListaAdyacencia();
    }

    public void bfs() {
        color = new char[nodos.length];
        for(int i=0; i<color.length; i++) {
            color[i]='B';
        }
        Cola<Integer> cola = new ColaImp<Integer>();
        color[nodos[0]]='G';
        cola.enqueue(nodos[0]);
        visitarBF(cola);
    }

    public void visitarBF(Cola<Integer> cola) {
        while(!cola.isEmpty()) {
            int nodo = cola.dequeue();
            for(int i=0; i<listaAdyacencia[nodo].size(); i++) {
                int nodoAux = listaAdyacencia[nodo].get(i);
                if(color[nodoAux]=='B') {
                    color[nodoAux] = 'G';
                    cola.enqueue(nodoAux);
                }
            }
            color[nodo] = 'N';
        }
    }

    public boolean conexo() {
        boolean conexo = true;
        bfs();
        for(int i=0; i<color.length && conexo; i++) {
            if(color[i]!='N') {
                conexo = false;
            }
        }
        return conexo;
    }

}
