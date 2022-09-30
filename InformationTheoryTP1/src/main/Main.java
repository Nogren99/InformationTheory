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
        calculos.muestraMatriz();
        calculos.memoriaNula();
        lectura.calculaProb();
        lectura.separaTexto(5);
        //calculos.generaExtension(lectura.getVecProb());
        System.out.println(calculos.entropiaFuente(lectura.getVecProb()));
        calculos.calculaCantInfo(lectura.getVec(), lectura.getVecProb());
    }
}
