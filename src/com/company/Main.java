package com.company;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        ArrayList<TableComparison> array1 = new ArrayList<TableComparison>();
        ArrayList<TableComparison> array2 = new ArrayList<TableComparison>();

        Tanimoto tan = new Tanimoto(0, 1000, array1);
        tan.start();

        Tanimoto tan1 = new Tanimoto(1000, 2000, array2);
        tan1.start();

        tan.join();
        tan1.join();

        tan.printTable(array1);
        tan1.printTable(array2);

    }
}

