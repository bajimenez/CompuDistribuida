package com.company;

/**
 * Created by santiago on 13/5/17.
 */
public class Chemicals {
    private String index;
    private String id;
    private String key;
    private String Smile;

    public Chemicals(String index, String id, String key, String smile) {
        this.index = index;
        this.id = id;
        this.key = key;
        Smile = smile;
    }

    public Chemicals() {
    }

    public String getIndex() {
        return index;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getSmile() {
        return Smile;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setSmile(String smile) {
        Smile = smile;
    }
}
