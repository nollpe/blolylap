package agents;

import agents.Agent;
import character.Player;
import getCastOn.GetCastOnInvulnerable;
import getCastOn.GetCastOnNormal;
import tester.testerClass;

public class Invulnerable extends Agent {
    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     *
     * @param player A jatekos akinek a karakterere rekentek az agenst
     */
    public void takeEffect(Player player) {
        player.setGetCastOn(new GetCastOnInvulnerable(player));
        testerClass.print();
    }

    public Invulnerable() {
        super();
        testerClass.print();
    }

    /**
     * Az agens hatasa lejar
     *
     * @param player A jatekos akinek a karakteren van az agens
     */
    public void loseEffect(Player player) {
        testerClass.print();
        player.setGetCastOn(new GetCastOnNormal(player));
        player.removeActiveAgent(this);
    }
}
