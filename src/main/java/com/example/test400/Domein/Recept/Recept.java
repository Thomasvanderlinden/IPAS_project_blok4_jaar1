package com.example.test400.Domein.Recept;

import java.util.ArrayList;
public class Recept {
    private String naam;
    private int kilocalorieën;
    private int koolhydraten;
    private int eiwitten;

    private int vetten;
    private ArrayList<IngredientenRecept> ingredienten;
    private String omschrijving;
    private String plaatje;
    private String bereidingswijze;

    public Recept(String naam,int kilocalorieën,   int koolhydraten, int eiwitten, int vetten, ArrayList<IngredientenRecept> ingredientenRecepts,String bereidingswijze, String omschrijving, String plaatje){
        this.naam = naam;
        this.kilocalorieën = kilocalorieën;
        this.bereidingswijze = bereidingswijze;
        this.koolhydraten = koolhydraten;
        this.eiwitten = eiwitten;
        this.vetten = vetten;
        this.ingredienten = ingredientenRecepts;
        this.omschrijving = omschrijving;
        this.plaatje = plaatje;
    }

    public void setEnergie(int energie) {
        this.kilocalorieën = energie;
    }

    public void setIngredienten(ArrayList<IngredientenRecept> ingredienten) {
        this.ingredienten = ingredienten;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public void setPlaatje(String plaatje) {
        this.plaatje = plaatje;
    }

    public String getBereidingswijze() {
        return bereidingswijze;
    }

    public void setBereidingswijze(String bereidingswijze) {
        this.bereidingswijze = bereidingswijze;
    }

    public int getEnergie() {
        return kilocalorieën;
    }

    public String getPlaatje() {
        return plaatje;
    }

    public String getOmschrijving() {
        return omschrijving;
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
