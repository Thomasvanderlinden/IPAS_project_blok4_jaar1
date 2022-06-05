package com.example.test400.Domein;

import com.example.test400.Domein.blog.Blog;
import com.example.test400.Domein.blog.Mening;
import com.example.test400.Domein.recept.IngredientenRecept;
import com.example.test400.Domein.recept.Recept;
import com.example.test400.Domein.supplement.IngredientenSupplement;
import com.example.test400.Domein.supplement.Supplement;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

public class TempMain {
    public static void main(String[] args) {

//een nieuw recept aanmaken:


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

        //supplement 2
        ArrayList<IngredientenSupplement> ingredientenWHEY = new ArrayList<>();
        ingredientenWHEY.add(new IngredientenSupplement("weiproteineconcentraat(milk)", 200));
        ingredientenWHEY.add(new IngredientenSupplement("smaakstoffen", 10));
        ingredientenWHEY.add(new IngredientenSupplement("verdikkingsmiddel", 100));
        ingredientenWHEY.add(new IngredientenSupplement("zonnebloem lecthine", 70));
        ingredientenWHEY.add(new IngredientenSupplement("zoetstof", 20));
        Supplement s2 = new Supplement("Eiwitpoeder (Whey)", 380, 30, 39, ingredientenWHEY);

//een nieuwe oefening maken:
        Oefening o1 = new Oefening("bankdrukken", 10, 300, "borst");
        Oefening o2 = new Oefening("fly's", 15, 300, "borst");
        Oefening o3 = new Oefening("bicep-curl", 10, 75, "bicep");
        Oefening o4 = new Oefening("rope-pulldown", 10, 25, "tricep");


//tips maken:
        Tips t1 = new Tips("tipnaam", "ondewerp", "tekstvandetip", "auteur");


//mening maken:
        Mening m1 = new Mening("naam", "onderwerp", "tekst");
        Blog b1 = new Blog(m1);

//uitprinten:
        System.out.println("de ingredienten zijn " + s1.getIngredientenSupplement());
        System.out.println("de ingredienten zijn " + R1.getIngredienten());
        System.out.println(o1.getNaam());
        System.out.println(b1.getMening().getNaam());

    }
}
