package character;

import agents.Agent;
import agents.GeneticCode;
import equipment.Equipment;
import field.Field;
import game.Game;
import movement.*;

public class Character
{
    private Agent activeAgent;
    private Agent castableAgent;
    private Inventory inventory;
    private Equipment[] equipments;
    private Movement movement;
    private GeneticCode knownGeneticCodes;
    private Game game;
    private Field location;


    public void move(/*fielnek kéne itt lennie nem?*/)
    {

    }

    public void castSpell(Character c,Agent a)
    {

    }

    public void getCastOn(Agent a,Character c)
    {

    }

    public void tick()
    {

    }

    public boolean takeLoot(Equipment e)
    {
        return false;
    }

    public void getLootTakenFrom()
    {

    }

    public boolean removeLoot(Equipment e)
    {
        return false;
    }

    public int takeNukleotide(int i)
    {
        return 0;
    }

    public int takeAminoAcid(int i)
    {
        return 0;
    }

    public void addGeneticCode(GeneticCode gc)
    {

    }

    public Equipment[] showLoot()
    {
        return equipments;
    }

    public void loot()
    {
        /*?????*/
    }
}
