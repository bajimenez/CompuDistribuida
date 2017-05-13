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

    public Datos() throws FileNotFoundException {
        String [] arreglo= new String[15000];
        String [] arreglo1= new String[15000];
        String [] arreglo2= new String[15000];
        String [] arreglo3= new String[15000];
        String datos ="";
        int i=0;
        int j=0;
        int k=0;
        int l=0;
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
                arreglo3[k]=tokens.nextToken();
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


}