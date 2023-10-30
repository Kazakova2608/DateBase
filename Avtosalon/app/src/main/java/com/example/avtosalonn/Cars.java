package com.example.avtosalonn;

public class Cars {
    private String name; // название
    private String opisanie;  // столица
    private int kartinka; // ресурс флага

    public Cars(String name, String capital, int flag){

        this.name=name;
        this.opisanie=capital;
        this.kartinka=flag;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpisanie() {
        return this.opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public int getKartinka() {
        return this.kartinka;
    }

    public void setKartinka(int kartinka) {
        this.kartinka = kartinka;
    }
}
