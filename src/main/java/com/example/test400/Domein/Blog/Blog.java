package com.example.test400.Domein.Blog;

import com.example.test400.App.StartupListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Blog  implements Serializable{


    private final List<Mening> allMeningen = new ArrayList<>();

    private static Blog myBlog = new Blog();

    public static Blog getBlog() {
        return myBlog;
    }

    public static void setBlog(Blog blog) {
        myBlog = blog;
    }

    private Blog() {
        allMeningen.add(new Mening("Artikel 1", "Wat als alles anders gaat", "SEO Company BrightEdge unveiled new research findings on the performance of Organic and " + "Paid Search as a marketing channel. The strength of search marketing  Organic Search and Paid Search - " + "is clear. Organic Search remains the dominant source of trackable web traffic and in the dominant position as a channel." + " Paid Search continues to grow. Organic Social Media is flat since 2014at 5 %, and though ubiquitous, contributes on average" + " 1 / 3as much traffic as Paid Search and just 1 / 11as much as Organic Search. Read the report to find out why the Organic " + "Channel grew and what this means for your business. " + "Download the full report to see how organic channel share has continued to dominate year afteryear."));
        allMeningen.add(new Mening("Artikel 2", "Wat als alles anders gaat", "SEO Company BrightEdge unveiled new research findings on the performance of Organic and " + "Paid Search as a marketing channel. The strength of search marketing  Organic Search and Paid Search - " + "is clear. Organic Search remains the dominant source of trackable web traffic and in the dominant position as a channel." + " Paid Search continues to grow. Organic Social Media is flat since 2014at 5 %, and though ubiquitous, contributes on average" + " 1 / 3as much traffic as Paid Search and just 1 / 11as much as Organic Search. Read the report to find out why the Organic " + "Channel grew and what this means for your business. " + "Download the full report to see how organic channel share has continued to dominate year afteryear."));

    }

    public List<Mening> getAllMeningen() {
        return allMeningen;
    }

    public void addMening(Mening mening){
        allMeningen.add(mening);
    }

}
