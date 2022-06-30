package com.example.test400.Domein.Blog;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Mening> lijstMetMeningen = new ArrayList<>();

    public Blog(ArrayList<Mening> magniet){
        this.lijstMetMeningen = magniet;
    }
    public ArrayList<Mening> getBlog(){
        return lijstMetMeningen;
    }
}
