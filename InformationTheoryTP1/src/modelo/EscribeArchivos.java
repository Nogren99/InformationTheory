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
        FileReader fileReader=null;
        PrintWriter printWriter = null;
        try {

            File archivoLectura = new File("E:\\Programas\\Github\\InformationTheory\\InformationTheoryTP1\\src\\assets\\datos.txt");

            fileReader= new FileReader(archivoLectura);
            BufferedReader bufferedReader = new BufferedReader(fileReader, largoPalabra);
            FileWriter archivoSalida= new FileWriter("E:\\Programas\\Github\\InformationTheory\\InformationTheoryTP1\\src\\assets\\"+nro+".txt");
            nro = nro + 2;
            printWriter= new PrintWriter(archivoSalida);
            String str;
            char[] cad = new char[largoPalabra];
            while ((bufferedReader.read(cad, 0,largoPalabra)) != -1){
                str=String.valueOf(cad);
                printWriter.print(Lectura.getInstance().getTablaHuffman().get(str)+"\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (null != fileReader)
                    fileReader.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }try{
                if(printWriter!=null)
                    printWriter.close();
            }catch (Exception e3) {
                e3.printStackTrace();
            }
            System.out.println("archivo creado");
        }
    }


}
