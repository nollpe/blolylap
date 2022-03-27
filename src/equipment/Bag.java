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
        c.addEquipment(this);
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

    /**
     *
     * @param added ennyi nucleotidot akarunk belerakni
     * @return ennyi nukleotidot sikerült belerakni
     */
    public int addNucleotide(int added)
    {
        return inventory.addNucleotide(added);
    }
    /**
     *
     * @param added ennyi aminosavat akarunk belerakni
     * @return ennyi aminosavat sikerült belerakni
     */
    public int addAminoAcid(int added)
    {
        return inventory.addAminoAcid(added);
    }

    /**
     *
     * @param take ennyi amiosavat akarunk kivenni
     * @return ennyi aminosavat sikerült kivenni
     */
    public int takeAminoAcid(int take)
    {
        return inventory.takeAminoAcid(take);
    }

    /**
     *
     * @param take ennyi nukleotidot akarunk kivenni
     * @return ennyi nukleotidot sikerült kivenni
     */
    public int takeNucleotide(int take)
    {
        return inventory.takeNucleotide(take);
    }
}