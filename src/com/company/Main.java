package com.company;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
public static char [][] chemicals = new char [50][2];
    public static ArrayList<String>datos;
    public static ArrayList<String>datos2;
    public static String [][] matriz = new String [100][2];
    public static String [][] resultados ;
    public static String [][] resultados2 ;
    public static void main(String[] args) {
        int Na,Nb,Nc;

String cadena1="CCOc1ccccc1O[C@@H](c1ccccc1)[C@H]1OCC[NH2+]C1";
String cadena2="CCOc1ccccc1O[C@@H](c1ccccc1)[C@@H]1OCC[NH2+]C1";
datos = new ArrayList<String>();
        datos2 = new ArrayList<String>();
        Na=numeroElemntos(cadena1,datos);
        System.out.print("El numero de elementos de la cadena1 es: "+Na);
        System.out.print("\n");
        resultados=new String[datos.size()][2];
        conteo(cadena1,datos,resultados);
        imprimirMatriz(resultados);

        /////////////////////////////////
        Nb=numeroElemntos(cadena2,datos2);
        System.out.print("El numero de elementos de la cadena2 es: "+Nb);
        System.out.print("\n");
        resultados2=new String[datos2.size()][2];
        conteo(cadena2,datos2,resultados2);
        imprimirMatriz(resultados2);
        Nc=comunes(resultados,resultados2);
        System.out.print("\n Los elementos comunes son: "+ Nc);
        System.out.print("\nEl coeficiente es:"+ tanimoto(Na,Nb,Nc));


    }
    public static int comprobar (String cadena1,String cadena2){

        return 0;
    }
    public static int numeroElemntos (String cadena1, ArrayList<String>datos){
        int fila=0;
        int columna=0;
        int cont=0;
        chemicals[0][0]= cadena1.charAt(0);
        char letra = chemicals[0][0];
        int numElementos=cadena1.length();
        for(int i =0;i<cadena1.length();i++){
            if(cadena1.charAt(i)==91||cadena1.charAt(i)==93||cadena1.charAt(i)==40||
                    cadena1.charAt(i)==41||cadena1.charAt(i)==92||cadena1.charAt(i)==93||
                    cadena1.charAt(i)==47||cadena1.charAt(i)==43||cadena1.charAt(i)==45||
                    cadena1.charAt(i)==61){
                numElementos=numElementos-1;

            }
            else {
                if(cadena1.charAt(i)<48 || cadena1.charAt(i)>57){

                    datos.add(String.valueOf(cadena1.charAt(i)));
                    letra = cadena1.charAt(i);
                    HashSet<String> hashSet = new HashSet<String>(datos);
                    datos.clear();
                    datos.addAll(hashSet);
                }
            }

        }
        return numElementos;
    }
    public static void imprimirMatriz(String [][] matriz){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                System.out.print(matriz[i][j]);
            }
            System.out.print("\n");
        }
    }
    public static void conteo(String cadena1, ArrayList<String> dato,String[][] resultados){
        int cont=0;


        for (int i =0; i<dato.size();i++){

            for (int j=0;j<cadena1.length();j++){
                if(dato.get(i).equals(String.valueOf(cadena1.charAt(j)))){
                   cont=cont+1;

                }

            }
            resultados[i][1]=String.valueOf(cont);
            resultados[i][0]=dato.get(i);
            cont=0;
        }
    }
    public  static float tanimoto (int Na, int Nb,int Nc){
        float tanimoto;

        tanimoto=(float)Nc/((float)Na+(float)Nb-(float)Nc);

        return tanimoto ;


    }
    public static void imprimirArray (ArrayList<String>datos){
        for(String cadena : datos){
            System.out.println(cadena);
        }
    }
    public static int comunes (String[][] resultados, String[][] resultados2){
        int elementosComunes=0;
        for (int i=0;i<resultados.length;i++){
            for (int j=0;j<resultados2.length;j++){

        if(resultados[i][0].equals(resultados2[j][0])){
            if(Integer.valueOf(resultados[i][1])<=Integer.valueOf(resultados2[i][1])){
                elementosComunes=elementosComunes+Integer.valueOf(resultados[i][1]);
            }
            else{elementosComunes=elementosComunes+Integer.valueOf(resultados2[i][1]);}
        }
    }
}
        return elementosComunes;
    }


}


