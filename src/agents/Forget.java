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
     * Az ágens fel lett kenve valakire elkezdi kifejeteni hatását
     *
     * @param player A játékos akinek a karakterére rákenték az ágenst
     */
    public void takeEffect(Player player) {
        testerClass.print();
        player.forgetAllGeneticCodes();
    }

    /**
     * Az ágens hatása lejár
     *
     * @param player A játékos akinek a karakterén van az ágens
     */
    public void loseEffect(Player player) {
        testerClass.print();
        player.removeActiveAgent(this);
    }
}
