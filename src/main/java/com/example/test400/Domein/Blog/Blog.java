package com.example.test400.Domein.Blog;

import com.example.test400.App.StartupListener;

import java.util.ArrayList;
import java.util.List;

public class Blog {


    private final List<Mening> allMeningen = new ArrayList<>();

    private static Blog myBlog = new Blog();

    public static Blog getBlog() {
        return myBlog;
    }

    public static void setBlog(Blog blog) {
        myBlog = myBlog;
    }

    private Blog() {
        allMeningen.add(new Mening("test","test","test"));
        allMeningen.add(new Mening("test1","test1","test1"));
    }

    public List<Mening> getAllMeningen() {
        return allMeningen;
    }

    public void addMening(Mening mening){
        allMeningen.add(mening);
    }

}
