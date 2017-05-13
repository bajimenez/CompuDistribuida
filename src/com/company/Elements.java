package com.company;

/**
 * Created by santiago on 13/5/17.
 */
public class Elements {
    private String name;
    private int number;

    public Elements(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Elements() {

    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Element : " + name + " --> Number : " + number + "\n";
    }
}
