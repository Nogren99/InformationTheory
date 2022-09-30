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
        System.out.println("Kraft: "+Calculos.kraft(lectura.getVec(), 7));
    }
}
