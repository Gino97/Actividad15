package kruskal.sorter;

import grafo.Pesado;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter implements Sorter {
    public List<Pesado> sort(List<Pesado> list) {
        return ordenarMerge(list, 0, list.size()-1);
    }

    private List<Pesado> ordenarMerge(List<Pesado> lista, int i, int j) {
        if (i==j) {
            List<Pesado> listaRet = new ArrayList<>();
            listaRet.add(lista.get(i));

            return listaRet;
        } else {
            List<Pesado> lista1 = ordenarMerge(lista, i, (int) Math.floor((i+j)/2));
            List<Pesado> lista2 = ordenarMerge(lista, (int) Math.floor((i+j)/2)+1, j);

            return merge(lista1, lista2);
        }
    }

    private List<Pesado> merge(List<Pesado> lista1, List<Pesado> lista2) {
        List<Pesado> listaRet = new ArrayList<>();
        Pesado pesado1, pesado2;
        int k = 0, l = 0, m = 0;

        while (k!=lista1.size() && l!=lista2.size()) {
            pesado1 = lista1.get(k);
            pesado2 = lista2.get(l);

            if (pesado1.getPeso()<=pesado2.getPeso()) {
                listaRet.add(m, pesado1);
                m++;
                k++;
            } else {
                listaRet.add(m, pesado2);
                m++;
                l++;
            }
        }

        while (k!=lista1.size()) {
            pesado1 = lista1.get(k);
            listaRet.add(m, pesado1);
            m++;
            k++;
        }

        while (l!=lista2.size()) {
            pesado2 = lista2.get(l);
            listaRet.add(m, pesado2);
            m++;
            l++;
        }

        return listaRet;
    }
}
