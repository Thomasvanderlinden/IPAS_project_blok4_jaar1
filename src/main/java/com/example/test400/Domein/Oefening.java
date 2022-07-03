package com.example.test400.Domein;

public class Oefening {
    private String naam;
    private int tijd;
    private int verbrande_kcal;
    private String spiergroep;
    private String omschrijving;
    private String plaatje;

    private static Oefening myOefening = new Oefening();
    public static Oefening getOefening(){
        return myOefening;
    }
    public static void setOefening(Oefening oefening){
        myOefening = oefening;
    }

    public Oefening(String naam, int tijd, int verbrande_kcal, String spiergroep, String omschrijving, String plaatje){
        this.naam = naam;
        this.tijd = tijd;
        this.verbrande_kcal = verbrande_kcal;
        this.spiergroep = spiergroep;
        this.omschrijving = omschrijving;
        this.plaatje = plaatje;
    }
    public Oefening(){}



    public String getOmschrijving() {
        return omschrijving;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setTijd(int tijd) {
        this.tijd = tijd;
    }

    public void setVerbrande_kcal(int verbrande_kcal) {
        this.verbrande_kcal = verbrande_kcal;
    }

    public void setSpiergroep(String spiergroep) {
        this.spiergroep = spiergroep;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public void setPlaatje(String plaatje) {
        this.plaatje = plaatje;
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
