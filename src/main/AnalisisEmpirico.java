package main;

import java.io.IOException;
import java.io.InputStream;

import conexo.ConexoBFS;
import conexo.ConexoDisjointSet;
import grafo.*;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import grafo.Grafo;
import kruskal.*;

public class AnalisisEmpirico{
		
		public static void main(String[] args) throws IOException {
			
			try{
				Grafo grafo = getGrafo(500,100000);
				System.out.println("Grafo conexo con "+ grafo.getNodosCount() + " nodos y "+ grafo.getArcosCount() + " arcos construido");

				long init = System.nanoTime();

				System.out.println("Conexo usando BFS:");
				ConexoBFS conexoBFS = new ConexoBFS(grafo);
				System.out.println(conexoBFS.conexo());

				long end = System.nanoTime();
				System.out.println("El metodo tardo:"+ (end-init));

				init = System.nanoTime();

				System.out.println("Conexo usando DisjointSet c/ Heuristica:");
				ConexoDisjointSet conexoDisjointSet = new ConexoDisjointSet(grafo);
				System.out.println(conexoDisjointSet.conexo());

				end = System.nanoTime();
				System.out.println("El metodo tardo:"+ (end-init));


				System.out.println("Kruskal minHeap s/ heuristica:");
				Kruskal kruskal = new KruskalMinHeapSinHeuristica();

				init = System.nanoTime();
				kruskal.kruskal(grafo);
				end = System.nanoTime();

				System.out.println("El metodo tardo:"+ (end-init));

				System.out.println("Kruskal minHeap c/ Heuristica:");
				kruskal = new KruskalMinHeapConHeuristica();

				init = System.nanoTime();
				kruskal.kruskal(grafo);
				end = System.nanoTime();

				System.out.println("El metodo tardo:"+ (end-init));

				System.out.println("Kruskal ordenado s/ heuristica:");
				kruskal = new KruskalOrdenadoSinHeuristica();
				init = System.nanoTime();
				kruskal.kruskal(grafo);
				end = System.nanoTime();

				System.out.println("El metodo tardo:"+ (end-init));

				System.out.println("Kruskal ordenado c/ heuristica:");
				kruskal = new KruskalOrdenadoConHeuristica();

				init = System.nanoTime();
				kruskal.kruskal(grafo);
				end = System.nanoTime();

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
