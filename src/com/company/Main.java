package com.company;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
public static char [][] chemicals = new char [50][2];
    public static ArrayList<String>datos;
    public static String [][] matriz = new String [100][2];
    public static String [][] resultados = new String [6][2];
    public static void main(String[] args) {

String cadena1="CCOc1ccccc1O[C@@H](c1ccccc1)[C@H]1OCC[NH2+]C1";
String cadena2="CCOc1ccccc1O[C@@H](c1ccccc1)[C@@H]1OCC[NH2+]C1";
datos = new ArrayList<String>();

        System.out.print("El numero de elementos: "+numeroElemntos(cadena1));
        System.out.print("\n");
        numeroElemntos(cadena1);
        for(String cadena : datos){
            System.out.println(cadena);
        }

        System.out.println("hola "+ datos.get(2));
        conteo(cadena1,datos);
        imprimirMatriz(resultados);


    }
    public static int comprobar (String cadena1,String cadena2){

        return 0;
    }
    public static int numeroElemntos (String cadena1){
        int fila=0;
        int columna=0;
        int cont=0;
        chemicals[0][0]= cadena1.charAt(0);
        char letra = chemicals[0][0];
        int numElementos=cadena1.length();
        for(int i =0;i<cadena1.length();i++){
            if(cadena1.charAt(i)==91||cadena1.charAt(i)==93||cadena1.charAt(i)==40||cadena1.charAt(i)==41||cadena1.charAt(i)==92||cadena1.charAt(i)==93||cadena1.charAt(i)==47||cadena1.charAt(i)==43){
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
    public static void conteo(String cadena1, ArrayList<String> dato){
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

}


