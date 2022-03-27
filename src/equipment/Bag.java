package equipment;
import character.Inventory;

import character.Player;
import equipment.Equipment;
import getCastOn.GetCastOnNormal;
import tester.testerClass;

/**
 * A táska védőfelszerelés osztálya.
 * Hatására több dolog lehet a játékosnál.
 */
public class Bag extends Equipment
{
    /**
     * Az inventory, amiben a táskában lévő dolgokat lehet tárolni.
     */
    private Inventory inventory;

    /**
     * A táska megszerzésekor hívodik meg a függvény.
     * @param c A karakter, aki megszerezte a táskát.
     */
    public void takeEffect(Player c)
    {
        testerClass.print();
    }

    /**
     * A táska elvesztésekor hívodik meg.
     * @param c A karakter, aki elveszített a tásktát.
     */
    public void loseEffect(Player c)
    {
        testerClass.print();
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