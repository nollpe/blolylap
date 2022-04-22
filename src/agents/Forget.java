package agents;

import agents.Agent;
import character.Player;
import tester.testerClass;

import java.util.LinkedList;

public class Forget extends Agent {
    public Forget() {
        super();
        testerClass.print();
    }
    //LinkedList<GeneticCode> forgotten;

    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     *
     * @param player A jatekos akinek a karakterere rekentek az agenst
     */
    public void takeEffect(Player player) {
        testerClass.print();
        player.forgetAllGeneticCodes();
    }

    /**
     * Az agens hatasa lejar
     *
     * @param player A jatekos akinek a karakteren van az agens
     */
    public void loseEffect(Player player) {
        testerClass.print();
        player.removeActiveAgent(this);
    }
    public String ToString(){return "Forget";}
}
