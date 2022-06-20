package com.example.test400.Domein.Blog;

public class Mening {
    private String naam;
    private String onderwerp;
    private String tekst;

    public Mening(String naam, String onderwerp, String tekst){
        this.naam = naam;
        this.onderwerp = onderwerp;
        this.tekst = tekst;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
