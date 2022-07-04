package com.example.test400.Domein.Blog;

import com.example.test400.App.StartupListener;
import com.example.test400.Domein.Tekstvoorblog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Blog implements Serializable {


    private final List<Mening> allMeningen = new ArrayList<>();

    private static Blog myBlog = new Blog();

    public static Blog getBlog() {
        return myBlog;
    }

    public static void setBlog(Blog blog) {
        myBlog = blog;
    }

    private Blog() {
        allMeningen.add(new Mening("Wanneer is sporten ongezond?", "Elke dag naar de sportschool om te ontsnappen aan de stress, of om je uiterlijk te verbeteren: dat geeft een goed gevoel. Maar sportief gedrag kan problematisch worden. Kan je verslaafd raken aan sporten?", Tekstvoorblog.tekstArtikel1));
        allMeningen.add(new Mening("Zweten voorkomt vergeten", "Proefpersonen die na een stevige geheugentaak gingen sporten, kenden de leerstof twee dagen later beter dan degenen die niet sportten. Maar het werkt alleen als je het sporten vier uur uitstelt. Goed om rekening mee te houden, als je deze zomer herexamens hebt.", Tekstvoorblog.tekstVoorArtikel2));

    }

    public List<Mening> getAllMeningen() {
        return allMeningen;
    }

    public void addMening(Mening mening) {
        allMeningen.add(mening);
    }

}
