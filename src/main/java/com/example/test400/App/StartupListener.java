package com.example.test400.App;

import com.example.test400.App.Persistence.PersistenceManager;
import com.example.test400.Domein.Favoriet;
import com.example.test400.Domein.Oefening;
import com.example.test400.Domein.Tips.Tips;
import com.example.test400.Domein.Blog.Mening;
import com.example.test400.Domein.Recept.IngredientenRecept;
import com.example.test400.Domein.Recept.Recept;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.HttpResources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.Duration;
import java.util.ArrayList;

@WebListener
public class StartupListener implements ServletContextListener {

    public static ArrayList<Oefening> oefeningen = new ArrayList<>();
    public static ArrayList<Mening> blogArtikelen = new ArrayList<>();
    public static ArrayList<Recept> recepten = new ArrayList<>();
    public static ArrayList<Tips> tipsTricks = new ArrayList<>();

    public static ArrayList<Oefening> favorietenLijst = new ArrayList<>();

    public static ArrayList<Oefening> borstLijst = new ArrayList<>();
    public static ArrayList<Oefening> rugLijst = new ArrayList<>();
    public static ArrayList<Oefening> bicepLijst = new ArrayList<>();
    public static ArrayList<Oefening> tricepLijst = new ArrayList<>();


    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextListener - Initialized");
        //recept 1
        ArrayList<IngredientenRecept> ingredientenPO = new ArrayList<>();
        ingredientenPO.add(new IngredientenRecept("volkoren penne pasta", "300 gram"));
        ingredientenPO.add(new IngredientenRecept("rundergehakt", "500 gram"));
        ingredientenPO.add(new IngredientenRecept("tomatenpuree", "70 gram"));
        ingredientenPO.add(new IngredientenRecept("gepelde tomaten", "800 gram"));
        ingredientenPO.add(new IngredientenRecept("besciamella", "400 gram"));
        ingredientenPO.add(new IngredientenRecept("broccoli", "750 gram"));
        Recept r1 = new Recept("Pasta-ovenschotel met broccoli", 892, 62, 50, 46, ingredientenPO, "Verwarm de oven voor op 180˚C.\n" +
                "Kook de fusilli pasta volgens de aanwijzingen op de verpakking, giet af en zet apart.\n" +
                "Bak het gehakt in een koekenpan rul tot bruin en gaar. Voeg de voorgekookte broccoliroosjes en de doperwten hieraan toe en bak deze even mee. Voeg alle kruiden toe en roer goed door.\n" +
                "Voeg nu de bloem toe en bak deze ook even mee. Giet de slagroom erbij en roer tot het iets indikt.\n" +
                "Meng de groente met de pasta en doe het geheel over in een ovenschaal.\n" +
                "Bestrooi ruim met de geraspte kaas en zet het voor ongeveer 20-30 minuten in de oven of tot de kaas gesmolten is, en het geheel goudbruin.", "Een heerlijke pastaschotel uit de oven met lekker veel groente in de vorm van broccoli, doperwtjes en een romige saus.", "https://miljuschka.nl/wp-content/uploads/2021/02/Pasta-ovenschotel-met-broccoli-2.jpg");
        //recept 2
        ArrayList<IngredientenRecept> ingredientenOGCG = new ArrayList<>();
        ingredientenOGCG.add(new IngredientenRecept("kruidenpasta", "70 gram"));
        ingredientenOGCG.add(new IngredientenRecept("paprika", "1"));
        ingredientenOGCG.add(new IngredientenRecept("sperziebonen", "400 gram"));
        ingredientenOGCG.add(new IngredientenRecept("eieren", "8"));
        ingredientenOGCG.add(new IngredientenRecept("cherrytomaten", "250 gram"));
        ingredientenOGCG.add(new IngredientenRecept("bosui", "2"));
        ingredientenOGCG.add(new IngredientenRecept("rode ui", "1"));
        ingredientenOGCG.add(new IngredientenRecept("stokbrood", "1"));
        Recept r2 = new Recept("Spaanse curry", 892, 62, 50, 46, ingredientenOGCG, "bereidingswijze", "Deze Thaise rode currypasta is echt heet! Als je deze currypasta gaat maken kun je voor de hoeveelheid pepers het beste uitgaan van wat je normaal verdraag", "https://gewoonhanne.nl/wp-content/uploads/2019/06/P5180370.jpg");

        recepten.add(r1);
        recepten.add(r2);

        try{
            PersistenceManager.loadFromAzure();
        }catch (Exception e){
            System.out.println("Error laden van de data!");
            e.printStackTrace();
        }


