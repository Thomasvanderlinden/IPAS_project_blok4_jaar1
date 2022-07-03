package com.example.test400.Domein.Recept;

public class IngredientenRecept {
    private String naam;
    private String hoeveelheid;

    public IngredientenRecept(String naam, String hoeveelheid) {
        this.naam = naam;
        this.hoeveelheid = hoeveelheid;
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(String hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }

    @Override
    public String toString() {
        return naam + ": " + hoeveelheid;
    }
}

