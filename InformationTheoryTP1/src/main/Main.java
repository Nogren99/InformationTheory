package main;

import Exepciones.noSePudoLeerException;
import modelo.Calculos;
import modelo.Lectura;

public class Main {


    public static void main(String [] args) throws noSePudoLeerException {

        Lectura lectura = new Lectura();
        Calculos calculos = new Calculos();

        int i,j=0;

        lectura.leeArch();
        lectura.muestraMatriz();
        System.out.println("------------");
        calculos.totalColumna(lectura.getMatriz());
    }
}
