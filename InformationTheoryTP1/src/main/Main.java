package main;

import Exepciones.noSePudoLeerException;
import modelo.Calculos;
import modelo.Lectura;

public class Main {


    public static void main(String [] args) throws noSePudoLeerException {

        Lectura lectura = Lectura.getInstance();
        Calculos calculos = new Calculos();
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
        lectura.separaTexto(7);
        calculos.calculaCantInfo();
        System.out.println("Longitud Media: "+calculos.longitudMedia());

        System.out.println("Cambio cualquiera");
        System.out.println(calculos.isCompacto());
        calculos.KraftMcMillan();
        System.out.println("El rendimiento o eficiencia es:"+calculos.rendimiento());
        System.out.println("La redundancia es:"+calculos.redundancia());
    }
}
