package agents;

import cast.CastImpared;
import cast.CastNormal;
import character.Player;
import getCastOn.GetCastOn;
import getCastOn.GetCastOnBear;
import loot.LootImpared;
import loot.LootNormal;
import movement.MovementBear;
import movement.MovementChorea;
import movement.MovementNormal;
import tester.testerClass;

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
        //TODO ezt nem tudom hogy kell jol
        player.setGetCastOn((GetCastOn) new GetCastOnBear(player));
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
        player.deleteActiveAgent(this);
    }
}
