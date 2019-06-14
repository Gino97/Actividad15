package disjointSet;

import java.util.ArrayList;

public class NoHeuristicDisjointSet implements DisjointSet{

    private ArrayList<LinkedSet> sets;

    public NoHeuristicDisjointSet(int[] nodos){
        sets = new ArrayList<>();
        for(int i=0; i<nodos.length; i++){
            makeSet(nodos[i]);
        }
    }

    public int findSet(int nodo){
        int res = -1;
        for(int i=0; i<sets.size() && res==-1; i++){
            res = sets.get(i).find(nodo);
        }
        return res;
    }

    public void makeSet(int nodo){
        sets.add(new LinkedSet(nodo));
    }

    public void union(int x, int y){
        int fx = findSet(x);
        int fy = findSet(y);
        if(fx != fy){
            LinkedSet fxSet = getSet(fx);
            LinkedSet fySet = getSet(fy);
            Nodo nodo = fySet.getHead();
            for(int i=0; i<fySet.size(); i++){
                fxSet.add(nodo.getValue());
                nodo = nodo.getNext();
            }
            sets.remove(fySet);
        }
    }

    public LinkedSet getSet(int x){
        int pos = -1;
        for(int i=0; i<sets.size() && pos==-1; i++){
            if(sets.get(i).getHead().getValue()==x){
                pos = i;
            }
        }
        return sets.get(pos);
    }

    public int size(){
        return sets.size();
    }

}
