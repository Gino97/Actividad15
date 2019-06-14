package grafo;

import java.util.ArrayList;

public class Pesado {
	private Arco arco;
	private int peso;
	
	public Pesado(ArrayList<Integer> arcoLista, int peso) {
		// TODO Auto-generated constructor stub
		this.arco = new Arco(arcoLista.get(0), arcoLista.get(1));
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}

	public int getNodo1() {
		return arco.getNodo1();
	}
	
	public int getNodo2() {
		return arco.getNodo2();
	}
	
	public int getNodoContrario(int x) {
		int i;
		if(arco.getNodo1()==x)
			i = arco.getNodo2();
		else
			i = arco.getNodo1();
		return i;
	}
}
