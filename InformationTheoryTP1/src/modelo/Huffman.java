package modelo;

import java.util.*;

//Node will represent all the letters with their frequency
class Node {
    int data;
    char c;
    Node left;
    Node right;
}

class compare implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.data - b.data;
    }
}

public class Huffman {

    public static void construct(Node root, String s) {
        //System.out.println("ENtre");
//Identifying a root node
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
//Every time we turn left we add a zero to the code representation
        construct(root.left, s + "0");
//Every time we turn right we add a one to the code representation
        construct(root.right, s + "1");
    }

    public static void main(String args[]) {
        int n = 5;
        char[] message = { 'a', 'b', 'c', 'd', 'e' };
        int[] frequen = { 10, 64, 5, 44, 1 };
        // Putting our data in min-priority queue
        PriorityQueue<Node> q = new PriorityQueue<Node>(n, new compare());
        for (int i = 0; i < n; i++) {
            Node s = new Node();
            s.c = message[i];
            s.data = frequen[i];
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
            temp.c = '-';
            temp.left = lft;
            temp.right = rht;
            root = temp;
            // Adding this to the queue to build up higher levels of the tree
            q.add(temp);
        }
        construct(root, "");
    }
}
