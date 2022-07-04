package com.example.test400.Domein.Tips;

import com.example.test400.App.StartupListener;
import com.example.test400.Domein.Oefening;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tips implements Serializable {
    private String tipnaam;
    private String onderwerp;
    private String tekstVanDeTip;
    private String auteur;


    public static ArrayList<Tips> alleTips;

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

    public Tips(){}




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

    public ArrayList<Tips> getAlleTips() {
        return alleTips;
    }

    public void setAlleTips(ArrayList<Tips> alleTips) {
        this.alleTips = alleTips;
    }

    public static Tips getMyTip() {
        return myTip;
    }

    public static void setMyTip(Tips myTip) {
        Tips.myTip = myTip;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
