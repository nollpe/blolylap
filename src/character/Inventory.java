package character;

import tester.testerClass;

public class Inventory
{
    private int aminoAcid;
    private int nucleotide;
    private int maxResource;

    public Inventory(int max)
    {
        aminoAcid=0;
        nucleotide=0;
        maxResource=max;
    }

    public int addNucleotide(int added)
    {
        testerClass.print();
        return added;
    }

    public int addAminoAcid(int added)
    {
        testerClass.print();
        return added;
    }

    public int takeAminoAcid(int take)
    {
        testerClass.print();
        return take;
    }

    public int takeNucleotide(int take)
    {
        testerClass.print();
        return take;
    }
}
