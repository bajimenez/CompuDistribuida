package com.company;

import sun.tools.jconsole.Tab;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by santiago on 14/5/17.
 */
public class Tanimoto extends Thread{
        public static ArrayList<String>datos;
        public static ArrayList<String>datos2;
        public static ArrayList<Elements>result;
        public static ArrayList<Elements>result2;
        private int k;
        private int l;
        private ArrayList<TableComparison> finaltable;

        public Tanimoto(int k, int l, ArrayList<TableComparison> finaltable) {
            this.k = k;
            this.l = l;
            this.finaltable = finaltable;
        }

        public void Before(int cont, int i, int j) throws FileNotFoundException {
            float temTani=0;
            Data dat = new Data();
            TableComparison aux;

            temTani=completeTanimoto(datos, datos2, dat.alldata.get(i).getSmile(), dat.alldata.get(j).getSmile(), result, result2);

            if (temTani>=0.5) {
                aux = new TableComparison();
                aux.setIndex(cont);
                aux.setid1(dat.alldata.get(i).getId());
                aux.setid2(dat.alldata.get(j).getId());
                aux.setcoefftanimoto(temTani);
                finaltable.add(aux);
            }
        }

        @Override
        public void run() {
            int cont = 0;
            for (int i = k; i < l; i++) {
                for (int j = 1; j < 12385; j++) {
                    cont = cont + 1;
                    try {
                        Before(cont, i, j);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        public static void printTable(ArrayList<TableComparison> auxfinal) {
            for(int i=0; i<auxfinal.size(); i++) {
                System.out.print(auxfinal.get(i).getIndex() + "\t" + auxfinal.get(i).getid1() + "\t" + auxfinal.get(i).getid2() + "\t" + auxfinal.get(i).getcoefftanimoto() + "\n");
            }
        }
/*
        public static void writeTable() throws IOException {
            File fs = new File("TableComparison.txt");
            BufferedWriter salida = new BufferedWriter(new FileWriter(fs));
            try{
                for(int i=0; i<finaltable.size(); i++) {
                    salida.write(finaltable.get(i).getIndex() + "\t" + finaltable.get(i).getid1() + "\t" + finaltable.get(i).getid2() + "\t" + finaltable.get(i).getcoefftanimoto() + "\n");
                }
            }
            catch(IOError e) {
                e.printStackTrace();
            }
            salida.close();
        }
*/
        public static int numberElements(ArrayList<Elements> result) {
            int cont = 0;
            for(int i =0; i<result.size(); i++) {
                cont = cont + result.get(i).getNumber();
            }
            return cont;
        }

        public static void diffelements(String cadena1, ArrayList<String>datos){
            for(int i =0;i<cadena1.length();i++){
                if(cadena1.charAt(i)==91||cadena1.charAt(i)==93||cadena1.charAt(i)==40||
                        cadena1.charAt(i)==41||cadena1.charAt(i)==92||cadena1.charAt(i)==93||
                        cadena1.charAt(i)==47||cadena1.charAt(i)==43||cadena1.charAt(i)==45||
                        cadena1.charAt(i)==61){
                }
                else {
                    if(cadena1.charAt(i)<48 || cadena1.charAt(i)>57){
                        datos.add(String.valueOf(cadena1.charAt(i)));
                        HashSet<String> hashSet = new HashSet<String>(datos);
                        datos.clear();
                        datos.addAll(hashSet);
                    }
                }
            }
        }

        public static void print(ArrayList<Elements> array){
            for(int i=0;i<array.size();i++){
                System.out.print(array.get(i));
            }
        }

        public static void counting(String cadena1, ArrayList<String> dato, ArrayList<Elements> result){
            int cont=0;
            Elements aux;
            for (int i =0; i<dato.size();i++){
                for (int j=0;j<cadena1.length();j++){
                    if(dato.get(i).equals(String.valueOf(cadena1.charAt(j)))){
                        cont=cont+1;
                    }
                    else if(dato.get(i).equals("@")) {
                        cont = 1;
                    }
                }
                aux = new Elements();
                aux.setName(dato.get(i));
                aux.setNumber(cont);
                result.add(aux);
                cont=0;
            }
        }

        public  static float calculatetanimoto(int Na, int Nb,int Nc){
            float tanimoto;

            tanimoto=(float)Nc/((float)Na+(float)Nb-(float)Nc);

            return tanimoto ;
        }

        public static int common(ArrayList<Elements> result, ArrayList<Elements> result2) {
            int a = 0;
            for(int i=0; i<result.size(); i++) {
                for(int j=0; j<result2.size(); j++) {
                    if(result.get(i).getName().equals(result2.get(j).getName())) {
                        if(result.get(i).getNumber() <= result2.get(j).getNumber()) {
                            a = a + result.get(i).getNumber();
                        }
                    }
                }
            }
            return a;
        }

        public static float completeTanimoto (ArrayList<String >datos,ArrayList<String>datos2,String cadena1, String cadena2
                ,ArrayList<Elements>result,ArrayList<Elements>result2){
            int Na,Nb,Nc;
            float total;
            datos = new ArrayList<String>();
            datos2 = new ArrayList<String>();

            diffelements(cadena1, datos);
            result = new ArrayList<Elements>();
            counting(cadena1,datos,result);
            Na = numberElements(result);
            diffelements(cadena2, datos2);
            result2 = new ArrayList<Elements>();
            counting(cadena2,datos2,result2);
            Nb = numberElements(result2);
            Nc = common(result, result2);
            total=calculatetanimoto(Na,Nb,Nc);

            return total;
        }
}
