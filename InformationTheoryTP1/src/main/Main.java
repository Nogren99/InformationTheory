package main;

import Exepciones.noSePudoLeerException;
import modelo.Calculos;
import modelo.EscribeArchivos;
import modelo.Huffman;
import modelo.Lectura;

public class Main {


    public static void main(String [] args) throws noSePudoLeerException {

        Lectura lectura = Lectura.getInstance();
        Calculos calculos = new Calculos();
        Huffman huffman = new Huffman();
        char car;
        int i,j=0;

        lectura.cargaAlfabeto();
        car = 'A';
        System.out.println(lectura.getAlfabeto().get(car));
        lectura.leeArch();
        lectura.muestraMatriz(lectura.getMatriz());
        System.out.println("------------");
        calculos.totalColumna(lectura.getMatriz());
        lectura.muestraMatriz(calculos.getMatProbabilidades());
        //calculos.muestraMatriz();
        calculos.memoriaNula();

       //Segunda Parte
        System.out.println("---------------------------- 3 caracteres ------------------------------------------------");
        lectura.separaTexto(3);
        calculos.calculaCantInfo();
        System.out.println("Longitud Media: "+calculos.longitudMedia());

        System.out.println(calculos.isCompacto());
        calculos.KraftMcMillan();
        System.out.println("El rendimiento o eficiencia es:"+calculos.rendimiento());
        System.out.println("La redundancia es:"+calculos.redundancia());
        System.out.println("UFFFF MAN");

        //Lectura.getInstance().setCodigo(Calculos.valueSort(Lectura.getInstance().getCodigo()));
        //Set set = Lectura.getInstance().getCodigo().entrySet();

        System.out.println(Lectura.getInstance().getCodigo().toString());
        huffman.creaTablaHuffman();
        EscribeArchivos.getInstance().creaArch(3);

        lectura.getTablaHuffman().clear();
        //Segunda Parte
        System.out.println("---------------------------- 5 caracteres ------------------------------------------------");
        lectura.separaTexto(5);
        calculos.calculaCantInfo();
        System.out.println("Longitud Media: "+calculos.longitudMedia());

        System.out.println(calculos.isCompacto());
        calculos.KraftMcMillan();
        System.out.println("El rendimiento o eficiencia es:"+calculos.rendimiento());
        System.out.println("La redundancia es:"+calculos.redundancia());

        //Lectura.getInstance().setCodigo(Calculos.valueSort(Lectura.getInstance().getCodigo()));
        //Set set = Lectura.getInstance().getCodigo().entrySet();

        System.out.println(Lectura.getInstance().getCodigo().toString());
        huffman.creaTablaHuffman();
        EscribeArchivos.getInstance().creaArch(5);
       // Lectura.getInstance().getCodigo();


        lectura.getTablaHuffman().clear();
//        //Segunda Parte
//        System.out.println("---------------------------- 7 caracteres ------------------------------------------------");
//        lectura.separaTexto(7);
//        calculos.calculaCantInfo();
//        System.out.println("Longitud Media: "+calculos.longitudMedia());
//
//        System.out.println(calculos.isCompacto());
//        calculos.KraftMcMillan();
//        System.out.println("El rendimiento o eficiencia es:"+calculos.rendimiento());
//        System.out.println("La redundancia es:"+calculos.redundancia());
//
//        //Lectura.getInstance().setCodigo(Calculos.valueSort(Lectura.getInstance().getCodigo()));
//        //Set set = Lectura.getInstance().getCodigo().entrySet();
//
//        System.out.println(Lectura.getInstance().getCodigo().toString());
//        huffman.creaTablaHuffman();
//        EscribeArchivos.getInstance().creaArch(3);
    }
}
