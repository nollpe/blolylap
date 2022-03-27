package tester;

import agents.*;
import character.Inventory;
import character.Player;
import equipment.Bag;
import equipment.Equipment;
import equipment.Gloves;
import equipment.Labcoat;
import field.*;
import game.Game;
import game.Timer;
import getLootTakenFrom.LootTakenStunned;
import movement.MovementChorea;
import movement.MovementNormal;
import movement.MovementParalyzed;

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

        System.out.println(filler + className + " " + methodName1);
    }

    //region norbi tesztek
    public void viewCity() {
        City c = new City();
        c.showCity();
    }

    public void startGame() {
        Game game = Game.getInstance();
        City city = new City();
        city.generateMap();
        game.setCity(city);
    }

    public void endTurn() {
        Timer timer = Timer.getInstance();
        Game game = Game.getInstance();
        City city = new City();
        city.generateMap();
        game.setCity(city);
        Player player = new Player();
        game.spawnPlayer(player);

        Agent chorea = new Chorea();
        Agent forget = new Forget();
        Agent invulnerable = new Invulnerable();
        Agent paralyzing = new Paralyzing();
        player.addCastableAgent(chorea);
        player.addCastableAgent(forget);
        player.addCastableAgent(invulnerable);
        player.addCastableAgent(paralyzing);

        timer.tick();
    }

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
                    agent = new Invulnerable();
                    break;
                case (2):
                    agent = new Invulnerable();
                    break;
                case (3):
                    agent = new Chorea();
                    break;
                case (4):
                    agent = new Forget();
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

    //region szusi tesztek
    static Player character1;
    static Player character2;
    static Player character3;

    private void lootEquipment() {
        System.out.println("Válassz gec: \n1-Védőfelszerelést ellopása karaktertől\n2-idk");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        switch (s) {
            case "1":
                TestInit1();
                Test1();
                break;
            case "2":
                TestInit1();
                Test2();
                break;
            default:
                System.out.println("Ilyen nincs is fogykos");
        }
    }

    private void TestInit1() {
        Game game = Game.getInstance();
        City city = new City();
        game.setCity(city);
        city.generateMap();

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


        Gloves gloves = new Gloves();
        Bag bag = new Bag();
        Labcoat labcoat = new Labcoat();

        character2.addEquipment(gloves);
        character2.addEquipment(labcoat);
        character2.addEquipment(bag);

        LootTakenStunned lts = new LootTakenStunned();
        character2.setGetLootTakenFrom(lts);

    }
    //endregion

    //region Tarnay testcase
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
        c.takeNukleotide(1);
    }

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

    private void Test_ViewLootOfWarehouse() {
        //init
        Warehouse location = new Warehouse();
        Inventory inventory = new Inventory(10);
        location.setStored(inventory);
        //test
        location.showLoot();
    }

    private void TestInit_ViewGeneticCodeOfLaboratory() {
        //init
        Laboratory location = new Laboratory();
        location.init(new GeneticCode(new Forget(), 1, 1));
        //test
        location.showLoot();
    }

    private void TestInit_LearnGeneticCodeOfLaboratory() {
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

    private void TestInit_ViewLootOfSafehouse() {
        //init
        Safehouse location = new Safehouse();
        //test
        location.showLoot();
    }

    private void TestInit_TakeBagFromSafehouse() {
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
        c.takeLoot(eq);
    }

    private void TestInit_TakeLabcoatFromSafehouse() {
        //init
        Player c = new Player();
        Labcoat stored = new Labcoat();
        Safehouse location = new Safehouse();
        c.setLocation(location);
        location.enter(c);
        location.setStored(stored);
        //test
        Equipment eq = ((Safehouse) location).getStored();
        c.takeLoot(eq);

    }

    private void TestInit_TakeGlovesFromSafehouse() {
        //init
        Player c = new Player();
        Gloves stored = new Gloves();
        Safehouse location = new Safehouse();
        c.setLocation(location);
        location.enter(c);
        location.setStored(stored);
        //test
        Equipment eq = ((Safehouse) location).getStored();
        c.takeLoot(eq);
    }
    //endregion

    //region Zsolti tesztesetei

    public void normalCharacterMoves() {
        Player player = new Player();
        MovementNormal movementNormal = new MovementNormal();
        player.setMovement(movementNormal);
        Field field1 = new Field();
        player.setLocation(field1);

        boolean valid = false;
        int n = 0;
        Field field2;

        while (!valid) {
            System.out.println("1: Empty Field, 2: Laboratory, 3: Warehouse, 4: Safehouse");
            Scanner input = new Scanner(System.in);
            n = Integer.parseInt(input.nextLine());
            if (n > 0 && n < 5) valid = true;
        }

        switch (n) {
            case 2 -> {
                field2 = new Laboratory();
            }
            case 3 -> {
                field2 = new Warehouse();
            }
            case 4 -> {
                field2 = new Safehouse();
            }
            default -> {
                field2 = new Field();
            }
        }

        field1.addNeighbour(field2, Direction.NORTH);
        field2.addNeighbour(field1, Direction.SOUTH);

        player.move(Direction.NORTH);
    }

    public void choreaCharacterMoves() {
        Player player = new Player();
        MovementChorea movementChorea = new MovementChorea();
        player.setMovement(movementChorea);
        Field field1 = new Field();
        player.setLocation(field1);

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

        player.move(Direction.NORTH);
    }

    public void paralyzedCharacterMoves() {
        Player player = new Player();
        MovementParalyzed movementParalyzed = new MovementParalyzed();
        player.setMovement(movementParalyzed);

        Field field1 = new Field();
        player.setLocation(field1);

        player.move(Direction.NORTH);
    }

    //endregion

    private void Test1() {

        character1.loot();
    }

    private void Test2() {
        character1.loot();
    }
    //endregion

    public static void main(String[] args) {
        testerClass ts = new testerClass();
        ts.agentExpires();
        ts.viewCity();
        ts.startGame();
        ts.endTurn();
    }
}
