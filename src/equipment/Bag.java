package equipment;
import character.Inventory;

import character.Player;
import equipment.Equipment;
import getCastOn.GetCastOnNormal;
import tester.testerClass;

public class Bag extends Equipment
{
    private Inventory inventory;

    public void takeEffect(Player c)
    {
        testerClass.print();
    }

    public void loseEffect(Player c)
    {
        testerClass.print();
        GetCastOnNormal gcon = new GetCastOnNormal();
        c.setGetCastOn(gcon);
    }

    public Bag()
    {
        inventory=new Inventory(5);
    }

    public int addNucleotide(int added)
    {
        return added;
    }

    public int addAminoAcid(int added)
    {
        return added;
    }

    public int takeAminoAcid(int take)
    {
        return take;
    }

    public int takeNucleotide(int take)
    {
        return take;
    }
}