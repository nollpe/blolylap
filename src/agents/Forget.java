package agents;

import agents.Agent;
import character.Player;
import tester.testerClass;

import java.util.LinkedList;

public class Forget extends Agent {
    public Forget(Player p) {
        super(p);
        testerClass.print();
    }
    //LinkedList<GeneticCode> forgotten;

    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     * @param p A jatekos akinek a karakterere rekentek az agenst
     */
    public void takeEffect(Player p) {
        player = p;
        player.forgetAllGeneticCodes();
    }

    /**
     * Az agens hatasa lejar
     * @param player A jatekos akinek a karakteren van az agens
     */
    public void loseEffect(Player player) {
        player.removeActiveAgent(this);
    }
    public String ToString(){return "Forget";}
}
