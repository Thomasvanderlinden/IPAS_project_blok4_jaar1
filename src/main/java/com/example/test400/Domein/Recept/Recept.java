package com.example.test400.Domein.Recept;

import java.util.ArrayList;
public class Recept {
    private String naam;
    private int energie;
    private int koolhydraten;
    private int eiwitten;
    private int vetten;
    private ArrayList<IngredientenRecept> ingredienten = new ArrayList<>();

    public Recept(String naam,int energie, int koolhydraten, int eiwitten, int vetten, ArrayList<IngredientenRecept> ingredientenRecepts){
        this.naam = naam;
        this.energie = energie;
        this.koolhydraten = koolhydraten;
        this.eiwitten = eiwitten;
        this.vetten = vetten;
        this.ingredienten = ingredientenRecepts;
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getKoolhydraten() {
        return koolhydraten;
    }

    public void setKoolhydraten(int koolhydraten) {
        this.koolhydraten = koolhydraten;
    }

    public int getEiwitten() {
        return eiwitten;
    }

    public void setEiwitten(int eiwitten) {
        this.eiwitten = eiwitten;
    }

    public int getVetten() {
        return vetten;
    }

    public ArrayList<IngredientenRecept> getIngredienten() {
        return ingredienten;
    }

    public void setVetten(int vetten) {
        this.vetten = vetten;
    }


}
