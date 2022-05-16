package agents;

import character.Player;
import graphics.agents.AgentView;

/**
 * Agens amit a jatekosok egymasra kenhetnek
 */
public class Agent {
    protected Player player;
    protected boolean active;
    protected int timeToLive;
    AgentView view;

    /**
     * Agens konstruktora, beállítja a kapott játékost a payer változóban és alaphelyzetbe állítja a timeLeft számlálót.
     *
     * @param p A jatekos, akihez tartozik az agens
     */
    public Agent(Player p) {

        player = p;
        active = false;
        timeToLive = 2;
    }

    public Agent() {

    }

    public String toString() {
        return "Agent";
    }

    /**
     * Visszaadja az ágens hátralevő idejét
     *
     * @return a hátralév idő
     */
    public int getTimeToLive() {
        return timeToLive;
    }

    /**
     * Beálltja az ágens hátralevő idejét
     *
     * @param i hátralév idő
     */
    public void setTimeToLive(int i) {
        timeToLive = i;
    }

    //TODO: kéne egy normális copykonstruktor
    public Agent(Agent cp) {
        this.player = cp.player;
        this.timeToLive = cp.getTimeToLive();
        this.active = false;
    }

    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     *
     * @param player A jatekos akinek a karakterere rekentek az agenst
     */
    public void takeEffect(Player player) {
    }

    /**
     * Az agens hatasa lejar
     *
     * @param player A jatekos akinek a karakteren van az agens
     */
    //TODO: kell a looseEffectnek parameter?
    public void loseEffect(Player player) {
    }

    public void tick() {
        timeToLive--;
        if (timeToLive <= 0) {
            if (active) {
                loseEffect(player);
            } else {
                player.removeCastableAgent(this);
            }
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean b) {
        active = b;
    }
}