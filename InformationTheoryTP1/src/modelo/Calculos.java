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
        for(int i=0;i<3;i++){
            System.out.println(totalColumnas[i]);
        }

        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                this.matProbabilidades[i][j] = (float)mat[i][j]/totalColumnas[j];
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(this.matProbabilidades[i][j]+" ");
            }
            System.out.println();
        }
    }


}
