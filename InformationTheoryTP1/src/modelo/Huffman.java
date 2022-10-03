package modelo;

import java.util.*;

//Node will represent all the letters with their frequency
class Node {
    int data;
    String c;
    //char c;
    Node left;
    Node right;
}

class compare implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.data - b.data;
    }
}

public class Huffman {

    public void muestraCodHuffman(Node root, String s) {

//Identifying a root node
        //if (root.left == null && root.right == null && Character.isLetter(root.c)) {
        if (root.left == null && root.right == null ) {
            System.out.println(root.c + ":" + s + " frec: "+ root.data);
            return;
        }
//Every time we turn left we add a zero to the code representation
        muestraCodHuffman(root.left, s + "0");
//Every time we turn right we add a one to the code representation
        muestraCodHuffman(root.right, s + "1");
    }

    public void creaCodHuffman() {
        //int n = 5;
        int n = Lectura.getInstance().getN();
        //char[] message = { 'a', 'b', 'c', 'd', 'e' };
        Map <String, Register> codigo = Lectura.getInstance().getCodigo();
        ArrayList<String> indice = Lectura.getInstance().getIndice();
        int[] frequen = { 10, 64, 5, 44, 1 };
        // Putting our data in min-priority queue
        PriorityQueue<Node> q = new PriorityQueue<Node>(n, new compare());
        for (int i = 0; i < n; i++) {
            Node s = new Node();
            //s.c = message[i];
            s.c = codigo.get(indice.get(i)).getMensaje();
            //s.data = frequen[i];
            s.data = codigo.get(indice.get(i)).getFrec();
            s.left = null;
            s.right = null;
            q.add(s);
        }
        Node root = null;
        // Extracting the sorted nodes from the queue
        // Emptying until all we have is the root node
        while (q.size() > 1) {
            // Right for our root
            Node rht = q.poll();
            // Left for our root
            Node lft = q.poll();
            //System.out.println("Right " +rht.c);
            //System.out.println(lft.c);
            Node temp = new Node();
            // Root will have the sum of data from both left and right
            temp.data = rht.data + lft.data;
            //temp.c = '-';
            temp.c = "-";
            temp.left = lft;
            temp.right = rht;
            root = temp;
            // Adding this to the queue to build up higher levels of the tree
            q.add(temp);
        }
        muestraCodHuffman(root, "");
    }
    /*1. Cree un nodo de hoja para cada personaje y agréguelo a la cola de prioridad.
    2. Mientras haya más de un nodo en la queue:

        Quite los dos nodos de la prioridad más alta (la frecuencia más baja) de la queue.
        Cree un nuevo nodo interno con estos dos nodos como hijos y una frecuencia igual a la suma de las frecuencias de ambos nodos.
        Agregue el nuevo nodo a la cola de prioridad.
     3. El nodo restante es el nodo raíz y el árbol está completo.*/
}
