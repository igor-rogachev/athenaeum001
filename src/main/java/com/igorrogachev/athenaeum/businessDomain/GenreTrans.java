package com.igorrogachev.athenaeum.businessDomain;

public class GenreTrans {
    private int id;
    private String name;

    public GenreTrans(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreTrans() {
        name = new String();
    }

    public GenreTrans(String name) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
