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
        try {
            PersistenceManager.loadFromAzure();
        } catch (Exception e) {
            System.out.println("Error laden van de data!");
            e.printStackTrace();
        }


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


//oefeningen
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
        Oefening o10 = new Oefening("dead-lift", 10, 55, "rug", "Lichte buiging in de knieën\n" +
                "\n" +
                "Hou je ruggengraat in een rechte lijn gedurende de oefening\n" +
                "\n" +
                "Plaats je handen met schouderbreedte op de stang\n" +
                "\n" +
                "Zorg dat de stang in een rechte lijn omhoog wordt getrokken", "https://img.freepik.com/free-vector/sequence-weightlifter-doing-deadlift-exercise-hand-drawn-vector-illustration_231873-6760.jpg");
        oefeningen.add(o10);
        Oefening o11 = new Oefening("incline-curl", 8, 33, "bicep", "Ga op een trainingsbankje zitten en pak in elke hand een dumbbell. Til vervolgens de dumbbells één voor één met de handpalmen omhoog, naar je schouders toe (dus eerst je ene arm en dan je andere arm). Laat vervolgens de dubbells weer langzaam zakken. Het is belangrijk om je bovenarmen in een rechte lijn naar je toe te halen en niet te laten ‘slingeren’, zodat je de biceps optimaal traint. Met deze oefening train je voornamelijk de lange kop.", "https://static.gymhero.me/everkinetics/prone_incline_biceps_curl_with_dumbbell-small-frame_2.png");
        oefeningen.add(o11);
        Oefening o12 = new Oefening("hammer curl", 10, 43, "bicep", "Pak de dumbbells vast, ga met je voeten op schouderbreedte van elkaar staan en buig je knieën lichtelijk. Zorg dat je handpalmen naar je lichaam toe zijn gericht als je de dumbbells vast hebt. Houd vervolgens je ellebogen dicht bij je lichaam en breng de dumbbell langzaam tot je schouders. Laat volgens de dumbbells weer langzaam zakken. Met deze oefening train je voornamelijk de korte kop.", "https://static.gymhero.me/everkinetics/alternating_hammer_curl_with_dumbbell-small-frame_2.png");
        oefeningen.add(o12);
        Oefening o13 = new Oefening("close press", 12, 87, "tricep", "Plaats je handen met schouderbreedte op de stang en houdt de stang boven compleet recht boven de borst.\n" +
                "\n" +
                "Laat de stang langzaam zakken en zorg dat je ellebogen langs je zij naar beneden bewegen.", "data:image/png;base64,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");
        oefeningen.add(o13);


        borstLijst.add(o5);
        borstLijst.add(o1);
        borstLijst.add(o2);

        rugLijst.add(o6);
        rugLijst.add(o10);
        rugLijst.add(o9);

        bicepLijst.add(o3);
        bicepLijst.add(o11);
        bicepLijst.add(o12);

        tricepLijst.add(o4);
        tricepLijst.add(o13);

//tips
        Tips t1 = new Tips("Test Yourself", "Wake up with a cup of coffee before your morning workout.", "The caffeine in a pre-workout " +
                "cup of joe helps stimulate your central nervous system, so you’ll have a little extra oomph in your indoor cycling or boot camp class. Plus, in " +
                "addition to a performance boost, research shows that it can actually make exercise feel more enjoyable, so you’re more likely to push harder.\n" +
                "\n" +
                "Drink up a half hour before you start sweating to give it time to kick in, Jessica Cording, R.D., tells SELF.", "Frans effi");
        Tips t2 = new Tips("Be Proud", "Evertything you do effects others around you", "Before diving into the practical gym tips for beginners, remember that the most" +
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
