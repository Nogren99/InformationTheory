package main;

import Exepciones.noSePudoLeerException;
import modelo.Lectura;

public class Main {


    public static void main(String [] args) throws noSePudoLeerException {

        Lectura lectura = new Lectura();
        int i,j=0;

        lectura.leeArch();
        lectura.muestraMatriz();
    }
}
