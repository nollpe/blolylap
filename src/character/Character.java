package character;

import agents.Agent;
import agents.GeneticCode;
import equipment.Equipment;
import field.Field;
import game.Game;
import movement.*;
import tester.testerClass;

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
        testerClass.print();
    }

    public void castSpell(Character c,Agent a)
    {
        testerClass.print();
    }

    public void getCastOn(Agent a,Character c)
    {
        testerClass.print();
    }

    public void tick()
    {
        testerClass.print();
    }

    public boolean takeLoot(Equipment e)
    {
        return false;
    }

    public void getLootTakenFrom()
    {
        testerClass.print();
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
        /*?????*/testerClass.print();
    }
}
