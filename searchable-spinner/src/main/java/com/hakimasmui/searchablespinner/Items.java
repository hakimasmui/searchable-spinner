package com.hakimasmui.searchablespinner;

public class Items {
    int id;
    String name;
    String sub_name;

    public Items(int id, String name, String sub_name) {
        this.id = id;
        this.name = name;
        this.sub_name = sub_name;
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

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }
}
