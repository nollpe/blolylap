package agents;

import cast.CastNormal;
import character.Player;
import getCastOn.GetCastOnBear;
import movement.MovementBear;
import movement.MovementNormal;

/**
 * A medve ágens osztálya
 */
public class Bear extends Agent {

    /**
     * Agens konstruktora, beállítja a kapott játékost a payer változóban és alaphelyzetbe állítja a timeLeft számlálót.
     * @param p A jatekos, akihez tartozik az agens
     */
    public Bear(Player p){
        super(p);
    }
    public String ToString(){return "Bear";}

    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     * @param p A jatekos akinek a karakterere rekentek az agenst
     */
    public void takeEffect(Player p) {
        player = p;
        player.setGetCastOn((new GetCastOnBear(player)));
        player.setMovement(new MovementBear(player));
        player.addActiveAgent(this);
        timeToLive = 5;
    }

    /**
     * Az agens hatasa lejar
     * @param player A jatekos akinek a karakteren van az agens
     */
    public void loseEffect(Player player) {
        player.setCast(new CastNormal(player));
        player.setMovement(new MovementNormal(player));
        player.removeActiveAgent(this);
        player.removeActiveAgent(this);
    }
}
