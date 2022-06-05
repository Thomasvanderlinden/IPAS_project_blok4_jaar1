package com.example.test400.app;

import com.example.test400.Domein.Oefening;
import com.example.test400.Domein.Tips;
import com.example.test400.Domein.blog.Blog;
import com.example.test400.Domein.blog.Mening;
import com.example.test400.Domein.recept.IngredientenRecept;
import com.example.test400.Domein.recept.Recept;
import com.example.test400.Domein.supplement.IngredientenSupplement;
import com.example.test400.Domein.supplement.Supplement;

import javax.security.auth.message.config.ServerAuthContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.swing.*;
import java.net.ServerSocket;
import java.rmi.server.ServerCloneException;
import java.util.ArrayList;

@WebListener
public class StartupListener implements ServletContextListener {

    public static ArrayList<Oefening> oefeningen = new ArrayList<>();
    public static ArrayList<Supplement> supplementen = new ArrayList<>();


    public void contextInitialized(ServletContextEvent sce){
        //recept 1
        ArrayList<IngredientenRecept> ingredientenPO = new ArrayList<>();
        ingredientenPO.add(new IngredientenRecept("volkoren penne pasta", 300));
        ingredientenPO.add(new IngredientenRecept("rundergehakt", 500));
        ingredientenPO.add(new IngredientenRecept("tomatenpuree", 70));
        ingredientenPO.add(new IngredientenRecept("gepelde tomaten", 800));
        ingredientenPO.add(new IngredientenRecept("besciamella", 400));
        ingredientenPO.add(new IngredientenRecept("broccoli", 750));
        Recept R1 = new Recept("Pasta-ovenschotel met broccoli",892, 62, 50, 46, ingredientenPO);

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
        Recept R2 = new Recept("Pasta-ovenschotel met broccoli",892, 62, 50, 46, ingredientenOGCG);


//een nieuw supplement aanmaken:

        //supplement 1
        ArrayList <IngredientenSupplement> ingredientenCREA = new ArrayList<>();
        ingredientenCREA.add(new IngredientenSupplement("creatine Monohydraat", 500));
        Supplement s1 = new Supplement("creatine", 300, 33, 66, ingredientenCREA);
        supplementen.add(s1);
        //supplement 2
        ArrayList<IngredientenSupplement> ingredientenWHEY = new ArrayList<>();
        ingredientenCREA.add(new IngredientenSupplement("weiproteineconcentraat(milk)", 200));
        ingredientenCREA.add(new IngredientenSupplement("smaakstoffen", 10));
        ingredientenCREA.add(new IngredientenSupplement("verdikkingsmiddel", 100));
        ingredientenCREA.add(new IngredientenSupplement("zonnebloem lecthine", 70));
        ingredientenCREA.add(new IngredientenSupplement("zoetstof", 20));
        Supplement s2 = new Supplement("Eiwitpoeder (Whey)", 380, 30, 39, ingredientenWHEY);
        supplementen.add(s2);

//een nieuwe oefening maken:
        Oefening o1 = new Oefening("bankdrukken", 10, 300, "borst");
        oefeningen.add(o1);
        Oefening o2 = new Oefening("fly's", 15, 300, "borst");
        oefeningen.add(o2);
        Oefening o3 = new Oefening("bicep-curl", 10, 75, "bicep");
        oefeningen.add(o3);
        Oefening o4 = new Oefening("rope-pulldown", 10, 25, "tricep");
        oefeningen.add(o4);

//tips maken:
        Tips t1 = new Tips("tipnaam", "ondewerp", "tekstvandetip", "auteur");


//mening maken:
        Mening m1 = new Mening("naam", "onderwerp", "tekst");
        Blog b1 = new Blog(m1);


    }

}
