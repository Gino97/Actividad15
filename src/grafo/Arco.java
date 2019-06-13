package grafo;

public class Arco {
	private int nodo1;
	private int nodo2;
	private int nodeNo;
	
	public Arco(int i, int j) {
		// TODO Auto-generated constructor stub
		this.nodo1 = i;
		this.nodo2 = j;
	}
	
	public int getNodo1() {
		return nodo1;
	}
	
	public int getNodo2() {
		return nodo2;
	}
}