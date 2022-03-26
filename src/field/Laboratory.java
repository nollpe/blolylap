package field;
import agents.GeneticCode;
import tester.testerClass;

public class Laboratory extends Field
{
    private GeneticCode readableGeneticCode;

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

    public GeneticCode readGeneticCode()
    {
        testerClass.print();
        return readableGeneticCode;
    }

    public void init(GeneticCode gc)
    {
        testerClass.print();
    }
}
