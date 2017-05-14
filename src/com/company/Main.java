package com.company;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) throws IOException {
        Tanimoto tan = new Tanimoto();
        tan.printTable();
        tan.writeTable();
    }
}


