package disjointset;

public class HeuristicDisjointSet implements DisjointSet{

    private int[] parent;
    private int[] rank;
    private int size;

    public HeuristicDisjointSet(int[] nodos){
        size = 0;
        parent = new int[nodos.length];
        rank = new int[nodos.length];
        for(int i=0; i<nodos.length; i++){
            makeSet(i);
        }
        size = nodos.length;
    }

    public int findSet(int nodo){
        if(nodo!= parent[nodo]){
            parent[nodo] = findSet(parent[nodo]);
        }
        return parent[nodo];
    }

    public void makeSet(int nodo){
        parent[nodo] = nodo;
        rank[nodo] = 0;
    }

    public void union(int x, int y){
        link(findSet(x), findSet(y));
        size--;
    }

    public void link(int x, int y) {
        if(rank[x]>rank[y]){
            parent[y] = x;
        }
        else{
            parent[x] = y;
            if(rank[x]==rank[y]){
                rank[y] = rank[y] + 1;
            }
        }
    }

    public int size(){
        return size;
    }
}
