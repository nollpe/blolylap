package character;

import agents.Agent;
import agents.GeneticCode;
import cast.Cast;
import cast.CastNormal;
import equipment.Equipment;
import field.Field;
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

public class Player
{
    private LinkedList<Agent> activeAgents;
    private LinkedList<Agent> castableAgents;
    private Inventory inventory;
    private Equipment[] equipments;
    private Movement movement;
    private Cast cast;
    private GetCastOn getCastOn;
    private GetLootTakenFrom getLootTakenFrom;
    private Loot loot;
    private LinkedList<GeneticCode> knownGeneticCodes;
    private Game game;
    private Field location;

    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public Player()
    {
        activeAgents=new LinkedList<Agent>();
        castableAgents=new LinkedList<Agent>();
        inventory=new Inventory(10);
        equipments=new Equipment[3];
        movement=new MovementNormal();
        cast=new CastNormal();
        getCastOn=new GetCastOnNormal();
        getLootTakenFrom=new LootTakenNormal();
        loot=new LootNormal();
        knownGeneticCodes=new LinkedList<GeneticCode>();
        game=Game.getInstance();
        location=game.spawnPlayer(this);
    }

    public void move(/*fielnek kéne itt lennie nem?*/)
    {
        testerClass.print();
    }

    public void castSpell(Player c, Agent a)
    {
        testerClass.print();
    }

    public void getCastOn(Agent a, Player c)
    {
        testerClass.print();
    }

    public void tick()
    {
        testerClass.print();
        for(Agent agent:activeAgents)
        {
            agent.tick();
        }
    }

    public boolean takeLoot(Equipment e)
    {
        testerClass.print();
        e.loseEffect(this);
        return false;
    }

    public boolean getLootTakenFrom(Equipment e)
    {
        testerClass.print();
        getLootTakenFrom.getEquipmentTakenFrom(e, this);
        return false;
    }

    public boolean removeLoot(Equipment e)
    {
        testerClass.print();return false;
    }

    public int takeNukleotide(int i)
    {
        testerClass.print();return 0;
    }

    public int takeAminoAcid(int i)
    {
        testerClass.print();return 0;
    }

    public void addGeneticCode(GeneticCode gc)
    {
        testerClass.print();
    }

    public Equipment[] showLoot()
    {
        testerClass.print();return equipments;
    }

    public void loot()
    {
        System.out.println("loot");
        testerClass.print();
        loot.loot(this);

    }

    public void addCastableAgent(Agent a){
        testerClass.print();
        castableAgents.add(a);
    }

    public void addEquipment(Equipment e){
        testerClass.print();
        int i = 0;
        while(i < 3 && equipments[i] != null){
            i++;
        }
        if(i<3) equipments[i] = e;
    }

    public Equipment[] getStored(){
        testerClass.print();
        return equipments;
    }

    public Field getLocation(){
        testerClass.print();
        return location;
    }

    public void setLocation(Field f){
        testerClass.print();
        location = f;
    }

    public void setGetCastOn(GetCastOn gco){
        getCastOn = gco;
    }

    /*public Inventory getInventory(){
        return inventory;
    }*/
}
