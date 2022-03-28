package agents;
import character.Inventory;

import agents.Agent;
import tester.testerClass;

/**
 * A genetikai kód, amit laboratóriumok faláról össze lehet szedni és ez alapján ágenst csinálni
 */

public class GeneticCode
{
    private Agent agent;
    private int requiredAminoAcid;
    private int requiredNucleotide;

    /**
     * A játékos ágenst csinál
     * @param i annak a játékosnak inventory-ja ami az ágenst létre akarja hozni
     * @return a megfőzött ágens, ha azt el tudja készíteni
     *         null ha nem tudja elkészíteni
     */
    public Agent makeAgent(Inventory i)
    {
        testerClass.print();
        int aminoTaken=i.takeAminoAcid(requiredAminoAcid);
        int nucleTaken=i.takeNucleotide(requiredNucleotide);
        if(aminoTaken==requiredAminoAcid && nucleTaken==requiredNucleotide)
        {
            return this.agent;
        }
        else
        {
            i.addAminoAcid(aminoTaken);
            i.addNucleotide(nucleTaken);
            return null;
        }
    }

    public GeneticCode()
    {
        testerClass.print();
    }

    public GeneticCode(Agent a,int ami,int nuc)
    {
        testerClass.print();
        agent=a;
        requiredNucleotide=nuc;
        requiredAminoAcid=ami;
    }

    public GeneticCode clone() {
        return new GeneticCode(agent, requiredAminoAcid, requiredNucleotide);
    }
}