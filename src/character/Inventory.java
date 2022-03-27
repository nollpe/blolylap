package character;

import equipment.Bag;
import tester.testerClass;

public class Inventory
{
    private int aminoAcid;
    private int nucleotide;
    private int maxResource;
    private Bag contents;

    public Inventory(int max)
    {
        testerClass.print();
        aminoAcid=0;
        nucleotide=0;
        maxResource=max;
    }

    public int addNucleotide(int added)
    {
        testerClass.print();
        if(aminoAcid+nucleotide+added<=maxResource)
        {
            nucleotide+=added;
            return added;
        }
        else
        {
            int actuallyAdded=maxResource-aminoAcid-nucleotide;
            nucleotide+=actuallyAdded;
            return actuallyAdded;
        }
    }

    public void addContents(Bag e) {
        testerClass.print();
        contents = e;
    }

    public int addAminoAcid(int added)
    {
        testerClass.print();
        if(aminoAcid+nucleotide+added<=maxResource)
        {
            aminoAcid+=added;
            return added;
        }
        else
        {
            int actuallyAdded=maxResource-aminoAcid-nucleotide;
            aminoAcid+=actuallyAdded;
            return actuallyAdded;
        }
    }

    public int takeAminoAcid(int take)
    {
        testerClass.print();
        if(take<=aminoAcid)
        {
            aminoAcid-=take;
            return take;
        }
        else
        {
            int temp=aminoAcid;
            aminoAcid=0;
            return temp;
        }
    }

    public int takeNucleotide(int take)
    {
        testerClass.print();
        if(take<=nucleotide)
        {
            nucleotide-=take;
            return take;
        }
        else
        {
            int temp=nucleotide;
            nucleotide=0;
            return temp;
        }
    }

    public int getNukleotide() {
        return nucleotide;
    }

    public int getAminoAcid() {
        return aminoAcid;
    }
}
