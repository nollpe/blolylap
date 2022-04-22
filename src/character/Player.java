package character;

import agents.Agent;
import agents.GeneticCode;
import cast.Cast;
import cast.CastNormal;
import equipment.Equipment;
import field.Direction;
import field.Field;
import field.Warehouse;
import game.Game;
import getCastOn.GetCastOn;
import getCastOn.GetCastOnNormal;
import getLootTakenFrom.GetLootTakenFrom;
import getLootTakenFrom.LootTakenNormal;
import loot.Loot;
import loot.LootNormal;
import movement.*;
import tester.testerClass;

import java.io.BufferedReader;
import java.util.LinkedList;

public class Player {
    //region variables
    private LinkedList<Agent> activeAgents;
    private LinkedList<Agent> castableAgents;
    private LinkedList<Equipment> equipments;
    private Inventory inventory;
    private Movement movement;
    private Cast cast;
    private GetCastOn getCastOn;
    private GetLootTakenFrom getLootTakenFrom;
    private Loot loot;
    private LinkedList<GeneticCode> knownGeneticCodes;
    private Game game;
    private Field location;
    private String Name;

    //endregion
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public Player() {
        activeAgents = new LinkedList<Agent>();
        castableAgents = new LinkedList<Agent>();
        inventory = new Inventory(10);
        equipments = new LinkedList<Equipment>();
        movement = new MovementNormal(this);
        cast = new CastNormal(this);
        getCastOn = new GetCastOnNormal(this);
        getLootTakenFrom = new LootTakenNormal(this);
        loot = new LootNormal(this);
        knownGeneticCodes = new LinkedList<GeneticCode>();
        game = Game.getInstance();
        //location=game.spawnPlayer(this);
    }

    public Player(String name)
    {
        this();
        Name=name;
    }

    //region strategy pattern setter getter

    public Loot getLoot() {
        testerClass.print();
        return loot;
    }

    public GetLootTakenFrom getGetLootTakenFrom() {
        testerClass.print();
        return getLootTakenFrom;
    }

    public GetCastOn getGetCastOn() {
        testerClass.print();
        return getCastOn;
    }

    public Cast getCase() {
        testerClass.print();
        return cast;
    }

    public Movement getMovement() {
        testerClass.print();
        return movement;
    }

    public void setGetLootTakenFrom(GetLootTakenFrom g) {
        testerClass.print();
        getLootTakenFrom = g;
    }

    public void setGetCastOn(GetCastOn g) {
        testerClass.print();
        getCastOn = g;
    }

    public void setLoot(Loot l) {
        testerClass.print();
        loot = l;
    }

    public void setMovement(Movement m) {
        testerClass.print();
        movement = m;
    }

    public void setCast(Cast c) {
        testerClass.print();
        cast = c;
    }
    //endregion

    //region spellcasting
    public void castSpell() {
        testerClass.print();
        cast.cast(this);
    }

    public void getCastOn(Agent a, Player c) {
        testerClass.print();
        getCastOn.getCastOn(a, c);
    }
    //endregion

    //region sima getter setterek

    public String getName()
    {
        return Name;
    }

    //endregion

    //region vezerles, player kore
    public void vezerles_playerTurn(BufferedReader br)
    {
        /*
        TODO: input majd annak kezelése (nem neked todo zsolt)
         (boolok arra hogy mit csinált már?)

         */

    }
    //endregion

    public void tick() {
        testerClass.print();
        for (Agent agent : activeAgents) {
            agent.tick();
            if (agent.getTimeToLive() == 0) {
                agent.loseEffect(this);
            }
        }
        for (Agent agent : castableAgents) {
            agent.tick();
            if (agent.getTimeToLive() == 0) {
                agent.loseEffect(this);
            }
        }
    }

    //region lootolnak tole

    /**
     * A játékostól elvesznek egy védőfelszerelést, ezért törli mgaáról a hatását és kitörli az felszerelései közül.
     *
     * @param e A védőfelszerelést amit elvettek.
     * @return Az elvétel sikeressége.
     */
    public boolean takeLoot(Equipment e) {
        testerClass.print();
        e.loseEffect(this);
        equipments.remove(e);
        return true;
    }


    /**
     * A karaktertől lootolni akarnak. Meghívja a lootolás eszenvedéséért felelős osztályt.
     *
     * @param e A védőfelszerelést amit el akarnak venni.
     * @return Az elvétel sikeressége.
     */
    public boolean getLootTakenFrom(Equipment e) {
        testerClass.print();
        boolean succes = getLootTakenFrom.getEquipmentTakenFrom(e);
        return succes;
    }

