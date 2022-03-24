package equipment;
import character.Inventory;

import equipment.Equipment;

public class Bag extends Equipment
{
    private Inventory inventory;

    public void takeEffect(Character c)
    {

    }

    public void loseEffect(Character c)
    {

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