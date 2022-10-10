package main;

import Exepciones.noSePudoLeerException;
import modelo.Calculos;
import modelo.Huffman;
import modelo.Lectura;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
        lectura.muestraMatriz();
        System.out.println("------------");
        calculos.totalColumna(lectura.getMatriz());
        calculos.muestraMatriz();
        calculos.memoriaNula();

        //Segunda Parte
        lectura.separaTexto(5);
        calculos.calculaCantInfo();
        System.out.println("Longitud Media: "+calculos.longitudMedia());

        System.out.println("Cambio cualquiera");
        System.out.println(calculos.isCompacto());
        calculos.KraftMcMillan();
        System.out.println("El rendimiento o eficiencia es:"+calculos.rendimiento());
        System.out.println("La redundancia es:"+calculos.redundancia());
        System.out.println("UFFFF MAN");

        //Lectura.getInstance().setCodigo(Calculos.valueSort(Lectura.getInstance().getCodigo()));
        //Set set = Lectura.getInstance().getCodigo().entrySet();

        System.out.println(Lectura.getInstance().getCodigo().toString());
        huffman.creaCodHuffman();
       // Lectura.getInstance().getCodigo();
    }
}
