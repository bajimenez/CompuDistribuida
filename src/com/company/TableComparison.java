package com.company;

/**
 * Created by santiago on 14/5/17.
 */
public class TableComparison {
    private int index;
    private String id1;
    private String id2;
    private float coefftanimoto;

    public TableComparison(int index, String id1, String id2, float coefftanimoto) {
        this.index = index;
        this.id1 = id1;
        this.id2 = id2;
        this.coefftanimoto = coefftanimoto;
    }

    public TableComparison() {
    }

    public int getIndex() {
        return index;
    }

    public String getid1() {
        return id1;
    }

    public String getid2() {
        return id2;
    }

    public float getcoefftanimoto() {
        return coefftanimoto;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setid1(String id1) {
        this.id1 = id1;
    }

    public void setid2(String id2) {
        this.id2 = id2;
    }

    public void setcoefftanimoto(float coefftanimoto) {
        this.coefftanimoto = coefftanimoto;
    }
}
