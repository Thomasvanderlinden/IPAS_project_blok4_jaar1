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
import java.awt.image.AreaAveragingScaleFilter;
import java.time.Duration;
import java.util.ArrayList;

@WebListener
public class StartupListener implements ServletContextListener {

    public static ArrayList<Oefening> oefeningen = new ArrayList<>();
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


        //recept 3:
        ArrayList<IngredientenRecept> ingredientenMB = new ArrayList<>();
        ingredientenMB.add(new IngredientenRecept("tortilla wraps", "8 stuks"));
        ingredientenMB.add(new IngredientenRecept("paprika", "3 stuks"));
        ingredientenMB.add(new IngredientenRecept("kipfilet", "400 gram"));
        ingredientenMB.add(new IngredientenRecept("kidneybonen", "400 gram"));
        ingredientenMB.add(new IngredientenRecept("uien", "3 stuks"));
        ingredientenMB.add(new IngredientenRecept("veldsla", "85 gram"));
        ingredientenMB.add(new IngredientenRecept("fajita seasoningmix", "40 gram"));
        ingredientenMB.add(new IngredientenRecept("tomaten", "4 stuks"));
        ingredientenMB.add(new IngredientenRecept("avocado", "1 stuk"));
        ingredientenMB.add(new IngredientenRecept("mais", "150 gram"));
        Recept r3 = new Recept("mexicaanse Wraps", 758, 90, 48, 23, ingredientenMB, "Stap 1. Snijd de (vega) kip in blokjes. Verhit olie in de pan bak de kip 3 minuten op middelhoog vuur. Snijd ondertussen de uien en paprika’s in kleine blokjes. Snijd de ui net iets fijner dan de paprika. Voeg de ui en de paprika samen met de fajitamix toe aan de kip en bak nog 2 minuten mee tot de kip gaar is.\n" +
                "\n" +
                "Stap 2. Laat ondertussen de bonen uitlekken in een vergiet. Voeg deze toe aan de kip en verwarm nog 2-3 minuten. Snijd ondertussen de tomaten en avocado in blokjes.\n" +
                "\n" +
                "Stap 3. Verwarm de tortillawraps in de magnetron zoals aangegeven op de verpakking.\n" +
                "\n" +
                "Stap 4. Beleg de wraps met de sla en de kipmix. Verdeel daarna de tomaatblokjes, avocado en de mais over de wraps. Rol op en snijd schuin door.", "Waarschijnlijk het bekendste onderdeel op een Mexicaanse menukaart en zó populair en lekker dat vele restaurants dit ene gerecht als verdienmodel hebben. De burrito! Deze eiwitrijke wrap is geschikt als diner, maar maakt ook een heerlijke en vullende lunch.", "https://www.fit.nl/wp-content/uploads/2020/08/xMexicaanse-wraps-recept.jpg.pagespeed.ic.he6NZAg6u_.webp");


        //recept 4:
        ArrayList<IngredientenRecept> ingredientenGZAMPC = new ArrayList<>();
        ingredientenGZAMPC.add(new IngredientenRecept("zoete aardappel", "600 gram"));
        ingredientenGZAMPC.add(new IngredientenRecept("kipfilet", "200 gram"));
        ingredientenGZAMPC.add(new IngredientenRecept("griekse yoghurt", "80 gram"));
        ingredientenGZAMPC.add(new IngredientenRecept("curry mandras kruiden", "1 theelepel"));
        ingredientenGZAMPC.add(new IngredientenRecept("masala", "1 theelepel"));
        ingredientenGZAMPC.add(new IngredientenRecept("tomatenpuree", "1 theelepel"));
        ingredientenGZAMPC.add(new IngredientenRecept("doperwten", "70 gram"));
        Recept r4 = new Recept("Gevulde zoete aardappel met pulled chicken", 346, 47, 26, 6, ingredientenGZAMPC, "Stap 1. Verwarm de oven op 200 graden. \n" +
                "\n" +
                "Stap 2. Spoel de zoete aardappels af onder de kraan. Prik met een vork gaatjes in de zoete aardappel. Leg deze op een ovenrooster bekleed met bakpapier in de voorverwarmde oven. Check na 40 minuten of de aardappels gaar zijn. Je kunt dit checken door met een vork erin te prikken. Is de kern zacht, dan zijn ze klaar. De bereidingstijd verschilt tussen de grootte van de aardappels. \n" +
                "\n" +
                "Stap 3. Ondertussen bereid je de vulling. Maak de marinade voor de kip met 1 tl curry madras, 1 tl garam masala, 1 tl tomatenpuree en 1 el (20 gram) Griekse yoghurt. Meng de marinade, snijd dan de kipfilet in grove repen en smeer in met de marinade.  \n" +
                "\n" +
                "Stap 4. Schroei de kip op middelhoog vuur in 2 minuten aan in een pan met een deksel. Draai het vuur laag en voeg daarna de overige marinade aan de pan toe en een scheut water en doe de deksel op de pan. Na ongeveer 15-20 minuten kun je de kip met twee vorken uit elkaar trekken. Voeg dan de erwtjes toe en laat nog 10 minuten met de deksel op de pan sudderen.  \n" +
                "\n" +
                "Stap 5. Snijd de aardappelen over de lengte open maar niet helemaal doormidden. Open ze en vul met het kipmengsel. Je kunt de aardappelen toppen met 1 el Griekse yoghurt en koriander. ", "Vergeet flauwe Hollandse stamppot – ga voor deze heerlijke gevulde zoete aardappel! De pulled chicken zit voor smaak en eiwitten en brengt het gerecht mooi in balans – alles dat je wil dus.", "https://www.fit.nl/wp-content/uploads/2021/08/xgevulde-zoete-aardappel-recept.jpg.pagespeed.ic.1ipFP_jbE8.webp");


