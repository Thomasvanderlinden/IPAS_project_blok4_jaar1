package com.example.test400.Domein.blog;

public class Blog {
    private Mening mening;

    public Blog(Mening mening){
        this.mening = mening;
    }

    public Mening getMening() {
        return mening;
    }

    public void setMening(Mening mening) {
        this.mening = mening;
    }
}
