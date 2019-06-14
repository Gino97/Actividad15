package ejercicios.ejercicio1;

import grafo.Grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConexoBFS {

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
        Queue<Integer> cola = new LinkedList<>();
        color[nodos[0]]='G';
        cola.add(nodos[0]);
        visitarBF(cola);
    }

    public void visitarBF(Queue<Integer> cola) {
        while(cola.size()>0) {
            int nodo = cola.poll();
            for(int i=0; i<listaAdyacencia[nodo].size(); i++) {
                int nodoAux = listaAdyacencia[nodo].get(i);
                if(color[nodoAux]=='B') {
                    color[nodoAux] = 'G';
                    cola.add(nodoAux);
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
