package character;

import equipment.Bag;
import tester.testerClass;

public class Inventory
{
    private int aminoAcid;
    private int nucleotide;
    private int maxResource;

    /**
     *
     * @param max a maximum tárolási kapacitás, összesen ennyi alapanyag fér bele
     */
    public Inventory(int max)
    {
        testerClass.print();
        aminoAcid=0;
        nucleotide=0;
        maxResource=max;
    }

    /**
     *
     * @param added ennyi nucleotidot akarunk belerakni
     * @return ennyi nukleotidot sikerült belerakni
     */
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

    /**
     *
     * @param added ennyi aminosavat akarunk belerakni
     * @return ennyi aminosavat sikerült belerakni
     */
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

    /**
     *
     * @param take ennyi amiosavat akarunk kivenni
     * @return ennyi aminosavat sikerült kivenni
     */
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

    /**
     *
     * @param take ennyi nukleotidot akarunk kivenni
     * @return ennyi nukleotidot sikerült kivenni
     */
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
