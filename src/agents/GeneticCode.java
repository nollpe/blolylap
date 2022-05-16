package agents;

import character.Inventory;

import agents.Agent;
import tester.testerClass;

import java.lang.reflect.InvocationTargetException;

/**
 * A genetikai kód, amit laboratóriumok faláról össze lehet szedni és ez alapján ágenst csinálni
 */

public class GeneticCode {
    private Agent agent;
    private int requiredAminoAcid;
    private int requiredNucleotide;

    /**
     * A játékos ágenst csinál
     *
     * @param i annak a játékosnak inventory-ja ami az ágenst létre akarja hozni
     * @return a megfőzött ágens, ha azt el tudja készíteni
     * null ha nem tudja elkészíteni
     */
    public Agent makeAgent(Inventory i) {
        int aminoTaken = i.takeAminoAcid(requiredAminoAcid);
        int nucleTaken = i.takeNucleotide(requiredNucleotide);
        if (aminoTaken == requiredAminoAcid && nucleTaken == requiredNucleotide) {
            Class<? extends Agent> aClass = agent.getClass();
            try {
                Agent aClass1 = aClass.getDeclaredConstructor(agent.getClass()).newInstance(this.agent);
                return aClass1;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            i.addAminoAcid(aminoTaken);
            i.addNucleotide(nucleTaken);
            return null;
        }
    }

    public GeneticCode() {
    }

    public GeneticCode(Agent a, int ami, int nuc) {
        agent = a;
        requiredNucleotide = nuc;
        requiredAminoAcid = ami;
    }

    public GeneticCode clone() {
        return new GeneticCode(agent, requiredAminoAcid, requiredNucleotide);
    }

    public String getAgentType() {
        return this.agent.toString();

    }

    public String toString() {
        return null;
    }


}
