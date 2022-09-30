package modelo;

import Exepciones.noSePudoLeerException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Lectura {

    public int matriz[][] = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private static Lectura instance = null;
    public Map <Character, Integer> alfabeto = new HashMap<Character, Integer>();
    public double vecProb[] = new double[27];
    public String vec[];
    public Lectura() {
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public Map<Character, Integer> getAlfabeto() {
        return alfabeto;
    }

    public static Lectura getInstance() {
        if (instance == null)
            instance = new Lectura();
        return instance;
    }

    public void cargaAlfabeto(){
        this.alfabeto.put('A',0); //agregar a medida que se lee
        this.alfabeto.put('B',1);
        this.alfabeto.put('C',2);
    }

    public void leeArch() throws noSePudoLeerException {
        FileReader fr;
        char c1,c2;
        int i=0, j=-1;

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
            System.out.println("Size:" +alfabeto.size());
            System.out.println(alfabeto);
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

    public void calculaProb() throws noSePudoLeerException {
        FileReader fr;
        char c;
        int i=0;
        try {
            fr = new FileReader("src/assets/datos.txt");
            while(i<9999) {
                c = (char) fr.read();
                this.vecProb[alfabeto.get(c)]++;
                i++;
            }
            for (i=0;i<alfabeto.size();i++){
                this.vecProb[i]/= 10000;
                //System.out.println(i+" --> " + this.vecProb[i]);
            }
        } catch (Exception ex) {
            throw new noSePudoLeerException("Error al leer");
        }
    }

    public void separaTexto (int n){
        File doc = new File("src/assets/datos.txt");
        String mensaje="", str;
        //int i1 = 3334;

        this.vec = new String[(int)10000/n];
        int j=0;
        try {
            BufferedReader obj = new BufferedReader(new FileReader(doc));
            while ((str = obj.readLine()) != null)
                mensaje += str;
            //System.out.println(mensaje.substring(j,j+2));
            for (int i=0; i<vec.length; i++) {
                vec[i] = mensaje.substring(j, j + n);
                j += n;
                //System.out.println(vec[i]);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public double[] getVecProb() {
        return vecProb;
    }

    public String[] getVec() {
        return vec;
    }

    /*
aparece a
aparece b

        buscar b tal que a
        columna b    fila a

*/
}
