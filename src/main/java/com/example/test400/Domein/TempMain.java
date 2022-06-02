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


        IngredientenRecept i1  = new IngredientenRecept("bloemkool", 400);
        IngredientenRecept i2 = new IngredientenRecept("aardappelen", 300);
        IngredientenRecept i3 = new IngredientenRecept("slavink", 200);

        ArrayList <IngredientenRecept> ingredientenRecepts = new ArrayList<>();
        ingredientenRecepts.add(i1);
        ingredientenRecepts.add(i2);
        ingredientenRecepts.add(i3);

        Recept r1 = new Recept("overschotel", 400, 400, 300,ingredientenRecepts);

//een nieuw supplement aanmaken:
        ArrayList <IngredientenSupplement> alleIngredientenBijElkaarMeegevenAanHetSupplement = new ArrayList<>();
        alleIngredientenBijElkaarMeegevenAanHetSupplement.add(new IngredientenSupplement("creatineIngredient1", 200));
        alleIngredientenBijElkaarMeegevenAanHetSupplement.add(new IngredientenSupplement("creatineIngredient2", 400));
        alleIngredientenBijElkaarMeegevenAanHetSupplement.add(new IngredientenSupplement("creatineIngredient3", 100));

        Supplement s1 = new Supplement("creatine", 300, 33, 66, alleIngredientenBijElkaarMeegevenAanHetSupplement);


//een nieuwe oefening maken:
        Oefening o1 = new Oefening("bankdrukken", 10, 300, "borst");


//tips maken:
        Tips t1 = new Tips("tipnaam", "ondewerp", "tekstvandetip", "auteur");


//mening maken:
        Mening m1 = new Mening("naam", "onderwerp", "tekst");
        Blog b1 = new Blog(m1);

//uitprinten:
        System.out.println("de ingredienten zijn " + s1.getIngredientenSupplement());
        System.out.println("de ingredienten zijn " + r1.getIngredienten());
        System.out.println(o1.getNaam());
        System.out.println(b1.getMening().getNaam());

    }
}
