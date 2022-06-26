package com.example.test400.Domein;

public class Oefening {
    private String naam;
    private int tijd;
    private int verbrande_kcal;
    private String spiergroep;
    private String omschrijving;
    private String plaatje;

    public Oefening(String naam, int tijd, int verbrande_kcal, String spiergroep, String omschrijving, String plaatje){
        this.naam = naam;
        this.tijd = tijd;
        this.verbrande_kcal = verbrande_kcal;
        this.spiergroep = spiergroep;
        this.omschrijving = omschrijving;
        this.plaatje = plaatje;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getPlaatje() {
        return plaatje;
    }

    public int getTijd() {
        return tijd;
    }



    public int getVerbrande_kcal() {
        return verbrande_kcal;
    }



    public String getSpiergroep() {
        return spiergroep;
    }



    public String getNaam(){
        return this.naam;
    }

}
