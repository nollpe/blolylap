package agents;
import character.Inventory;

import agents.Agent;
import tester.testerClass;

public class GeneticCode
{
    private Agent agent;
    private int requiredAminoAcid;
    private int requiredNucleotide;

    public Agent makeAgent(Inventory i)
    {
        testerClass.print();return this.agent;
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
