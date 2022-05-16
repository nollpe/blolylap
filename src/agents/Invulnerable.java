package agents;

import character.Player;
import getCastOn.GetCastOnInvulnerable;
import getCastOn.GetCastOnNormal;
import tester.testerClass;

/**
 * A sebezhetetetlenséget okozó ágens osztálya
 */
public class Invulnerable extends Agent {
    /**
     * Forget agens konstruktora, beállítja a kapott játékost a payer változóban és alaphelyzetbe állítja a timeLeft számlálót.
     *
     * @param p A jatekos, akihez tartozik az agens
     */
    public Invulnerable(Player p) {
        super(p);
    }

    public Invulnerable(Invulnerable i) {
        super(i);
    }

    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     *
     * @param p A jatekos akinek a karakterere rekentek az agenst
     */
    public void takeEffect(Player p) {
        player = p;
        player.setGetCastOn(new GetCastOnInvulnerable(player));
        player.addActiveAgent(this);
        timeToLive = 5;
    }

    /**
     * Az agens hatasa lejar
     *
     * @param player A jatekos akinek a karakteren van az agens
     */
    public void loseEffect(Player player) {
        player.setGetCastOn(new GetCastOnNormal(player));
        player.removeActiveAgent(this);
    }

    public String toString() {
        return "Invulnerable";
    }

}
