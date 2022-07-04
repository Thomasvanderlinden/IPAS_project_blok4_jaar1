package com.example.test400.Domein.Blog;

import java.io.Serializable;

public class Mening implements Serializable {
    private String naam;
    private String onderwerp;
    private String tekst;

    //todo: onnodige getters en setters weghalen:

    public Mening(String naam, String onderwerp, String tekst){
        this.naam = naam;
        this.onderwerp = onderwerp;
        this.tekst = tekst;
    }
    public Mening(){}

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
