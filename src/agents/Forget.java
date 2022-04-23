package agents;

import character.Player;
import tester.testerClass;

/**
 * A felejtést okozó ágens osztálya
 */
public class Forget extends Agent {
    /**
     * Forget agens konstruktora, beállítja a kapott játékost a payer változóban és alaphelyzetbe állítja a timeLeft számlálót.
     * @param p A jatekos, akihez tartozik az agens
     */
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
