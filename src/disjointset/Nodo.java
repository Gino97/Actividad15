package disjointset;

public class Nodo {

    private int value;
    private int head;
    private Nodo next;

    public Nodo(int value, int head, Nodo next){
        this.value = value;
        this.head = head;
        this.next = next;
    }

    public int getValue(){
        return value;
    }

    public Nodo getNext(){
        return next;
    }

    public int getHead(){
        return head;
    }

    public void setNext(Nodo nodo){
        next = nodo;
    }

}
