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

    public void creaArch(int largoPalabra) {
        FileReader fileReader=null;
        PrintWriter printWriter = null;


        try {
            File archivoLectura = new File("src/assets/datos.txt");

            fileReader= new FileReader(archivoLectura);
            BufferedReader bufferedReader = new BufferedReader(fileReader, largoPalabra);
            FileWriter archivoSalida= new FileWriter("src/assets/arch"+nro+".txt");
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
