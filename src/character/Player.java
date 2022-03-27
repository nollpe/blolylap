package character;

import agents.Agent;
import agents.GeneticCode;
import cast.Cast;
import cast.CastNormal;
import equipment.Equipment;
import field.Direction;
import field.Field;
import field.Safehouse;
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

    //endregion
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public Player() {
        activeAgents = new LinkedList<Agent>();
        castableAgents = new LinkedList<Agent>();
        inventory = new Inventory(10);
        equipments = new LinkedList<Equipment>();
        movement = new MovementNormal();
        cast = new CastNormal();
        getCastOn = new GetCastOnNormal();
        getLootTakenFrom = new LootTakenNormal();
        loot = new LootNormal();
        knownGeneticCodes = new LinkedList<GeneticCode>();
        game = Game.getInstance();
        //location=game.spawnPlayer(this);
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
    public void castSpell(Player Caster, Agent agent) {
        testerClass.print();
        Caster.getCastOn(agent, this);
    }

    public void getCastOn(Agent a, Player c) {
        testerClass.print();
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

    //region lootolás

    /**
     * @param e ezt a felszerelést szeretné felvenni a játékos
     * @return sikerült-e neki
     */
    public boolean takeLoot(Equipment e) {
        testerClass.print();
        ((Safehouse) location).takeEquipment(e);
        e.takeEffect(this);
        return false;
    }

    /**
     * A játékostól el akarnak venni egy felszerelést
     *
     * @param e az elvenni kívánt felszerelés
     * @return sikerült-e elvenni tőle
     */
    public boolean getLootTakenFrom(Equipment e) {
        testerClass.print();
        boolean succes = getLootTakenFrom.getEquipmentTakenFrom(e, this);
        return succes;
    }

    public void loot() {
        testerClass.print();
        loot.loot(this);

    }

    /**
     * A játékos megpróbál levenni egy felszerelést
     *
     * @param e ezt a felszerelés próbálja meg levenni
     * @return visszaadja, hogy sikerült-e
     */
    public boolean removeLoot(Equipment e) {
        testerClass.print();
        return false;
    }

    /**
     * A játékos nukleotidot vesz fel egy raktárból
     *
     * @param d1 ennyit nukleotidot tevez elvenni
     * @return mennyit tudott elvenni
     */
    public int takeNukleotide(int d1) {
        testerClass.print();
        Warehouse wh = (Warehouse) location;
        int d2 = wh.getStored().takeNucleotide(d1);
        int d3 = inventory.addNucleotide(d2);
        return d3;
    }

    /**
     * A játékos aminosavat vesz fel egy raktárból
     *
     * @param d1 ennyit aminosavat tevez elvenni
     * @return mennyit tudott elvenni
     */
    public int takeAminoAcid(int d1) {
        testerClass.print();
        Warehouse wh = (Warehouse) location;
        int d2 = wh.getStored().takeAminoAcid(d1);
        int d3 = inventory.addAminoAcid(d2);
        testerClass.print();
        return d3;
    }

    public LinkedList<Equipment> showLoot() {
        testerClass.print();
        return equipments;
    }
    //endregion

    public void addGeneticCode(GeneticCode gc) {
        testerClass.print();
        knownGeneticCodes.add(gc);
    }

    public void addCastableAgent(Agent agent) {
        castableAgents.add(agent);
    }

    public void addEquipment(Equipment eq) {
        testerClass.print();
        equipments.add(eq);
    }

    public void move(Direction dir) {
        testerClass.print();
        getMovement().move(dir, this);
    }

    //region adderek removerek
    public void addActiveAgent(Agent agent) {
        activeAgents.add(agent);
    }

    public void removeActiveAgent(Agent agent) {
        activeAgents.remove(agent);
    }

    public void forgetAllGeneticCodes() {
        knownGeneticCodes = new LinkedList<GeneticCode>();
    }

    public Field getLocation() {
        testerClass.print();
        return location;
    }

    public void setLocation(Field f) {
        testerClass.print();
        location = f;
    }

    public Inventory getInventory() {
        testerClass.print();
        return inventory;
    }

    public void setInventory(Inventory i) {
        testerClass.print();
        inventory = i;
    }

    public LinkedList<Equipment> getStored() {
        testerClass.print();
        return equipments;
    }

    public Agent makeAgent(GeneticCode gc) {
        testerClass.print();
        return gc.makeAgent(inventory);
    }
    //endregion
}
