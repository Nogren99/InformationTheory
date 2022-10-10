package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribeArchivos {

    private static int nro = 3;
    private File doc;
    private BufferedWriter bw;

    private static EscribeArchivos instance = null;

    public static EscribeArchivos getInstance(){
        if(instance == null)
            instance = new EscribeArchivos();
        return instance;
    }
    public void preparaEscritura(){
        this.doc = new File("src/assets/arch"+nro+".txt");
        nro = nro + 2;
        try {
            this.bw = new BufferedWriter(new FileWriter(doc));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void escribe(String cadena){

//        this.doc = new File("src/assets/arch"+nro+".txt");
//        try {
//            this.bw = new BufferedWriter(new FileWriter(doc));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            this.bw.write(cadena+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void finalizaEscritura(){
        try {
            this.bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
