package tester;

import agents.*;
import cast.CastImpared;
import character.Inventory;
import character.Player;
import equipment.Bag;
import equipment.Equipment;
import equipment.Gloves;
import equipment.Labcoat;
import field.*;
import game.Game;
import game.Timer;
import getCastOn.GetCastOnInvulnerable;
import getLootTakenFrom.LootTakenStunned;
import graphics.GraphicsConstroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class testerClass {

    public testerClass() {

    }

    public static void print() {
        String className = new Exception().getStackTrace()[1].getClassName();
        String methodName1 = new Exception().getStackTrace()[1].getMethodName();
        int depth1 = new Exception().getStackTrace().length;
        String filler = "\t".repeat(depth1 - 3);

        //System.out.println(filler + className + " " + methodName1);
    }

    //region norbi tesztek

    /**
     * A viewCity testcase megvalósítása
     */
    public void viewCity() {
        City c = new City();
        c.showCity();
    }

    /**
     * A startGame testCase megvalósítása
     */
    public void startGame() {
        Game game = Game.getInstance();
        City city = new City();
        city.generateMap();
        game.setCity(city);
    }

    /**
     * az endTurn testCase megvalósítása
     */
    public void endTurn() {
        Timer timer = Timer.getInstance();
        Game game = Game.getInstance();
        City city = new City();
        city.generateMap();
        game.setCity(city);
        Player player = new Player();
        game.spawnPlayer(player);

        Agent chorea = new Chorea(player);
        Agent forget = new Forget(player);
        Agent invulnerable = new Invulnerable(player);
        Agent paralyzing = new Paralyzing(player);
        player.addCastableAgent(chorea);
        player.addCastableAgent(forget);
        player.addCastableAgent(invulnerable);
        player.addCastableAgent(paralyzing);

        timer.tick();
    }

    /**
     * Az agentExires megvalósítja bármely ágens lejárását mind felkent és felkenhető állapotban
     */
    public void agentExpires() {
        //region változó deklarációk
        Timer timer = Timer.getInstance();
        Game game = Game.getInstance();
        City city = new City();
        Field field = new Field();
        Player player = new Player();
        Agent agent = null;

        timer.setGame();
        LinkedList<Field> map = new LinkedList<Field>();
        map.add(field);
        city.setMap(map);
        game.setCity(city);
        field.enter(player);

        //endregion

        int chosen = 0;
        while (agent == null) {
            System.out.println("melyik agens?\n1:Invulnerable\n2:Chorea\n3:Paralyzing\n4:Forget\n0:kilép");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                chosen = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //mAgAS sZInTű nYElv
            //chosen=getchar();
            switch (chosen) {
                case (1):
                    agent = new Invulnerable(player);
                    break;
                case (2):
                    agent = new Invulnerable(player);
                    break;
                case (3):
                    agent = new Chorea(player);
                    break;
                case (4):
                    agent = new Forget(player);
                    break;
                case (0):
                    return;
                default:
                    break;
            }
        }
        agent.setTimeToLive(1);
        System.out.println("felkenhető(1) vagy felkent(2) ágens legyen?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            chosen = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (chosen) {
            case (2):
                player.addActiveAgent(agent);
                break;
            case (1):
                player.addCastableAgent(agent);
        }
        timer.tick();

    }

    //endregion

    //region szushi tesztek
    /**
     * Karakterek a teszteléshez
     */
    static Player character1;
    static Player character2;
    static Player character3;
    static Player character4;
    static Player character5;
    static Game game;
    Invulnerable invulnerable;
    Forget forget;
    Chorea chorea;
    Paralyzing paralyzing;


    /**
     * A virológusok közötti interakciókat teszteli
     */
    private void interactWithOtherVirologist() {
        /**
         * Megkérdezi a felhasználót, hogy melyik esetet szeretné tesztelni.
         * Addig kéri a bemenetet újra, amíg értelmes választ nem kap.
         */
        int n = 0;
        boolean valid = false;
        while (!valid) {
            System.out.println("Kérlek válassz egy tesztesetet: \n1-Lootolás karaktertől\n2-Varázslás");
            Scanner input = new Scanner(System.in);
            n = Integer.parseInt(input.nextLine());
            /**
             * Ellenőrzi, hogy értelmes választ adott-e a felhasználó
             */
            if (n > 0 && n < 3) valid = true;
        }

        /**
         * A felhasználó által választott tesztet futtatja.
         */
        switch (n) {
            case 1:
                lootFromCharacterInit();
                lootFromCharacterTest();
                break;
            case 2:
                castAgentInit();
                castAgentTest();
                break;
            default:
                System.out.println("Ilyen  teszteset nincs");
        }
    }

    /**
     * Inicializálás lootoláshoz tartozó tesztekhez.
     * Létrehozza és inicializálja a teszteléshez szükséges példányokat.
     */
    private void lootFromCharacterInit() {
        /**
         * létrehozása a játékot és a várost  illetve összekapcsolja őket.
         */
        Game game = Game.getInstance();
        City city = new City();
        game.setCity(city);
        city.generateMap();

        /**
         * A karaktereket létrehozza és egy mezőre helyezi őket, hogy tudjanak interaktálni.
         * Azért van 3 karakter, hogy mind a sikeres, mind a sikertelen lootolási kísérleteket tesztelni tudjuk.
         */
        character1 = new Player();
        character2 = new Player();
        character3 = new Player();
        Field field = new Field();
        field.enter(character1);
        field.enter(character2);
        field.enter(character3);
        character1.setLocation(field);
        character2.setLocation(field);
        character3.setLocation(field);

        /**
         * Létrehozza a védőfelszereléseket és a karakterekhez rendeleli
         * Két karakterhez is hozzáadja őket, hogy a lebénult és a nem lebénult eseteket is telsztelni lehessen.
         */
        Gloves gloves = new Gloves();
        Bag bag = new Bag();
        Labcoat labcoat = new Labcoat();
        character2.addEquipment(gloves);
        character2.addEquipment(labcoat);
        character2.addEquipment(bag);
        character3.addEquipment(gloves);
        character3.addEquipment(labcoat);
        character3.addEquipment(bag);

        /**
         * Létrehozza az intentorykat és hozzárendeli a karakterekhez
         */
        Inventory inventory1 = new Inventory(10);
        Inventory inventory2 = new Inventory(10);
        Inventory inventory3 = new Inventory(10);
        character1.setInventory(inventory1);
        character2.setInventory(inventory2);
        character3.setInventory(inventory3);

        /**
         * Feltölti az intentorykat nukleotiddal és aminosavval
         */
        inventory2.addAminoAcid(5);
        inventory2.addNucleotide(5);
        inventory3.addAminoAcid(5);
        inventory3.addNucleotide(5);

        /**
         * A második karaktert megbénítja
         * Ehhez a lottolás és a lootolás elszenvedésének strategy patternjét is beállítja.
         */
        character2.setGetLootTakenFrom(new LootTakenStunned(character2));
        //character2.setLoot(new LootImpared());
    }

    /**
     * Inicializálás ágens keneséhez tartozó tesztesetekhez
     * Létrehozza és inicializálja a teszteléshez szükséges példányokat.
     */
    private void castAgentInit() {
        /**
         * létrehozása a játékot és a várost  illetve összekapcsolja őket.
         */
        Game game = Game.getInstance();
        City city = new City();
        game.setCity(city);
        city.generateMap();

        /**
         * A karaktereket létrehozza és egy mezőre helyezi őket, hogy tudjanak interaktálni.
         * Azért van 3 karakter, hogy mind a sikeres, mind a sikertelen lootolási kísérleteket tesztelni tudjuk.
         */
        character1 = new Player();
        character2 = new Player();
        character3 = new Player();
        character4 = new Player();
        character5 = new Player();
        Field field = new Field();
        field.enter(character1);
        field.enter(character2);
        field.enter(character3);
        field.enter(character4);
        field.enter(character5);
        character1.setLocation(field);
        character2.setLocation(field);
        character3.setLocation(field);
        character4.setLocation(field);
        character5.setLocation(field);

        /**
         * Létrehozza a védőfelszereléseket és a karakterekhez rendeleli
         * Két karakterhez is hozzáadja őket, hogy a lebénult és a nem lebénult eseteket is telsztelni lehessen.
         */
        Gloves gloves = new Gloves();
        Labcoat labcoat = new Labcoat();
        character2.addEquipment(gloves);
        character3.addEquipment(labcoat);


        /**
         * A negyedik karaktert megbénítja
         * Ehhez a lottolás és a lootolás elszenvedésének strategy patternjét is beállítja.
         */
        character4.setCast(new CastImpared(character4));

        invulnerable = new Invulnerable(character1);
        forget = new Forget(character1);
        chorea = new Chorea(character1);
        paralyzing = new Paralyzing(character1);
        character1.addCastableAgent(invulnerable);
        character1.addCastableAgent(forget);
        character1.addCastableAgent(chorea);
        character1.addCastableAgent(paralyzing);

        /**
         * Sebezhetetlenné teszi az 5. játékost
         */
        character5.setGetCastOn(new GetCastOnInvulnerable(character5));
    }

    /**
     * A karaktertől való lootolás tesztje
     */
    private void lootFromCharacterTest() {
        /**
         * Megkérdezi a felhasználótol, hogy lebénult vagy nem lebénult karakterrel szeretne tesztelni.
         * A lebénult karatker tud lootolni, a nem lebénult nem.
         * Addig kéri a bemenetet újra, amíg értelmes választ nem kap.
         */
        int n = 1;
        boolean valid = false;
        while (!valid) {
            System.out.println("Milyen karakterrel szeretnél lootolni?: \n1-Nem lebénult\n2-Lebénult");
            Scanner input = new Scanner(System.in);
            n = Integer.parseInt(input.nextLine());
            if (n > 0 && n < 3) valid = true;
        }
        /**
         * A felhasználó által választott tesztet futtatja.
         * Első: nem lebénult.
         * Második: lebénult.
         */
        switch (n) {
            case 1:
                //character1.loot();
                break;
            case 2:
                //character2.loot();
                break;
            default:
                System.out.println("Ilyen nincsen. ");
        }
    }

    /**
     * Az ágens kenés tesztje
     */
    private void castAgentTest() {
        /**
         * Megkérdezi a felhasználótol, hogy lebénult vagy nem lebénult karakterrel szeretne ágenst kenni.
         * A lebénult karatker tud lootolni, a nem lebénult nem.
         * Addig kéri a bemenetet újra, amíg értelmes választ nem kap.
         */
        int n = 0;
        boolean valid = false;
        while (!valid) {
            System.out.println("Milyen karakterrel szeretnél castolni?: \n1-Nem lebénult\n2-Lebénult");
            Scanner input = new Scanner(System.in);
            n = Integer.parseInt(input.nextLine());
            if (n > 0 && n < 3) valid = true;
        }
        /**
         * A felhasználó által választott tesztet futtatja.
         * Első: nem lebénult.
         * Második: lebénult.
         */
        switch (n) {
            case 1:
                //character1.cast();
                break;
            case 2:
                //character4.cast();
                break;
            default:
                System.out.println("Ilyen nincsen. ");
        }
    }
    //endregion

    //region Tarnay testcase

    /**
     * A TakeNukleotideFromWarehouse TestCase inicializálása és lefutása
     * A játékos felvesz valamennyi nukleotide-ot egy raktárból.
     * Forgatókönyv
     * A játékos felvesz annyi nukleotid-ot, amennyit képes/akar egy raktárból.
     */
    private void Test_TakeNukleotideFromWarehouse() {
        //init
        Player c = new Player();
        Warehouse location = new Warehouse();
        Inventory inventory = new Inventory(10);
        c.setInventory(inventory);
        c.setLocation(location);
        location.enter(c);
        location.getStored().addNucleotide(2);
        //test
        c.takeNucleotide(1);
    }

    /**
     * A TakeAminoacidFromWarehouse TestCase inicializálása és lefutása
     * A játékos felvesz valamennyi aminoacid-ot egy raktárból.
     * Forgatókönyv
     * A játékos felvesz annyi aminoacid-ot, ammenyit képes/akar egy raktárból.
     */
    private void Test_TakeAminoacidFromWarehouse() {
        //init
        Player c = new Player();
        Warehouse location = new Warehouse();
        Inventory inventory = new Inventory(10);
        c.setInventory(inventory);
        c.setLocation(location);
        location.enter(c);
        location.getStored().addAminoAcid(2);
        //test
        c.takeAminoAcid(1);
    }

    /**
     * A ViewLootOfWarehouse TestCase inicializálása és lefutása
     * A játékos megtekinti a raktár tartalmát.
     * Forgatókönyv
     * A játékos megtekinti a raktár tartalmát.
     */
    private void Test_ViewLootOfWarehouse() {
        //init
        Warehouse location = new Warehouse();
        Inventory inventory = new Inventory(10);
        location.setStored(inventory);
        //test
        location.showLoot();
    }

    /**
     * A ViewGeneticCodeOfLaboratory TestCase inicializálása és lefutása
     * A játékos megtekinti a laboratórium tartalmazott genetikus kódját.
     * Forgatókönyv
     * A játékos megtekinti a laboratórium tartalmazott genetikus kódját.
     */
    private void Test_ViewGeneticCodeOfLaboratory() {
        //init
        Laboratory location = new Laboratory();
        //location.init(new GeneticCode(new Forget(), 1, 1));
        //test
        location.showLoot();
    }

    /**
     * A LearnGeneticCodeOfLaboratory TestCase inicializálása és lefutása
     * A játékos megtanulja a laboratórium genetikus kódját.
     * Forgatókönyv
     * A játékos megtanulja a laboratórium genetikus kódját.
     */
    private void Test_LearnGeneticCodeOfLaboratory() {
        //init
        Player c = new Player();
        Laboratory location = new Laboratory();
        GeneticCode readableGeneticCode = new GeneticCode();
        location.init(readableGeneticCode);
        location.enter(c);
        //test
        //c.message1
        GeneticCode gc = location.readGeneticCode();
        c.addGeneticCode(gc);
    }

    /**
     * A ViewLootOfSafehouse TestCase inicializálása és lefutása
     * A játékos megtekinti a óvóhelyen lévő védőfelszerelést.
     * Forgatókönyv
     * A játékos megtekinti a óvóhelyen lévő védőfelszerelést.
     */
    private void Test_ViewLootOfSafehouse() {
        //init
        Safehouse location = new Safehouse();
        //test
        location.showLoot();
    }

    /**
     * A TakeBagFromSafehouse TestCase inicializálása és lefutása
     * A játékos felvesz egy zsákot óvóhelyről
     * Forgatókönyv
     * A játékos felvesz egy zsákot
     * A játékos inventoryjába beépül a zsák
     */
    private void Test_TakeBagFromSafehouse() {
        //init
        Player c = new Player();
        Bag stored = new Bag();
        Safehouse location = new Safehouse();
        Inventory inventory = new Inventory(10);
        c.setInventory(inventory);
        c.setLocation(location);
        location.enter(c);
        location.setStored(stored);
        //test
        Equipment eq = ((Safehouse) location).getStored();
        c.removeLoot(eq);
    }

    /**
     * A TakeLabcoatFromSafehouse TestCase inicializálása és lefutása
     * A játékos felvesz egy köpenyt óvóhelyről
     * Forgatókönyv
     * A játékos felvesz egy köpenyt óvóhelyről
     * A játékos GetCastOnContoller strategy patternje megváltozik, GetCastOnResistant-ra
     */
    private void Test_TakeLabcoatFromSafehouse() {
        //init
        Player c = new Player();
        Labcoat stored = new Labcoat();
        Safehouse location = new Safehouse();
        c.setLocation(location);
        location.enter(c);
        location.setStored(stored);
        //test
        Equipment eq = ((Safehouse) location).getStored();
        c.removeLoot(eq);

    }

    /**
     * A TakeGlovesFromSafehouse TestCase inicializálása és lefutása
     * A játékos felvesz egy pár kesztyűt óvóhelyről
     * Forgatókönyv:
     * A játékos felvesz egy pár kesztyűt óvóhelyről
     * A játékos GetCastOnContoller strategy patternje megváltozik, GetCastOnGloves-ra
     */
    private void Test_TakeGlovesFromSafehouse() {
        //init
        Player c = new Player();
        Gloves stored = new Gloves();
        Safehouse location = new Safehouse();
        c.setLocation(location);
        location.enter(c);
        location.setStored(stored);
        //test
        Equipment eq = ((Safehouse) location).getStored();
        c.removeLoot(eq);
    }
    //endregion

    //region Zsolti tesztesetei

    /**
     * A játékos mozgását teszteli, ha a játékoson nincsen semmilyen mozgást befolyásoló hatás
     */
/*    public void normalCharacterMoves() {
        //inicializálunk
        Player player = new Player();
        MovementNormal movementNormal = new MovementNormal(player);
        player.setMovement(movementNormal);
        Field field1 = new Field();
        player.setLocation(field1);

        boolean valid = false;
        int n = 0;
        Field field2;

        //megkérdezzük, milyen mezőre szeretnénk lépni
        while (!valid) {
            System.out.println("1: Empty Field, 2: Laboratory, 3: Warehouse, 4: Safehouse");
            Scanner input = new Scanner(System.in);
            n = Integer.parseInt(input.nextLine());
            if (n > 0 && n < 5) valid = true;
        }

        switch (n) {
            case 2:
                field2 = new Laboratory();
                break;
            case 3:
                field2 = new Warehouse();
                break;
            case 4:
                field2 = new Safehouse();
                break;
            default:
                field2 = new Field();
                break;

        }

        field1.addNeighbour(field2, Direction.NORTH);
        field2.addNeighbour(field1, Direction.SOUTH);

        //elmozdítjuk a játékost
        player.move(Direction.NORTH);
    }
*/
    /**
     * A játékos mozgását teszteli, ha a játékos vírustánc alatt áll
     */
/*    public void choreaCharacterMoves() {
        //inicializálunk
        Player player = new Player();
        MovementChorea movementChorea = new MovementChorea(player);
        player.setMovement(movementChorea);
        Field field1 = new Field();
        player.setLocation(field1);

        //a mezőnek minden irányba rakunk szomszédot, hogy bármelyikbe lépést lehessen tesztelni
        Safehouse field2 = new Safehouse();
        field1.addNeighbour(field2, Direction.NORTH);
        field2.addNeighbour(field1, Direction.SOUTH);

        Warehouse field3 = new Warehouse();
        field1.addNeighbour(field3, Direction.EAST);
        field3.addNeighbour(field1, Direction.WEST);

        Laboratory field4 = new Laboratory();
        field1.addNeighbour(field4, Direction.WEST);
        field4.addNeighbour(field1, Direction.EAST);

        Field field5 = new Field();
        field1.addNeighbour(field5, Direction.SOUTH);
        field5.addNeighbour(field1, Direction.NORTH);

        //elmozdítjuk a játékost
        player.move(Direction.NORTH);
    }
*/
    /**
     * A játékos mozgását teszteli, ha a játékos le van bénulva
     */
/*    public void paralyzedCharacterMoves() {
        //inicializálunk
        Player player = new Player();
        MovementParalyzed movementParalyzed = new MovementParalyzed(player);
        player.setMovement(movementParalyzed);

        Field field1 = new Field();
        player.setLocation(field1);

        //elmozdítjuk a játékost
        player.move(Direction.NORTH);
    }
*/

    /**
     * Az ágens létrehozását teszteli
     */
    public void createAgent() {
        //inicializálunk
        Player player = new Player();
        Agent agent;

        boolean valid = false;
        int n = 0;

        //megkérdezzük, hogy milyen ágenst szeretnénk létrehozni
        while (!valid) {
            System.out.println("1: Chorea, 2: Forget, 3: Invulnerable, 4: Paralyzing");
            Scanner input = new Scanner(System.in);
            n = Integer.parseInt(input.nextLine());
            if (n > 0 && n < 5) valid = true;
        }

        switch (n) {
            case 2:
                agent = new Forget(player);
                break;
            case 3:
                agent = new Invulnerable(player);
                break;
            case 4:
                agent = new Paralyzing(player);
                break;
            default:
                agent = new Chorea(player);
                break;
        }


        GeneticCode geneticCode = new GeneticCode(agent, 5, 5);
        player.getInventory().addAminoAcid(5);
        player.getInventory().addNucleotide(5);

        //létrehozzuk az ágenst
        player.makeAgent(geneticCode);
    }

    //endregion

    /**
     * Main függvény
     * Innen vezéreljük a konzolon kersztüli tesztelést
     *
     * @param args bemeneti argumentumok (nem használt)
     */
    public static void main(String[] args) {
        Game C = Game.getInstance();
        C.startGame();

        /*
        testerClass ts = new testerClass();
        boolean quit = false;
        while (!quit) {
            System.out.println("Melyik teszteset?: " +
                    "\n0-Kilép" +
                    "\n1-viewCity" +
                    "\n2-startGame" +
                    "\n3-endTurn" +
                    "\n4-agentExpires" +
                    "\n5-interactWithOtherVirologist" +
                    "\n6-lootFromCharacterTest" +
                    "\n7-castAgentTest" +
                    "\n8-Test_takeNukleotideFromWarehouse" +
                    "\n9-Test_TakeAminoacidFromWarehouse" +
                    "\n10-Test_ViewLootOfWarehouse" +
                    "\n11-Test_ViewGeneticCodeOfLaboratory" +
                    "\n12-Test_LearnGeneticCodeOfLaboratory" +
                    "\n13-Test_ViewLootOfSafehouse" +
                    "\n14-Test_TakeBagFromSafehouse" +
                    "\n15-Test_TakeLabcoatFromSafehouse" +
                    "\n16-Test_TakeGlovesFromSafehouse" +
                    "\n17-normalCharacterMoves" +
                    "\n18-choreaCharacterMoves" +
                    "\n19-paralyzedCharacterMoves" +
                    "\n20-createAgent"
            );
            Scanner input = new Scanner(System.in);
            int n = Integer.parseInt(input.nextLine());
            switch (n) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    ts.viewCity();
                    break;
                case 2:
                    ts.startGame();
                    break;
                case 3:
                    ts.endTurn();
                    break;
                case 4:
                    ts.agentExpires();
                    break;
                case 5:
                    ts.interactWithOtherVirologist();
                    break;
                case 6:
                    ts.lootFromCharacterInit();
                    ts.lootFromCharacterTest();
                    break;
                case 7:
                    ts.castAgentInit();
                    ts.castAgentTest();
                    break;
                case 8:
                    ts.Test_TakeNukleotideFromWarehouse();
                    break;
                case 9:
                    ts.Test_TakeAminoacidFromWarehouse();
                    break;
                case 10:
                    ts.Test_ViewLootOfWarehouse();
                    break;
                case 11:
                    ts.Test_ViewGeneticCodeOfLaboratory();
                    break;
                case 12:
                    ts.Test_LearnGeneticCodeOfLaboratory();
                    break;
                case 13:
                    ts.Test_ViewLootOfSafehouse();
                case 14:
                    ts.Test_TakeBagFromSafehouse();
                    break;
                case 15:
                    ts.Test_TakeLabcoatFromSafehouse();
                    break;
                case 16:
                    ts.Test_TakeGlovesFromSafehouse();
                    break;
                case 17:
                    ts.normalCharacterMoves();
                    break;
                case 18:
                    ts.choreaCharacterMoves();
                    break;
                case 19:
                    ts.paralyzedCharacterMoves();
                    break;
                case 20:
                    ts.createAgent();
                    break;
            }

        }*/
    }
}