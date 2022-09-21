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

    public void generaExtension(){
        String linea="";
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

                                                                                        linea += "|| "+vec[a]+vec[b]+vec[c]+vec[d]+vec[e]+vec[f]+vec[g]+vec[h]+vec[i]+vec[j]+vec[k]+vec[l]+vec[m]+vec[n]+vec[o]+vec[p]+vec[q]+vec[r]+vec[s]+vec[t]+"|| ";
                                                                                        System.out.println(linea);
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
    }

   /* public void escribeArch (String linea){
        try {
            String ruta = "/ruta/filename.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(linea);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}












