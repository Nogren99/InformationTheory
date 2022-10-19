package modelo;

import java.io.*;
import java.util.HashMap;

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
//    public void preparaEscritura(){
//        this.doc = new File("src/assets/arch"+nro+".txt");
//        nro = nro + 2;
//        try {
//            this.bw = new BufferedWriter(new FileWriter(doc));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public void escribe(String cadena){
//
////        this.doc = new File("src/assets/arch"+nro+".txt");
////        try {
////            this.bw = new BufferedWriter(new FileWriter(doc));
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//        try {
//            this.bw.write(cadena+"\n");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void finalizaEscritura(){
//        try {
//            this.bw.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void creaArch(int largoPalabra) {
        FileReader fr=null;
        PrintWriter pw = null;
        try {
            String ruta;
            //ruta = System.getProperty("user.dir");
            /////////////////////////////
            File archivoLectura = new File("src/assets/datos.txt");
            //File archivoLectura = new File("src/assets/datosotros.txt");
            fr= new FileReader(archivoLectura);
            BufferedReader br = new BufferedReader(fr, largoPalabra);
            /////////////////////////////
            //FileWriter archivoSalida= new FileWriter(ruta+"/archCodificado"+String.valueOf(largoPalabra)+".txt");
            FileWriter archivoSalida= new FileWriter("src/assets/arch"+nro+".txt");
            nro = nro + 2;
            pw= new PrintWriter(archivoSalida);
            ////////////////////////////////////////////////
            String lineaStr, lineaBinaria;
            char[] linea = new char[largoPalabra];
            while ((br.read(linea, 0,largoPalabra)) != -1){
                lineaBinaria=String.valueOf(linea);
                //pw.print(tabla.get(lineaBinaria));
                pw.print(Lectura.getInstance().getTablaHuffman().get(lineaBinaria)+"\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (null != fr)
                    fr.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }try{
                if(pw!=null)
                    pw.close();
            }catch (Exception e3) {
                e3.printStackTrace();
            }
            System.out.println("archivo creado");
        }
    }


}
