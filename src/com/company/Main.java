package com.company;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;


public class Main {
    public static ArrayList<String>datos;
    public static ArrayList<String>datos2;
    public static ArrayList<Elements>result;
    public static ArrayList<Elements>result2;

    public static void main(String[] args) throws FileNotFoundException {
        int Na,Nb,Nc;
        String cadena1="CCCCCC(=O)O[C@@H]1[C@@H](OC(=O)/C(=C\\C)/C)C(=C2[C@H]1[C@@](C)(OC(=O)C)C[C@@H]([C@]1([C@H]2OC(=O)[C@@]1(C)O)O)OC(=O)CCC)C";
        String cadena2="CCCCCCCC(=O)O[C@@H]1[C@@H](OC(=O)/C(=C\\C)/C)C(=C2[C@H]1[C@@](C)(OC(=O)C)C[C@@H]([C@]1([C@H]2OC(=O)[C@@]1(C)O)O)OC(=O)CCC)C";



        System.out.print("\nEl coeficiente es:");
        System.out.print(completeTanimoto(datos,datos2,cadena1,cadena2,result,result2));
    }

    public static int comprobar (String cadena1,String cadena2){

        return 0;
    }

    public static int numberElements(ArrayList<Elements> result) {
        int cont = 0;
        for(int i =0; i<result.size(); i++) {
            cont = cont + result.get(i).getNumber();
        }
        return cont;
    }

    public static void elementos (String cadena1, ArrayList<String>datos){
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

    public  static float tanimoto (int Na, int Nb,int Nc){
        float tanimoto;

        tanimoto=(float)Nc/((float)Na+(float)Nb-(float)Nc);

        return tanimoto ;


    }

    public static int common (ArrayList<Elements> result, ArrayList<Elements> result2) {
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

        elementos(cadena1, datos);
        result = new ArrayList<Elements>();
        counting(cadena1,datos,result);
        Na = numberElements(result);
        elementos(cadena2, datos2);
        result2 = new ArrayList<Elements>();
        counting(cadena2,datos2,result2);
        Nb = numberElements(result2);
        Nc = common(result, result2);
        total=tanimoto(Na,Nb,Nc);

        return total;
    }

    public void
}


