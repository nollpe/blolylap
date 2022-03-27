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

    public Loot getLoot()
    {
        testerClass.print();
        return loot;
    }
    public GetLootTakenFrom getGetLootTakenFrom()
    {
        testerClass.print();
        return getLootTakenFrom;
    }

    public GetCastOn getGetCastOn()
    {
        testerClass.print();
        return getCastOn;
    }
    public Cast getCase()
    {
        testerClass.print();
        return cast;
    }
    public Movement getMovement()
    {
        testerClass.print();
        return movement;
    }
    public void setGetLootTakenFrom(GetLootTakenFrom g)
    {
        testerClass.print();
        getLootTakenFrom=g;
    }
    public void setGetCastOn(GetCastOn g)
    {
        testerClass.print();
        getCastOn=g;
    }
    public void setLoot(Loot l)
    {
        testerClass.print();
        loot=l;
    }
    public void setMovement(Movement m)
    {
        testerClass.print();
        movement=m;
    }
    public void setCast(Cast c)
    {
        testerClass.print();
        cast=c;
    }
    //endregion

    //region spellcasting
    public void castSpell(Player Caster, Agent agent)
    {
        testerClass.print();
        Caster.getCastOn(agent,this);
    }

    public void getCastOn(Agent a, Player c)
    {
        testerClass.print();
    }
    //endregion

    public void tick()
    {
        testerClass.print();
        for(Agent agent:activeAgents)
        {
            agent.tick();
        }
    }

    //region lootolnak tole

    /**
     * A játékostól elvesznek egy védőfelszerelést, ezért törli mgaáról a hatását és kitörli az felszerelései közül.
     * @param e A védőfelszerelést amit elvettek.
     * @return Az elvétel sikeressége.
     */
    public boolean takeLoot(Equipment e)
    {
        testerClass.print();
        e.loseEffect(this);
        equipments.remove(e);
        return true;
    }


    /**
     * A karaktertől lootolni akarnak. Meghívja a lootolás eszenvedéséért felelős osztályt.
     * @param e A védőfelszerelést amit el akarnak venni.
     * @return Az elvétel sikeressége.
     */
    public boolean getLootTakenFrom(Equipment e)
    {
        testerClass.print();
        boolean succes = getLootTakenFrom.getEquipmentTakenFrom(e, this);
        return succes;
    }

    /**
     * A karakter lootolni akar. Meghívja a lootolásért felelős osztályt. 
     */
    public void loot()
    {
        testerClass.print();
        loot.loot(this);

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
    public LinkedList<Equipment> showLoot()
    {
        testerClass.print();
        return equipments;
    }
    //endregion

    public void addGeneticCode(GeneticCode gc)
    {
        testerClass.print();
        knownGeneticCodes.add(gc);
    }

    public void addEquipment(Equipment eq)
    {
        testerClass.print();
        equipments.add(eq);
    }

    public void move(/*fielnek kéne itt lennie nem?*/)
    {
        testerClass.print();
    }

    //region adderek removerek
    public void addActiveAgent(Agent agent)
    {
        activeAgents.add(agent);
    }

    public void removeActiveAgent(Agent agent)
    {
        activeAgents.remove(agent);
    }

    public void forgetAllGeneticCodes()
    {
        knownGeneticCodes=new LinkedList<GeneticCode>();
    }

    /**
     * Megadja, hogy melyik mezőn áll a játékos
     * @return A mező
     */
    public Field getLocation(){
        testerClass.print();
        return location;
    }

    /**
     * Beállítja a játékosban, hogy melyik mezőn áll
     * @param f A mező
     */
    public void setLocation(Field f){
        testerClass.print();
        location = f;
    }

    /**
     * Megadja, hogy milyen védőfelszerelések vannak a karakternél.
     * @return A védőfelszerlések listája.
     */
    public LinkedList<Equipment> getStored(){
        testerClass.print();
        return equipments;
    }
    //endregion
}
