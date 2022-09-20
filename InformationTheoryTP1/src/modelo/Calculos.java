package modelo;
import modelo.Lectura;

public class Calculos {

    public float matProbabilidades[][];

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
            promFila= (matProbabilidades[i][0]+matProbabilidades[i][1]+matProbabilidades[i][2] ) / 3;
            while( j<=2 && bandera){
                if( Math.abs(matProbabilidades[i][j]-promFila)>=0.03  )
                    bandera=false;
                j++;
            }
            i++;
        }
        if(bandera)
            System.out.println("MEMORIA NULA : SIMBOLOS ESTADISTICAMENTE INDEPENDIENTE");
        else
            System.out.println("NO NULA");
    }
}












