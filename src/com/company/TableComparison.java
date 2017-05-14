package com.company;

/**
 * Created by santiago on 14/5/17.
 */
public class TableComparison {
    private String index;
    private String key1;
    private String key2;
    private String coefftanimoto;

    public TableComparison(String index, String key1, String key2, String coefftanimoto) {
        this.index = index;
        this.key1 = key1;
        this.key2 = key2;
        this.coefftanimoto = coefftanimoto;
    }

    public TableComparison() {
    }

    public String getIndex() {
        return index;
    }

    public String getKey1() {
        return key1;
    }

    public String getKey2() {
        return key2;
    }

    public String getcoefftanimoto() {
        return coefftanimoto;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public void setcoefftanimoto(String coefftanimoto) {
        this.coefftanimoto = coefftanimoto;
    }
}
