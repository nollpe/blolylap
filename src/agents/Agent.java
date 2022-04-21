package agents;

import character.Player;
import tester.testerClass;

/**
 * Agens amit a jatekosok egymasra kenhetnek
 */

public class Agent {
    int timeToLive;

    public Agent() {
        testerClass.print();
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int i) {
        timeToLive = i;
    }

    //TODO: kéne egy normális copykonstruktor
    public Agent(Agent cp) {
        this.timeToLive = cp.getTimeToLive();
    }

    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     *
     * @param player A jatekos akinek a karakterere rekentek az agenst
     */
    public void takeEffect(Player player) {
        testerClass.print();
    }

    /**
     * Az agens hatasa lejar
     *
     * @param player A jatekos akinek a karakteren van az agens
     */
    public void loseEffect(Player player) {
        testerClass.print();
    }

    public void tick() {
        testerClass.print();
        timeToLive--;
    }


}