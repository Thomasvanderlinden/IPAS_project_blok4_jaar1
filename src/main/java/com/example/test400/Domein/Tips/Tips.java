package com.example.test400.Domein.Tips;

import com.example.test400.App.StartupListener;
import com.example.test400.Domein.Oefening;

import java.io.Serializable;

public class Tips  {
    private String tipnaam;
    private String onderwerp;
    private String tekstVanDeTip;
    private String auteur;

    private static Tips myTip = new Tips();
    public static Tips getTips(){
        return myTip;
    }
    public static void setTips(Tips tips){
        myTip = tips;
    }
    public Tips(String tipnaam,String onderwerp, String tekstVanDeTip, String auteur) {
        this.tipnaam = tipnaam;
        this.onderwerp = onderwerp;
        this.tekstVanDeTip = tekstVanDeTip;
        this.auteur = auteur;
    }

    public Tips(){
        StartupListener.tipsTricks.add(new Tips("test", "Test", "test", "test"));
    }

    public String getTipnaam() {
        return tipnaam;
    }

    public void setTipnaam(String tipnaam) {
        this.tipnaam = tipnaam;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
    }

    public String getTekstVanDeTip() {
        return tekstVanDeTip;
    }

    public void setTekstVanDeTip(String tekstVanDeTip) {
        this.tekstVanDeTip = tekstVanDeTip;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
