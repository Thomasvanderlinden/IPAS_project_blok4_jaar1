package com.example.test400.Domein.Blog;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Mening> magniet = new ArrayList<>();

    public Blog(ArrayList<Mening> magniet){
        this.magniet = magniet;
    }
    public ArrayList<Mening> getBlog(){
        return magniet;
    }
}