        Oefening o1 = new Oefening("bankdrukken", 10, 300, "borst", "De bench press, ‘bankdrukken’, is een van de populairste oefeningen bij krachttraining. Het is tevens één van de drie oefeningen van het powerliften (naast de squat en deadlift). Het is een compound oefening die verschillende grote spiergroepen inzet. De borstspieren en voorkant van de schouderspieren worden ingezet om de bovenarm naar voren en binnen te trekken. De triceps worden ingezet om de armen te strekken. Spieren in de schouders, rug en onderrug werken mee om je lichaam te stabiliseren.", "https://upload.wikimedia.org/wikipedia/commons/8/86/Incline-bench-press-1.png");
        oefeningen.add(o1);
        //todo: er zit ergens iets fout bij de fly
        Oefening o2 = new Oefening("fly's", 15, 300, "borst", "fly omschrijving", "https://i.pinimg.com/474x/89/d4/92/89d492813187786c6e293d2c4b1a99e1--chest-routine-kylie-jenner.jpg");
        oefeningen.add(o2);
        Oefening o3 = new Oefening("bicep-curl", 10, 75, "bicep", "Dumbbell curls is een oefening die vaak door krachtsporters zoals bij bodybuilding, powerlifting, krachttraining, fitness en andere sporten wordt gebruikt ter versterking of vergroting van vooral de biceps (musculus biceps brachii). Deze spiergroep wordt in de volksmond ook wel 'spierbal' of 'spierballen' genoemd. De Engelse term dumbbell curls wordt veelvuldig en wereldwijd gebruikt in de krachtsportwereld. Het woord curls betekent in het Engels: krullen. De oefening is een soort krullende beweging waardoor deze term is ontstaan. De oefening wordt ook vaak als \"dumbell curls\" geschreven, met een letter minder.", "https://www.pinclipart.com/picdir/middle/413-4137921_biceps-drawing-mans-arm-dumbbell-curl-png-clipart.png");
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

        borstLijst.add(o5);
        borstLijst.add(o1);
        borstLijst.add(o2);

        rugLijst.add(o6);

        bicepLijst.add(o3);

        tricepLijst.add(o4);


        favorietenLijst.add(o1);

        //extra

//tips maken:
        Tips t1 = new Tips("Test Yourself", "Wake up with a cup of coffee before your morning workout.", "The caffeine in a pre-workout " +
                "cup of joe helps stimulate your central nervous system, so you’ll have a little extra oomph in your indoor cycling or boot camp class. Plus, in " +
                "addition to a performance boost, research shows that it can actually make exercise feel more enjoyable, so you’re more likely to push harder.\n" +
                "\n" +
                "Drink up a half hour before you start sweating to give it time to kick in, Jessica Cording, R.D., tells SELF.", "Frans effi");
        Tips t2 = new Tips("Be Proud", "evertything you do effects others around you", "Before diving into the practical gym tips for beginners, remember that the most" +
                " important exercise catalyst is confidence. Whether you're lifting 100 pounds or 1 pound, you should be proud of yourself for showing up at the gym" +
                " at all! Don't be intimidated by others or scared to ask for help.\n" +
                "Remember that everyone at the gym was once in your shoes. Those first few workouts, no matter how \"easy\" they are in terms of physical intensity, " +
                "are often the most mentally challenging. Be proud, remain confident and trust that your gym skills and fitness savvy will increase over time.",
                "Charles arms");
        Tips t3 = new Tips("Work Hard", "Why not right go hard or go home", "If you're not sweating by the end of your workout, perhaps " +
                "you aren't pushing yourself hard enough. Try to reach an \"out of breath\" state at least once during your workout by incorporating high-intensity " +
                "movements like sprinting, jumping jacks, burpees or squat jumps.", "Chez david");
        tipsTricks.add(t1);
        tipsTricks.add(t2);
        tipsTricks.add(t3);

//mening maken:
        blogArtikelen.add(new Mening("Artikel 1", "Wat als alles anders gaat", "SEO Company BrightEdge unveiled new research findings on the performance of Organic and " + "Paid Search as a marketing channel. The strength of search marketing  Organic Search and Paid Search - " + "is clear. Organic Search remains the dominant source of trackable web traffic and in the dominant position as a channel." + " Paid Search continues to grow. Organic Social Media is flat since 2014at 5 %, and though ubiquitous, contributes on average" + " 1 / 3as much traffic as Paid Search and just 1 / 11as much as Organic Search. Read the report to find out why the Organic " + "Channel grew and what this means for your business. " + "Download the full report to see how organic channel share has continued to dominate year afteryear."));
        blogArtikelen.add(new Mening("Artikel 2", "Wat als alles anders gaat", "SEO Company BrightEdge unveiled new research findings on the performance of Organic and " + "Paid Search as a marketing channel. The strength of search marketing  Organic Search and Paid Search - " + "is clear. Organic Search remains the dominant source of trackable web traffic and in the dominant position as a channel." + " Paid Search continues to grow. Organic Social Media is flat since 2014at 5 %, and though ubiquitous, contributes on average" + " 1 / 3as much traffic as Paid Search and just 1 / 11as much as Organic Search. Read the report to find out why the Organic " + "Channel grew and what this means for your business. " + "Download the full report to see how organic channel share has continued to dominate year afteryear."));


    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("ContextListener-Destroyed");
        try{
            PersistenceManager.saveFromAzure();
        }catch (Exception e){
            System.out.println("Error ophalen data!" );
                    e.printStackTrace();
        }

        Schedulers.shutdownNow();
        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO, Duration.ZERO).block();
    }

}
