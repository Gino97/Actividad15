package grafo;
import java.util.ArrayList;

public class Grafo {
	private int[] nodos;
	private ArrayList<Pesado> arcos;
	private char[] color;
	private ArrayList<Integer>[] listaAdyacencia;

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

	public ArrayList<Pesado> getArcos() {
		return arcos;
	}

	public int[] getNodos() {
		return nodos;
	}

	public ArrayList<Integer>[] getListaAdyacencia(){
		return listaAdyacencia;
	}
	
	public int getNodosCount(){
		return this.nodos.length;
	}
	
	public int getArcosCount(){
		return this.arcos.size();
	}

	public String toString(){
		String res = "";
		for(Pesado arco : arcos){
			if(res=="")
				res = arco.toString();
			else
				res = res + ","+arco.toString();
		}
		return res;
	}
	

}
