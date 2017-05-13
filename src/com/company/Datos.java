package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Datos
{
    String [] arreglo= new String[15000];
    String [] arreglo1= new String[15000];
    String [] arreglo2= new String[15000];
    String [] arreglo3= new String[15000];
    String datos ="";
    int i=0;
    int j=0;
    int k=0;
    int l=0;
    public Datos() throws FileNotFoundException {


        File fe = new File("ZINC_chemicals.tsv");
        BufferedReader entrada = new BufferedReader(new FileReader(fe));
        try {
            while(entrada.ready()&& i<15000)
            {
                datos = entrada.readLine();
                StringTokenizer tokens = new StringTokenizer(datos, "\t");
                arreglo[i]= tokens.nextToken();
                arreglo1[j]=tokens.nextToken();
                arreglo2[k]=tokens.nextToken();
                arreglo3[l]=tokens.nextToken();
                System.out.println("arreglo: "+arreglo[i]);
                //System.out.println("arreglo2"+arreglo1[j]);
                //System.out.println("arreglo3"+arreglo2[k]);
                System.out.println("Smiles: "+arreglo3[l]);

                i++;
                j++;
                k++;
                l++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public String[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(String[] arreglo) {
        this.arreglo = arreglo;
    }

    public String[] getArreglo1() {
        return arreglo1;
    }

    public void setArreglo1(String[] arreglo1) {
        this.arreglo1 = arreglo1;
    }

    public String[] getArreglo2() {
        return arreglo2;
    }

    public void setArreglo2(String[] arreglo2) {
        this.arreglo2 = arreglo2;
    }

    public String[] getArreglo3() {
        return arreglo3;
    }

    public void setArreglo3(String[] arreglo3) {
        this.arreglo3 = arreglo3;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

}