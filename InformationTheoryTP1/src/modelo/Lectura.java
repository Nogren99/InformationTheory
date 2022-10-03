package modelo;

import Exepciones.noSePudoLeerException;

import java.io.*;
import java.util.*;

class Register implements Comparable {
    String mensaje="";
    int frec=0;
    double prob = 0.0;

    public Register(String mensaje, int frec) {
        this.mensaje = mensaje;
        this.frec = frec;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getFrec() {
        return frec;
    }

    public void setFrec(int frec) {
        this.frec = frec;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    @Override
    public String toString() {
        return mensaje +" --> " + frec;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Object o) {
        Register r = (Register) o;
        if (this.getFrec() > r.getFrec())
            return 1;
        else
            return 0;
    }
}
public class Lectura {

    public int matriz[][] = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private static Lectura instance = null;
    public Map <Character, Integer> alfabeto = new HashMap<Character, Integer>();
    public double vecProb[] = new double[27];

    //public String vec[];

    //public ArrayList<Register> array = new ArrayList<Register>();

    public ArrayList<String> indice = new ArrayList<String>();
    //public Map <String, Register> codigo = new HashMap<String, Register>();
    public Map <String, Register> codigo = new TreeMap<String, Register>();
    public int n;

    public Lectura() {
    }
    public int getN() {
        return n;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public Map<Character, Integer> getAlfabeto() {
        return alfabeto;
    }

    public Map<String, Register> getCodigo() {
        return codigo;
    }

    public ArrayList<String> getIndice() {
        return indice;
    }

    public static Lectura getInstance() {
        if (instance == null)
            instance = new Lectura();
        return instance;
    }

    public void setCodigo(Map<String, Register> codigo) {
        this.codigo = codigo;
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
            //fr = new FileReader("InformationTheoryTP1/src/assets/datos.txt");
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
            //fr = new FileReader("InformationTheoryTP1/src/assets/datos.txt");
            fr = new FileReader("src/assets/datos.txt");
            while(i<9999) {
                c = (char) fr.read();
                this.vecProb[alfabeto.get(c)]++;
                i++;
            }
            for (i=0;i<alfabeto.size();i++){
                this.vecProb[i]/= 10000;
                System.out.println(i+" --> " + this.vecProb[i]);
            }
        } catch (Exception ex) {
            throw new noSePudoLeerException("Error al leer");
        }
    }

    public void separaTexto (int n){

        //File doc = new File("InformationTheoryTP1/src/assets/datos.txt");
        File doc = new File("src/assets/datos.txt");
        String mensaje="", str,simbolo;
        int frec = 0;
        int j=0;
        //this.vec = new String[];
        Register actual;

        try {
            BufferedReader obj = new BufferedReader(new FileReader(doc));

            while ((str = obj.readLine()) != null)
                mensaje += str;

            while (j<10000) {
                if (n==3 && j==9999)
                    simbolo = mensaje.substring(j);
                else if (n==7 && j==9996)
                    simbolo = mensaje.substring(j, j+4);
                else
                    simbolo = mensaje.substring(j, j + n);
                if(!codigo.containsKey(simbolo)){
                    indice.add(simbolo);
                    codigo.put(simbolo, new Register(simbolo, 1));
                }
                else {
                    actual=codigo.get(simbolo);
                    actual.setFrec(actual.getFrec()+1);
                }
                j += n;
            }
            System.out.println(codigo.toString());
        }

        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.n = this.indice.size();
    }
    public double[] getVecProb() {
        return vecProb;
    }


}
