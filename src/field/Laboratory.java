package field;
import agents.GeneticCode;
import tester.testerClass;

public class Laboratory extends Field
{
    private GeneticCode readableGeneticCode;

    public Laboratory()
    {
        super();
        testerClass.print();
    }

    public void showLoot()
    {
        testerClass.print();
    }

    public void tick()
    {
        super.tick();
        testerClass.print();

    }

    public void takeLoot()
    {
        testerClass.print();
    }

    public GeneticCode readGeneticCode()
    {
        testerClass.print();
        GeneticCode gc = readableGeneticCode.clone();
        return readableGeneticCode;
    }

    public void init(GeneticCode gc)
    {
        readableGeneticCode = gc;
        testerClass.print();
    }
}