    /**
     * A karakter lootolni akar. Meghívja a lootolásért felelős osztályt.
     */
    public void loot() {

        testerClass.print();
        loot.loot(this);

    }

    /**
     * Eltávolít egy védőfelszerelést
     *
     * @param e Eltávolítandó védőfelszerelés
     * @return Sikeres volt-e
     */
    public boolean removeLoot(Equipment e) {
        testerClass.print();
        return false;
    }

    /**
     * Elvesz valamennyi nukleotidot a karaktertől
     *
     * @param d1 - hányat akarunk elvenni
     * @return - hányat tudtunk elvenni
     */
    public int takeNukleotide(int d1) {
        testerClass.print();
        Warehouse wh = (Warehouse) location;
        int d2 = wh.getStored().takeNucleotide(d1);
        int d3 = inventory.addNucleotide(d2);
        return d3;

    }

    /**
     * Elveszünk amino acidot
     *
     * @param d1 ennyit akarunk elvenni
     * @return ennyit tudunk elvenni
     */
    public int takeAminoAcid(int d1) {
        testerClass.print();
        Warehouse wh = (Warehouse) location;
        int d2 = wh.getStored().takeAminoAcid(d1);
        int d3 = inventory.addAminoAcid(d2);
        testerClass.print();
        return d3;
    }

    /**
     * Megmutatja milyen equipmentjei vannak a playernek
     *
     * @return Védőfelszerelések listája
     */
    public LinkedList<Equipment> showLoot() {
        testerClass.print();
        return equipments;
    }
    //endregion

    /**
     * Hozzáadunk egy GeneticCode-ot
     *
     * @param gc GeneticCode
     */
    public void addGeneticCode(GeneticCode gc) {
        testerClass.print();
        knownGeneticCodes.add(gc);
    }


    /**
     * Elmozdítja a játékost a megadott mezőre
     *
     * @param field a megadott égtáj
     */
    public void move(Field field) {
        testerClass.print();
        getMovement().move(field);
    }

    //region adderek removerek

    /**
     * Hozzáadunk egy védőfelszerelést
     *
     * @param eq védőfelszerelés
     */
    public void addEquipment(Equipment eq) {
        testerClass.print();
        equipments.add(eq);
        eq.takeEffect(this);
    }

    /**
     * ActiveAgent hozzáadása
     *
     * @param agent új aktív agent
     */
    public void addActiveAgent(Agent agent) {
        activeAgents.add(agent);
    }

    /**
     * AkticeAgent eltávolítása
     *
     * @param agent eltávolítandó aktív agent
     */
    public void removeActiveAgent(Agent agent) {
        activeAgents.remove(agent);
    }

    /**
     * Minden genetikus kódot elfelejtett a játékossal
     */
    public void forgetAllGeneticCodes() {
        knownGeneticCodes = new LinkedList<GeneticCode>();
    }

    /**
     * Megadja, hogy melyik mezőn áll a játékos
     *
     * @return A mező
     */
    public Field getLocation() {
        testerClass.print();
        return location;
    }

    /**
     * Beállítja a játékosban, hogy melyik mezőn áll
     *
     * @param f A mező
     */
    public void setLocation(Field f) {
        testerClass.print();
        location = f;
    }

    /**
     * Megadja, hogy milyen védőfelszerelések vannak a karakternél.
     *
     * @return A védőfelszerlések listája.
     */
    public LinkedList<Equipment> getStored() {
        testerClass.print();
        return equipments;
    }

    /**
     * Beállítja a karakterhez tartozó inventoryt.
     *
     * @param i A karakterhez tartozó inventory.
     */
    public void setInventory(Inventory i) {
        testerClass.print();
        inventory = i;
    }

    /**
     * Megadja karakterhez tartozó inventoryt.
     *
     * @returni A karakterhez tartozó inventory.
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Megmutatja milyen kenhető ágenseink vannak
     *
     * @return kenhető ágensek listája
     */
    public LinkedList<Agent> getCastableAgents() {
        return castableAgents;
    }

    /**
     * Kenhető ágens hozzáadása
     *
     * @param castableAgent kenhető ágens
     */
    public void addCastableAgent(Agent castableAgent) {
        testerClass.print();
        castableAgents.add(castableAgent);
        //castableAgent.takeEffect(this);
    }

    public void makeAgent(GeneticCode geneticCode) {
        geneticCode.makeAgent(this.inventory);
    }

    //endregion
}
