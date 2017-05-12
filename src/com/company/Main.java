package com.company;

public class Main {
public static String [][] chemicals;
    public static void main(String[] args) {

String cadena1="CCOc1ccccc1O[C@@H](c1ccccc1)[C@H]1OCC[NH2+]C1";
String cadena2="CCOc1ccccc1O[C@@H](c1ccccc1)[C@@H]1OCC[NH2+]C1";
        System.out.print("El numero de elementos: "+numeroElemntos(cadena1));



    }
    public static int comprobar (String cadena1,String cadena2){

        return 0;
    }
    public static int numeroElemntos (String cadena1){
        int fila=0;
        int columna=0;
        int conl=0,n=0;
        int numElementos=cadena1.length();
        for(int i =0;i<cadena1.length();i++){
            if(cadena1.charAt(i)==91||cadena1.charAt(i)==93||cadena1.charAt(i)==40||cadena1.charAt(i)==41||cadena1.charAt(i)==92||cadena1.charAt(i)==93||cadena1.charAt(i)==47){
                numElementos=numElementos-1;
            }
            char letra = cadena1.charAt(n);
          if(letra == cadena1.charAt(i)){
              conl = conl + 1;
            chemicals[fila][columna]=String.valueOf(letra);
            chemicals[fila][columna+1]= String.valueOf(conl);
          }
          else {
              letra = cadena1.charAt(i);
              conl = 1;
          }
        }


        return numElementos;
    }
    public void imprimirMatriz(String[][] matriz){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz)
        }

    }

}


