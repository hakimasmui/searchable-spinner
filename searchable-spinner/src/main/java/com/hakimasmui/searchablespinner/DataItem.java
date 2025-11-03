package com.hakimasmui.searchablespinner;

public class DataItem {
    String kode;
    String name;
    String sub_name;

    public DataItem() {

    }

    public DataItem(String kode, String name, String sub_name) {
        this.kode = kode;
        this.name = name;
        this.sub_name = sub_name;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
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
