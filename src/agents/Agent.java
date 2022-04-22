package agents;

import character.Player;
import tester.testerClass;

/**
 * Agens amit a jatekosok egymasra kenhetnek
 */

public class Agent {
    protected Player player;
    protected boolean active;
    protected int timeToLive;

    /**
     * Agens konstruktora, beállítja a kapott játékost a payer változóban és alaphelyzetbe állítja a timeLeft számlálót.
     * @param p A jatekos, akihez tartozik az agens
     */
    public Agent(Player p) {

        player = p;
        active = false;
        timeToLive = 2;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int i) {
        timeToLive = i;
    }

    //TODO: kéne egy normális copykonstruktor
    public Agent(Agent cp) {
        this.player = cp.player;
        this.timeToLive = cp.getTimeToLive();
    }

    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     * @param player A jatekos akinek a karakterere rekentek az agenst
     */
    public void takeEffect(Player player) { }

    /**
     * Az agens hatasa lejar
     *
     * @param player A jatekos akinek a karakteren van az agens
     */
    //TODO: kell a looseEffectnek parameter?
    public void loseEffect(Player player) { }

    public void tick() {
        timeToLive--;
        if(timeToLive <= 0){
            if(active){
                loseEffect(player);
            }
            else{
                player.removeCastableAgent(this);
            }
        }
    }
}