package com.example.test400.App;

import com.example.test400.Domein.Favoriet;
import com.example.test400.Domein.Oefening;
import com.example.test400.Domein.Tips.Tips;
import com.example.test400.Domein.Blog.Mening;
import com.example.test400.Domein.Recept.IngredientenRecept;
import com.example.test400.Domein.Recept.Recept;
import com.example.test400.Domein.Supplement.IngredientenSupplement;
import com.example.test400.Domein.Supplement.Supplement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class StartupListener implements ServletContextListener {

    public static ArrayList<Oefening> oefeningen = new ArrayList<>();
    public static ArrayList<Supplement> supplementen = new ArrayList<>();
    public static ArrayList<Mening> blogArtikelen = new ArrayList<>();
    public static ArrayList<Recept> recepten = new ArrayList<>();
    public static ArrayList<Tips> tipsTricks = new ArrayList<>();
    //todo:
    public static ArrayList<Oefening> favorietenLijst = new ArrayList<>();

    public static ArrayList<Oefening> borstLijst = new ArrayList<>();
    public static ArrayList<Oefening> rugLijst = new ArrayList<>();
    public static ArrayList<Oefening> bicepLijst = new ArrayList<>();
    public static ArrayList<Oefening> tricepLijst = new ArrayList<>();

//todo: als attribuut categorie toevoegen zodat ik ze niet zelf in een lijst hoef te doen:

    public void contextInitialized(ServletContextEvent sce) {
        //recept 1
        ArrayList<IngredientenRecept> ingredientenPO = new ArrayList<>();
        ingredientenPO.add(new IngredientenRecept("volkoren penne pasta", 300));
        ingredientenPO.add(new IngredientenRecept("rundergehakt", 500));
        ingredientenPO.add(new IngredientenRecept("tomatenpuree", 70));
        ingredientenPO.add(new IngredientenRecept("gepelde tomaten", 800));
        ingredientenPO.add(new IngredientenRecept("besciamella", 400));
        ingredientenPO.add(new IngredientenRecept("broccoli", 750));
        Recept r1 = new Recept("Pasta-ovenschotel met broccoli", 892, 62, 50, 46, ingredientenPO, "Een heerlijke pastaschotel uit de oven met lekker veel groente in de vorm van broccoli, doperwtjes en een romige saus.", "https://miljuschka.nl/wp-content/uploads/2021/02/Pasta-ovenschotel-met-broccoli-2.jpg");
        //recept 2
        ArrayList<IngredientenRecept> ingredientenOGCG = new ArrayList<>();
        ingredientenOGCG.add(new IngredientenRecept("kruidenpasta", 70));
        ingredientenOGCG.add(new IngredientenRecept("paprika", 1));
        ingredientenOGCG.add(new IngredientenRecept("sperziebonen", 400));
        ingredientenOGCG.add(new IngredientenRecept("eieren", 8));
        ingredientenOGCG.add(new IngredientenRecept("cherrytomaten", 250));
        ingredientenOGCG.add(new IngredientenRecept("bosui", 2));
        ingredientenOGCG.add(new IngredientenRecept("rode ui", 1));
        ingredientenOGCG.add(new IngredientenRecept("stokbrood", 1));
        Recept r2 = new Recept("spaanse curry", 892, 62, 50, 46, ingredientenOGCG, "Deze Thaise rode currypasta is echt heet! Als je deze currypasta gaat maken kun je voor de hoeveelheid pepers het beste uitgaan van wat je normaal verdraag", "https://d1mlbwr23caxox.cloudfront.net/public/sites/default/files/styles/medium/public/recipe-images/Thai_Red_Curry_Paste_0.jpg?VersionId=1ppamqgdDxKgoZaZsFZacwdW74clVLv7&itok=iMvVf5bw");

        recepten.add(r1);
        recepten.add(r2);

//een nieuw supplement aanmaken:

        //supplement 1
        ArrayList<IngredientenSupplement> ingredientenCREA = new ArrayList<>();
        ingredientenCREA.add(new IngredientenSupplement("creatine Monohydraat", 500));
        Supplement s1 = new Supplement("creatine", 300, 33, 66, ingredientenCREA);
        supplementen.add(s1);
        //supplement 2
        ArrayList<IngredientenSupplement> ingredientenWHEY = new ArrayList<>();
        ingredientenWHEY.add(new IngredientenSupplement("weiproteineconcentraat(milk)", 200));
        ingredientenWHEY.add(new IngredientenSupplement("smaakstoffen", 10));
        ingredientenWHEY.add(new IngredientenSupplement("verdikkingsmiddel", 100));
        ingredientenWHEY.add(new IngredientenSupplement("zonnebloem lecthine", 70));
        ingredientenWHEY.add(new IngredientenSupplement("zoetstof", 20));
        Supplement s2 = new Supplement("Eiwitpoeder (Whey)", 380, 30, 39, ingredientenWHEY);
        supplementen.add(s2);

//een nieuwe oefening maken:
        Oefening o1 = new Oefening("bankdrukken", 10, 300, "borst", "bankdrukken omschrijving", "https://upload.wikimedia.org/wikipedia/commons/8/86/Incline-bench-press-1.png");
        oefeningen.add(o1);
        Oefening o2 = new Oefening("fly's", 15, 300, "borst", "fly omschrijving", "https://i.pinimg.com/474x/89/d4/92/89d492813187786c6e293d2c4b1a99e1--chest-routine-kylie-jenner.jpg");
        oefeningen.add(o2);
        Oefening o3 = new Oefening("bicep-curl", 10, 75, "bicep", "bicep curl omschrijving", "https://www.pinclipart.com/picdir/middle/413-4137921_biceps-drawing-mans-arm-dumbbell-curl-png-clipart.png");
        oefeningen.add(o3);
        Oefening o4 = new Oefening("rope-pulldown", 10, 25, "tricep", "omschrijving", "https://s3.amazonaws.com/prod.skimble/assets/770049/image_iphone.jpg");
        oefeningen.add(o4);
        Oefening o5 = new Oefening("incline-bench", 10, 105, "bovenkant-borst", "omschrijving", "https://static.gymhero.me/everkinetics/incline_shoulder_press_dumbbell-small-frame_1.png");
        oefeningen.add(o5);
        Oefening o6 = new Oefening("lat-pulldown", 10, 139, "rug", "omschrijving", "https://cdn-xi3mbccdkztvoept8hl.netdna-ssl.com/wp-content/uploads/watermarked/Wide-Grip_Lat_Pulldown_F_WorkoutLabs.png");
        oefeningen.add(o6);
        Oefening o7 = new Oefening("squad", 30, 32, "bovenbeen", "omschrijving", "https://upload.wikimedia.org/wikipedia/commons/8/82/Squats.svg");
        oefeningen.add(o7);
        Oefening o8 = new Oefening("calf-raises", 20, 202, "kuiten", "omschrijving", "https://i.pinimg.com/originals/3a/f0/b1/3af0b10574c1bf1ead4ad67b6654e430.png");
        oefeningen.add(o8);

        borstLijst.add(o2);
        borstLijst.add(o5);
        borstLijst.add(o1);

        rugLijst.add(o6);

        bicepLijst.add(o3);

        tricepLijst.add(o4);


        favorietenLijst.add(o1);

        //extra
        oefeningen.add(new Oefening("calf-raises", 20, 202, "kuiten", "omschrijving", "https://i.pinimg.com/originals/3a/f0/b1/3af0b10574c1bf1ead4ad67b6654e430.png"));
        oefeningen.add(new Oefening("calf-raises", 20, 202, "kuiten", "omschrijving", "https://i.pinimg.com/originals/3a/f0/b1/3af0b10574c1bf1ead4ad67b6654e430.png"));
        oefeningen.add(new Oefening("calf-raises", 20, 202, "kuiten", "omschrijving", "https://i.pinimg.com/originals/3a/f0/b1/3af0b10574c1bf1ead4ad67b6654e430.png"));
        oefeningen.add(new Oefening("calf-raises", 20, 202, "kuiten", "omschrijving", "https://i.pinimg.com/originals/3a/f0/b1/3af0b10574c1bf1ead4ad67b6654e430.png"));
        oefeningen.add(new Oefening("calf-raises", 20, 202, "kuiten", "omschrijving", "https://i.pinimg.com/originals/3a/f0/b1/3af0b10574c1bf1ead4ad67b6654e430.png"));
        oefeningen.add(new Oefening("calf-raises", 20, 202, "kuiten", "omschrijving", "https://i.pinimg.com/originals/3a/f0/b1/3af0b10574c1bf1ead4ad67b6654e430.png"));
        oefeningen.add(new Oefening("calf-raises", 20, 202, "kuiten", "omschrijving", "https://i.pinimg.com/originals/3a/f0/b1/3af0b10574c1bf1ead4ad67b6654e430.png"));
        oefeningen.add(new Oefening("calf-raises", 20, 202, "kuiten", "omschrijving", "https://i.pinimg.com/originals/3a/f0/b1/3af0b10574c1bf1ead4ad67b6654e430.png"));

//tips maken:
        Tips t1 = new Tips("tipnaam1", "Wake up with a cup of coffee before your morning workout.", "The caffeine in a pre-workout cup of joe helps stimulate your central nervous system, so you’ll have a little extra oomph in your indoor cycling or boot camp class. Plus, in " +
                "addition to a performance boost, research shows that it can actually make exercise feel more enjoyable, so you’re more likely to push harder.\n" +
                "\n" +
                "Drink up a half hour before you start sweating to give it time to kick in, Jessica Cording, R.D., tells SELF.", "auteur1");
        Tips t2 = new Tips("tipnaam2", "ondewerp2", "tekstvandetip2", "auteur2");
        Tips t3 = new Tips("tipnaam3", "ondewerp3", "tekstvandetip3", "auteur3");
        tipsTricks.add(t1);
        tipsTricks.add(t2);
        tipsTricks.add(t3);

//mening maken:
        blogArtikelen.add(new Mening("Artikel 1", "informatie die niet boeit", "SEO Company BrightEdge unveiled new research findings on the performance of Organic and " + "Paid Search as a marketing channel. The strength of search marketing  Organic Search and Paid Search - " + "is clear. Organic Search remains the dominant source of trackable web traffic and in the dominant position as a channel." + " Paid Search continues to grow. Organic Social Media is flat since 2014at 5 %, and though ubiquitous, contributes on average" + " 1 / 3as much traffic as Paid Search and just 1 / 11as much as Organic Search. Read the report to find out why the Organic " + "Channel grew and what this means for your business. " + "Download the full report to see how organic channel share has continued to dominate year afteryear."));
        blogArtikelen.add(new Mening("Artikel 2", "dit is iets anders man", "SEO Company BrightEdge unveiled new research findings on the performance of Organic and " + "Paid Search as a marketing channel. The strength of search marketing  Organic Search and Paid Search - " + "is clear. Organic Search remains the dominant source of trackable web traffic and in the dominant position as a channel." + " Paid Search continues to grow. Organic Social Media is flat since 2014at 5 %, and though ubiquitous, contributes on average" + " 1 / 3as much traffic as Paid Search and just 1 / 11as much as Organic Search. Read the report to find out why the Organic " + "Channel grew and what this means for your business. " + "Download the full report to see how organic channel share has continued to dominate year afteryear."));


    }

}
