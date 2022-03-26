package field;
import character.Inventory;
import tester.testerClass;

public class Warehouse extends Field
{
    private Inventory stored;

    public void showLoot()
    {
        testerClass.print();
    }

    public void tick()
    {
        testerClass.print();
    }

    public void takeLoot()
    {
        testerClass.print();
    }

    public int takeNucleotide(int taken)
    {

        testerClass.print();
        return taken;
    }

    public int takeAminoAcid(int taken)
    {
        testerClass.print();
        return taken;
    }
}
