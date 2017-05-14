package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data
{
    ArrayList<Chemicals> alldata;

    public Data() throws FileNotFoundException {
        Chemicals aux;
        alldata = new ArrayList<>();

        String auxdata = "";
        int i=0;
        File fe = new File("ZINC_chemicals.tsv");
        BufferedReader entrada = new BufferedReader(new FileReader(fe));

        try {
            while(entrada.ready()&& i<15000)
            {
                aux = new Chemicals();

                auxdata = entrada.readLine();
                StringTokenizer tokens = new StringTokenizer(auxdata, "\t");
                aux.setIndex(tokens.nextToken());
                aux.setId(tokens.nextToken());
                aux.setKey(tokens.nextToken());
                aux.setSmile(tokens.nextToken());
                alldata.add(aux);

               // System.out.println("arreglo: " + alldata.get(i).getIndex());
                //System.out.println("Smiles: " + alldata.get(i).getSmile());

                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Chemicals> getAlldata() {
        return alldata;
    }

    public void setAlldata(ArrayList<Chemicals> alldata) {
        this.alldata = alldata;
    }
}