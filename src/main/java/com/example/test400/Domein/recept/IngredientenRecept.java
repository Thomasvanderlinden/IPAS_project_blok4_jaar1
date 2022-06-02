package com.example.test400.Domein.recept;

import java.util.ArrayList;

public class IngredientenRecept {
    private String naam;
    private int hoeveelheid;

    public IngredientenRecept(String naam, int hoeveelheid){
        this.naam = naam;
        this.hoeveelheid = hoeveelheid;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }

    @Override
    public String toString() {
        return naam + ": " + hoeveelheid;
    }
}

