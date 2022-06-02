package com.example.test400.Domein;

public class Oefening {
    private String naam;
    private int tijd;
    private int verbrande_kcal;
    private String spiergroep;

    public Oefening(String naam, int tijd, int verbrande_kcal, String spiergroep){
        this.naam = naam;
        this.tijd = tijd;
        this.verbrande_kcal = verbrande_kcal;
        this.spiergroep = spiergroep;
    }


    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getTijd() {
        return tijd;
    }

    public void setTijd(int tijd) {
        this.tijd = tijd;
    }

    public int getVerbrande_kcal() {
        return verbrande_kcal;
    }

    public void setVerbrande_kcal(int verbrande_kcal) {
        this.verbrande_kcal = verbrande_kcal;
    }

    public String getSpiergroep() {
        return spiergroep;
    }

    public void setSpiergroep(String spiergroep) {
        this.spiergroep = spiergroep;
    }

    public String getNaam(){
        return this.naam;
    }

}