        recepten.add(r1);
        recepten.add(r2);
        recepten.add(r3);
        recepten.add(r4);


        try {
            PersistenceManager.loadFromAzure();
        } catch (Exception e) {
            System.out.println("Error laden van de data!");
            e.printStackTrace();
        }


        Oefening o1 = new Oefening("bankdrukken", 10, 300, "borst", "De bench press, ‘bankdrukken’, is een van de populairste oefeningen bij krachttraining. Het is tevens één" +
                " van de drie oefeningen van het powerliften (naast de squat en deadlift)." +
                " Het is een compound oefening die verschillende grote spiergroepen inzet. De" +
                " borstspieren en voorkant van de schouderspieren worden ingezet om de bovenarm" +
                " naar voren en binnen te trekken. De triceps worden ingezet om de armen te strekken. " +
                "Spieren in de schouders, rug en onderrug werken mee om je lichaam te stabiliseren.", "https://upload.wikimedia.org/wikipedia/commons/8/86/Incline-bench-press-1.png");
        oefeningen.add(o1);
        Oefening o2 = new Oefening("fly s", 15, 300, "borst", "Ga op een fitessbankje liggen en plaats je voeten naast het bankje zodat je stabiel ligt.\n" +
                "Span je buik- en bilspieren aan en adem in.\n" +
                "Breng de gewichten boven je.\n" +
                "Adem in en laat de dumbbells tot de horizontale positie naast je zakken.\n" +
                "Let daarbij erop dat de armen licht gebogen zijn.\n" +
                "Breng de dumbbells weer omhoog en adem uit als de gewichten boven je schouders zijn.\n" +
                "Knijp de borstspier samen als het gewicht zich boven je bevindt. Hierdoor leg je de nadruk op het binnenste deel van de grote borstspier.\n" +
                "Gebruik geen zware gewichten, maar houdt bijvoorbeeld het gewicht op de onderste positie een seconde vast om te zorgen voor extra spierprikkel om de borstspier nog meer te belasten.", "https://i.pinimg.com/474x/89/d4/92/89d492813187786c6e293d2c4b1a99e1--chest-routine-kylie-jenner.jpg");
        oefeningen.add(o2);
        Oefening o3 = new Oefening("bicep-curl", 10, 75, "bicep", "Dumbbell curls is een oefening die vaak door krachtsporters zoals bij bodybuilding, powerlifting," +
                " krachttraining, fitness en andere sporten wordt gebruikt ter versterking of vergroting van vooral de biceps (musculus biceps brachii)." +
                " Deze spiergroep wordt in de volksmond ook wel 'spierbal' of 'spierballen' genoemd. De Engelse term dumbbell curls wordt veelvuldig en " +
                "wereldwijd gebruikt in de krachtsportwereld. Het woord curls betekent in het Engels: krullen. De oefening is een soort krullende beweging " +
                "waardoor deze term is ontstaan. De oefening wordt ook vaak als \"dumbell curls\" geschreven, met een letter minder.", "https://www.pinclipart.com/picdir/middle/413-4137921_biceps-drawing-mans-arm-dumbbell-curl-png-clipart.png");
        oefeningen.add(o3);
        Oefening o4 = new Oefening("rope-pulldown", 10, 25, "tricep", "Stel de pulley in op de hoogste stand en bevestig het touw of de stang aan de pulley.\n" +
                "Pak het touw met overhandse grip vast, dus met je handpalmen naar beneden gericht.\n" +
                "Houd je rug recht en leun iets voorover.\n" +
                "Houd je bovenarmen en ellebogen in je zij en zorg dat je onderarmen parallel aan de vloer zijn.\n" +
                "Span vervolgens je buikspieren en bilspieren aan.\n" +
                "Duw het touw naar beneden tot je allebei je armen gestrekt zijn.\n" +
                "Houd het gewicht even vast en laat je armen daarna langzaam weer omhoog komen tot de beginpositie.\n" +
                "Herhaal deze beweging voor het gewenste aantal reps.", "https://s3.amazonaws.com/prod.skimble/assets/770049/image_iphone.jpg");
        oefeningen.add(o4);
        Oefening o5 = new Oefening("incline-bench", 10, 105, "bovenkant-borst", "Ga op een bankje liggen met een rechte rug.\n" +
                "Pak de stang iets verder dan schouderbreedte vast waarbij je duimen de stang opsluiten.\n" +
                "Adem in, span je buik- en bilspieren aan en laat het gewicht zakken totdat je ellebogen een hoek van 90 graden maken.\n" +
                "Druk het gewicht rustig en gelijkmatig omhoog.", "https://static.gymhero.me/everkinetics/incline_shoulder_press_dumbbell-small-frame_1.png");
        oefeningen.add(o5);
        Oefening o6 = new Oefening("lat-pulldown", 10, 139, "rug", "Ga met je gezicht naar het apparaat zitten met je benen onder het rolkussen.\n" +
                "Pak de stang vast en wijs met je duimen naar binnen en plaats je handen verder dan schouderbreedte.\n" +
                "Adem in en span je buikspieren aan en breng je schouderbladen naar elkaar toe en schouders naar achteren en druk ze naar beneden.\n" +
                "Trek de stang naar het bovenste deel van de borst.\n" +
                "Probeer je schouderbladen tegen elkaar te drukken op het onderste punt.\n" +
                "Laat de stang vervolgens rustig terugzakken en adem uit.", "https://cdn-xi3mbccdkztvoept8hl.netdna-ssl.com/wp-content/uploads/watermarked/Wide-Grip_Lat_Pulldown_F_WorkoutLabs.png");
        oefeningen.add(o6);
        Oefening o7 = new Oefening("squad", 30, 32, "bovenbeen", "Ga rechtop staan met je voeten op schouderbreedte waarbij de voeten ongeveer 30 graden naar buiten wijzen.\n" +
                "Zak door je knieën waarbij je je billen naar recht naar achteren duwt.\n" +
                "Zorg dat je knieën de richting van je voeten volgt en niet voorbij je tenen komen. Dit doe je direct goed door de zakken vanuit je hakken.\n" +
                "Houd tijdens de kniebuiging je buikspieren aangespannen, je rug recht, je kin omhoog, je borst naar voren en je schouders naar achteren. Op deze manier voorkom je een verkeerde houding en overbelasting van je spieren.\n" +
                "Hurk zo diep mogelijk totdat je bovenbenen parallel zijn aan de vloer. Je bovenbeen en onderbeen maken dan een hoek van 90 graden. Ben je nog niet ervaren? Maak dan een minder diepe buiging (zie foto).\n" +
                "Houd je bilspieren aangespannen als je in de gehurkte positie staat, en kom weer recht omhoog alsof je door een touwtje aan je kruin omhoog getrokken wordt.\n" +
                "Herhaal de oefening de 15x in 3 sets. Ben je meer ervaren? Dan kan je diepere en meerdere quats doen of squatten met extra gewicht om de oefening zwaarder te maken.", "https://upload.wikimedia.org/wikipedia/commons/8/82/Squats.svg");
        oefeningen.add(o7);
        Oefening o8 = new Oefening("calf-raises", 20, 202, "kuiten", "Zorg dat je stabiel staat met een lichte spreidstand.\n" +
                "Hou eventueel dumbbells vast in beide handen\n" +
                "Hou een rechte rug, span je core en billen goed aan voordat je uitduwt\n" +
                "Duw jezelf omhoog vanuit de bal van je voet, hou bovenin even vast en laat jezelf weer rustig zakken", "https://i.pinimg.com/originals/3a/f0/b1/3af0b10574c1bf1ead4ad67b6654e430.png");
        oefeningen.add(o8);
        Oefening o9 = new Oefening("pull-up", 10, 85, "rug", "Ga met je gezicht naar de stang staan en probeer aan de stang te hangen met een brede overhandse greep.\n" +
                "Adem in en breng je schouderbladen naar elkaar toe.\n" +
                "Trek het bovenlichaam op tot je kin net boven de stang uitkomt.\n" +
                "Probeer geen verkrampte houding aan te nemen maar trek je ontspannen op.\n" +
                "Adem aan het einde van de beweging boven uit.\n" +
                "Kom met een gecontroleerde beweging terug in de uitgangspositie en herhaal.", "https://physicalculturestudy.com/wp-content/uploads/2019/09/gironda-sternum-chins-1.png");
        oefeningen.add(o9);


        borstLijst.add(o5);
        borstLijst.add(o1);
        borstLijst.add(o2);

        rugLijst.add(o6);

        bicepLijst.add(o3);

        tricepLijst.add(o4);



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


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextListener-Destroyed");
        try {
            PersistenceManager.saveFromAzure();
        } catch (Exception e) {
            System.out.println("Error ophalen data!");
            e.printStackTrace();
        }

        Schedulers.shutdownNow();
        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO, Duration.ZERO).block();
    }

}
