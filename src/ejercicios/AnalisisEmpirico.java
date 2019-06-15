package ejercicios;

import java.io.IOException;
import java.io.InputStream;

import ejercicios.ejercicio1.ConexoBFS;
import ejercicios.ejercicio1.ConexoDisjointSet;
import grafo.*;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import grafo.Grafo;
import kruskal.Kruskal;
import kruskal.KruskalMinHeapConHeuristica;

public class AnalisisEmpirico{
		
		public static void main(String[] args) throws IOException {
			
			try{
				Grafo grafo = getGrafo(500,120000	);
				System.out.println("Grafo conexo con "+ grafo.getNodosCount() + " nodos y "+ grafo.getArcosCount() + " arcos construido");

				long init = System.currentTimeMillis();

				ConexoBFS conexoBFS = new ConexoBFS(grafo);
				System.out.println(conexoBFS.conexo());

				long end = System.currentTimeMillis();
				System.out.println("El metodo tardo:"+ (end-init));

				init = System.currentTimeMillis();

				ConexoDisjointSet conexoDisjointSet = new ConexoDisjointSet(grafo);
				System.out.println(conexoDisjointSet.conexo());

				end = System.currentTimeMillis();
				System.out.println("El metodo tardo:"+ (end-init));

				System.out.println("Kruskal:");
				Kruskal kruskal = new KruskalMinHeapConHeuristica();

				init = System.currentTimeMillis();
				kruskal.kruskal(grafo);
				end = System.currentTimeMillis();

				System.out.println("El metodo tardo:"+ (end-init));



			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			/*
			 * Generar varios grafos de diferente configuraci�n y buscar 
			 * �rbol de cubrimiento minimal para cada uno. 
			 * 
			 * Medir el rendimiento usando timestamps.
			 * 
			 */
			
			
		}

		private static Grafo getGrafo(int nodos, int arcos) throws Exception {
			// TODO Auto-generated method stub
			String consulta = "curl http://cs.uns.edu.ar/~mom/AyC2019/grafo.php?nodos="+nodos+"&arcos="+arcos;
			Process process = Runtime.getRuntime().exec(consulta);
			InputStream inputSt = process.getInputStream();
			@SuppressWarnings("resource")
			Scanner s = new Scanner(inputSt).useDelimiter("\\A");
			String jsonString = s.hasNext() ? s.next() : "";
			System.out.println("Tengo el grafo en formato JSON. Lo convierto...");
			Gson gson = new GsonBuilder().create();
			try{
				GrafoObj gr = gson.fromJson(jsonString, GrafoObj.class);
				return new Grafo(gr);
			} catch (Exception e) {
				throw new Exception(jsonString);
			}
		}
	}
