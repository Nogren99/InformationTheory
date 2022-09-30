package modelo;
import Exepciones.noSePudoLeerException;
import modelo.Lectura;
import java.util.Arrays;

import static modelo.Lectura.*;

public class Calculos {

    public float matProbabilidades[][];
    public Lectura lectura = new Lectura();

    public Calculos() {

        this.matProbabilidades = new float[3][3];

    }

    public void  totalColumna(int mat[][]){

        int totalColumnas[]={0,0,0};
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                totalColumnas[i] += mat[j][i];
            }
        }
        /*
        for(int i=0;i<3;i++){
            System.out.println(totalColumnas[i]);
        }
        */
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                this.matProbabilidades[i][j] = (float)mat[i][j]/totalColumnas[j];
            }
        }


    }

    public void muestraMatriz(){
        System.out.println("Matriz de probabilidades:");
        for(int i=0;i<3;i++){
            System.out.print("|");
            for(int j=0;j<3;j++){
                System.out.print(" "+this.matProbabilidades[i][j]+" | ");
            }
            System.out.println();
        }
    }

    public void memoriaNula(){
        float promFila;
        int i=0,j=0;
        boolean bandera=true;
        
        while( i<=2 && bandera){
            promFila = (matProbabilidades[i][0]+matProbabilidades[i][1]+matProbabilidades[i][2] ) / 3;
            while( j<=2 && bandera){
                if( Math.abs(matProbabilidades[i][j]-promFila)>=0.03  )
                    bandera=false;
                j++;
            }
            i++;
        }
        if(bandera){
            System.out.println("MEMORIA NULA : SIMBOLOS ESTADISTICAMENTE INDEPENDIENTE");
            //this.generaExtension();
            try {
                Lectura.getInstance().calculaProb();
            } catch (noSePudoLeerException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Entropia fuente: "+this.entropiaFuente());
            System.out.println("Entropia orden 20: "+this.entropiaOrdenN(20));
        }

        else
            System.out.println("NO NULA");
    }

    public void generaExtension(){
        String linea="";
        double entropia = 0;
        double vecProb[] = Lectura.getInstance().getVecProb();
        //char linea[] = new char[];
        char vec[] = new char[]{'A', 'B', 'C'};
        for (int a = 0; a < 3; a++){
            for (int b=0; b < 3; b++){
                for (int c = 0; c < 3; c++){
                    for (int d = 0; d < 3; d++){
                        for (int e = 0; e < 3; e++){
                            for (int f = 0; c < 3; c++){
                                for (int g = 0; g < 3; g++){
                                    for (int h = 0; h < 3; h++){
                                        for (int i = 0;  i< 3; i++){
                                            for (int j = 0; j < 3; j++){
                                                for (int k = 0; k < 3; k++){
                                                    for (int l = 0; l < 3; l++){
                                                        for (int m = 0; m < 3; m++){
                                                            for (int n = 0; n < 3; n++){
                                                                for (int o = 0; o < 3; o++){
                                                                    for (int p = 0; p < 3; p++){
                                                                        for (int  q = 0; q < 3; q++){
                                                                            for (int r = 0; r < 3; r++){
                                                                                for (int s = 0; s < 3; s++){
                                                                                    for (int t = 0; t < 3; t++){
                                                                                        entropia += vecProb[a]*( Math.log10(1/vecProb[a]) / Math.log10(3))*vecProb[b]*( Math.log10(1/vecProb[b]) / Math.log10(3))*vecProb[c]*( Math.log10(1/vecProb[c]) / Math.log10(3))*vecProb[d]*( Math.log10(1/vecProb[d]) / Math.log10(3))*vecProb[e]*( Math.log10(1/vecProb[e]) / Math.log10(3))*vecProb[f]*( Math.log10(1/vecProb[f]) / Math.log10(3))*vecProb[g]*( Math.log10(1/vecProb[g]) / Math.log10(3))*vecProb[h]*( Math.log10(1/vecProb[h]) / Math.log10(3))*vecProb[i]*( Math.log10(1/vecProb[i]) / Math.log10(3))*vecProb[j]*( Math.log10(1/vecProb[j]) / Math.log10(3))*vecProb[k]*( Math.log10(1/vecProb[k]) / Math.log10(3))*vecProb[l]*( Math.log10(1/vecProb[l]) / Math.log10(3))*vecProb[m]*( Math.log10(1/vecProb[m]) / Math.log10(3))*vecProb[n]*( Math.log10(1/vecProb[n]) / Math.log10(3))*vecProb[o]*( Math.log10(1/vecProb[o]) / Math.log10(3))*vecProb[p]*( Math.log10(1/vecProb[p]) / Math.log10(3))*vecProb[q]*( Math.log10(1/vecProb[q]) / Math.log10(3))*vecProb[r]*( Math.log10(1/vecProb[r]) / Math.log10(3))*vecProb[s]*( Math.log10(1/vecProb[s]) / Math.log10(3))*vecProb[t]*( Math.log10(1/vecProb[t]) / Math.log10(3));
                                                                                        linea += "|| "+vec[a]+vec[b]+vec[c]+vec[d]+vec[e]+vec[f]+vec[g]+vec[h]+vec[i]+vec[j]+vec[k]+vec[l]+vec[m]+vec[n]+vec[o]+vec[p]+vec[q]+vec[r]+vec[s]+vec[t]+"|| ";
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Entropia extension orden 20: "+entropia);
    }

    public double entropiaFuente (){
        double entropia=0;
        double vecProb[]= Lectura.getInstance().getVecProb();
        for (int i=0; i<3; i++){
            entropia += vecProb[i]*( Math.log10(1/vecProb[i]) / Math.log10(3));
        }
        return entropia;
    }

    public double entropiaOrdenN (int n){
        return n*this.entropiaFuente();
    }

    public void calculaCantInfo(){
        String vec[]=Lectura.getInstance().getVec();
        double vecProb[]=Lectura.getInstance().getVecProb();
        double cantInfo = 0, entropia = 0, probabilidad;
        int n=vec[0].length();
        //System.out.println(n);
        char car;
        for (int i=0; i<vec.length; i++){
            car = vec[i].charAt(0); //voy leyendo cada caracter de cada posicion del vector. Por ej si tengo CBA, lee primero la C, desp la B y así
            probabilidad = vecProb[Lectura.getInstance().getAlfabeto().get(car)];
            for (int j=1; j<n; j++){
                car = vec[i].charAt(j); //voy leyendo cada caracter de cada posicion del vector. Por ej si tengo CBA, lee primero la C, desp la B y así
                probabilidad = probabilidad*vecProb[Lectura.getInstance().getAlfabeto().get(car)];
            }
            entropia += probabilidad*( Math.log10(1/probabilidad) / Math.log10(3));
            cantInfo += Math.log10(1/probabilidad) / Math.log10(3);
        }
        System.out.println("Entropia 2a: " +entropia);
        System.out.println("CantInfo 2a: " +cantInfo);
    }

    

}












