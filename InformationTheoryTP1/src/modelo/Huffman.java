package modelo;

import java.util.*;

class Nodo {
    int frec;
    String simbolo;
    Nodo izq;
    Nodo der;
}

class compare implements Comparator<Nodo> {
    public int compare(Nodo a, Nodo b) {
        return a.frec - b.frec;
    }
}

public class Huffman {

    public void cargaTabla(Nodo raiz, String s) {

        if (raiz.izq == null && raiz.der == null ) {
            Lectura.getInstance().getTablaHuffman().put(raiz.simbolo,s);
            return;
        }
        //Cada vez que va a la izquierda agrega un 0 al codigo
        cargaTabla(raiz.izq, s + "0");
        //Cada vez que va a la derecha agrega un 1 al codigo
        cargaTabla(raiz.der, s + "1");
    }

    public void creaArbolHuffman() {

        int n = Lectura.getInstance().getCantSimbolos();
        Map <String, Register> codigo = Lectura.getInstance().getCodigo();
        ArrayList<String> indice = Lectura.getInstance().getIndice();

        PriorityQueue<Nodo> cola = new PriorityQueue<Nodo>(n, new compare());
        for (int i = 0; i < n; i++) {
            Nodo nodo = new Nodo();
            nodo.simbolo = codigo.get(indice.get(i)).getSimbolo();
            nodo.frec = codigo.get(indice.get(i)).getFrec();
            nodo.izq = null;
            nodo.der = null;
            cola.add(nodo);
        }
        Nodo raiz = null;

        while (cola.size() > 1) {

            Nodo der = cola.poll();
            Nodo izq = cola.poll();
            Nodo temp = new Nodo();

            temp.frec = der.frec + izq.frec;
            temp.simbolo = "-";
            temp.izq = izq;
            temp.der = der;
            raiz = temp;
            cola.add(temp);
        }
        cargaTabla(raiz, "");
    }
}
