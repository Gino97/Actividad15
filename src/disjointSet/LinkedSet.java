package disjointSet;

public class LinkedSet {

    private Nodo head;
    private Nodo tail;
    private int size;

    public LinkedSet(int value){
        Nodo nodo = new Nodo(value, value, null);
        head = nodo;
        tail = nodo;
        size = 1;
    }

    public void add(int value){
        Nodo nodo = new Nodo(value, head.getHead(), null);
        tail.setNext(nodo);
        tail = nodo;
        size++;
    }

    public int find(int x){
        Nodo nodo = head;
        int res = -1;
        for(int i=0; i<size && res==-1; i++){
            if(nodo.getValue()==x){
                res = nodo.getHead();
            }
            else{
                nodo = nodo.getNext();
            }
        }
        return res;
    }

    public Nodo getHead(){
        return head;
    }

    public int size(){
        return size;
    }

}
