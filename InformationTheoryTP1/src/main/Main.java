package main;

import Exepciones.noSePudoLeerException;
import modelo.Calculos;
import modelo.Huffman;
import modelo.Lectura;

import java.util.*;

import static modelo.Ordena.valueSort;

public class Main {


    public static void main(String [] args) throws noSePudoLeerException {

        Lectura lectura = Lectura.getInstance();
        Calculos calculos = new Calculos();
        Huffman huffman = new Huffman();
        char car;
        int i,j=0;

        lectura.cargaAlfabeto();
        car = 'A';
//        System.out.println(lectura.getAlfabeto().get(car));
//        lectura.leeArch();
//        lectura.muestraMatriz();
//        System.out.println("------------");
//        calculos.totalColumna(lectura.getMatriz());
//        calculos.muestraMatriz();
//        calculos.memoriaNula();

        //Segunda Parte

        lectura.separaTexto(3);
        Map sortedMap = valueSort(lectura.getCodigo());

        lectura.setCodigo(sortedMap);
        lectura.setN(sortedMap.size());
        Set set = sortedMap.entrySet();
        Iterator x = set.iterator();

        lectura.getIndice().clear();
        // Display elements
        while (x.hasNext()) {

            Map.Entry mp = (Map.Entry)x.next();

            lectura.getIndice().add((String) mp.getKey());
            //System.out.print(mp.getKey() + ": ");
            //System.out.println(mp.getValue());

        }
        System.out.println(lectura.getCodigo());
        System.out.println("Indice");
        System.out.println(lectura.getIndice());
//        lectura.setCodigo(sortedMap);
//        System.out.println(lectura.getCodigo());
//        for(i=0;i<Lectura.getInstance().getN();i++){
//            //lectura.getArrayHuffman().add(sortedMap.get());
//       }
        //Collections.sort(lectura.getArrayHuffman());
        //System.out.println(lectura.getArrayHuffman());
        calculos.calculaCantInfo();
        System.out.println("Longitud Media: "+calculos.longitudMedia());

        System.out.println("Cambio cualquiera");
        System.out.println(calculos.isCompacto());
        calculos.KraftMcMillan();
        System.out.println("El rendimiento o eficiencia es:"+calculos.rendimiento());
        System.out.println("La redundancia es:"+calculos.redundancia());
        System.out.println("UFFFF MAN");

       // Lectura.getInstance().setCodigo(Calculos.valueSort(Lectura.getInstance().getCodigo()));
        //Set set = Lectura.getInstance().getCodigo().entrySet();

        System.out.println(Lectura.getInstance().getCodigo().toString());
       huffman.creaCodHuffman();

// PARA 5
//        //Segunda Parte
//        lectura.separaTexto(5);
//        calculos.calculaCantInfo();
//        System.out.println("Longitud Media: "+calculos.longitudMedia());
//
//        System.out.println("Cambio cualquiera");
//        System.out.println(calculos.isCompacto());
//        calculos.KraftMcMillan();
//        System.out.println("El rendimiento o eficiencia es:"+calculos.rendimiento());
//        System.out.println("La redundancia es:"+calculos.redundancia());
//        System.out.println("UFFFF MAN");
//
//        //Lectura.getInstance().setCodigo(Calculos.valueSort(Lectura.getInstance().getCodigo()));
//        //Set set = Lectura.getInstance().getCodigo().entrySet();
//
//        System.out.println(Lectura.getInstance().getCodigo().toString());
//        huffman.creaCodHuffman();
//       // Lectura.getInstance().getCodigo();
//

        // PARA 7
//        //Segunda Parte
//        lectura.separaTexto(7);
//        calculos.calculaCantInfo();
//        System.out.println("Longitud Media: "+calculos.longitudMedia());
//
//        System.out.println("Cambio cualquiera");
//        System.out.println(calculos.isCompacto());
//        calculos.KraftMcMillan();
//        System.out.println("El rendimiento o eficiencia es:"+calculos.rendimiento());
//        System.out.println("La redundancia es:"+calculos.redundancia());
//        System.out.println("UFFFF MAN");
//
//        //Lectura.getInstance().setCodigo(Calculos.valueSort(Lectura.getInstance().getCodigo()));
//        //Set set = Lectura.getInstance().getCodigo().entrySet();
//
//        System.out.println(Lectura.getInstance().getCodigo().toString());
//        huffman.creaCodHuffman();
    }
}
