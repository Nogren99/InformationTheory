package modelo;

import Exepciones.noSePudoLeerException;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Lectura {

    public int matriz[][];
    public Map <Character, Integer> alfabeto = new HashMap<Character, Integer>();


    public Lectura() {
        alfabeto.put('A',0);
        alfabeto.put('B',1);
        alfabeto.put('C',2);
        matriz = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void leeArch() throws noSePudoLeerException {
        FileReader fr;
        char c1,c2;
        int i=0;

        try {
            fr = new FileReader("src/assets/datos.txt");
            c1 = (char) fr.read();
            c2 = (char) fr.read();
            while(i<9999) {
                matriz[alfabeto.get(c2)][alfabeto.get(c1)]++;
                c1=c2;
                c2 = (char) fr.read();
                i++;
            }

        } catch (Exception ex) {
            throw new noSePudoLeerException("Error al leer");
        }
    }

    public void muestraMatriz(){
        System.out.println("Matriz de apariciones condicionadas:");
        for(int i=0;i<3;i++){
            System.out.print("|");
            for(int j=0;j<3;j++){
                System.out.print(" "+matriz[i][j]+" | ");
            }
            System.out.println();
        }
    }


/*
aparece a
aparece b

        buscar b tal que a
        columna b    fila a

*/
}
