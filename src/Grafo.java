import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {
	private int[] nodos;
	private ArrayList<Pesado> arcos;
	private char[] color;
	private ArrayList<Integer>[] listaAdyacencia;

	private class Pesado {
		private Arco arco;
		private int peso;
		
		private Pesado(ArrayList<Integer> arcoLista, int peso) {
			// TODO Auto-generated constructor stub
			this.arco = new Arco(arcoLista.get(0), arcoLista.get(1));
			this.peso = peso;
		}

		private class Arco {
			private int nodo1;
			private int nodo2;
			
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
	
	public ArrayList<Integer> getAdyacentesBlancos(int n){
		ArrayList<Integer> arcosAux = new ArrayList<>();
		for(int i=0; i<listaAdyacencia[n].size(); i++) {
			int nodo = listaAdyacencia[n].get(i);
			if(color[nodo]=='B') {
				arcosAux.add(nodo);
			}
		}
		return arcosAux;
	}
	
	public boolean bfs() {
		color = new char[nodos.length];
		for(int i=0; i<color.length; i++) {
			color[i]='B';
		}
		Queue<Integer> cola = new LinkedList<>();
		color[nodos[0]]='G';
		cola.add(nodos[0]);
		visitarBF(cola);
		return conexo();
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
		for(int i=0; i<color.length && conexo; i++) {
			if(color[i]!='N') {
				conexo = false;
			}
		}
		return conexo;
	}
	
	public int getNodosCount(){
		return this.nodos.length;
	}
	
	public int getArcosCount(){
		return this.arcos.size();
	}
	

	@SuppressWarnings("rawtypes")
	public Grafo(GrafoObj grafoJson){
		this.nodos = grafoJson.nodos;
		this.arcos = new ArrayList<Pesado>();
		
		Object[][] arcosJson = grafoJson.arcos;
		
		listaAdyacencia = new ArrayList[nodos.length];
		
		for(int i=0; i<nodos.length; i++) {
			listaAdyacencia[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i<arcosJson.length; i++){
			
			ArrayList<Integer> arcoLista = new ArrayList<>(); 
			arcoLista.add(((Double) ((ArrayList) arcosJson[i][0]).get(0)).intValue());
			arcoLista.add(((Double) ((ArrayList) arcosJson[i][0]).get(1)).intValue());
			Pesado pesado = new Pesado(arcoLista, ((Double) arcosJson[i][1]).intValue());
			this.arcos.add(pesado); 
			int nodo1 = pesado.getNodo1();
			int nodo2 = pesado.getNodo2();
			listaAdyacencia[nodo1].add(nodo2);
			listaAdyacencia[nodo2].add(nodo1);
		}
	}
	
	public static class GrafoObj {
		int[] nodos;
		Object[][] arcos;
	}

}
