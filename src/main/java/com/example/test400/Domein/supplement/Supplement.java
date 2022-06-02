package com.example.test400.Domein.supplement;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Supplement {
    private String naam;
    private int koolhydraten;
    private int eiwitten;
    private int vetten;
    private ArrayList<IngredientenSupplement> ingredientenSupplement;

    public Supplement(String naam, int koolhydraten, int eiwitten, int vetten, ArrayList<IngredientenSupplement> ingredientenSupplements) {
        this.naam = naam;
        this.koolhydraten = koolhydraten;
        this.eiwitten = eiwitten;
        this.vetten = vetten;
        this.ingredientenSupplement = ingredientenSupplements;
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

    public ArrayList<IngredientenSupplement> getIngredientenSupplement() {
        return ingredientenSupplement;
    }



    public int getVetten() {
        return vetten;
    }

    public void setVetten(int vetten) {
        this.vetten = vetten;
    }


}
