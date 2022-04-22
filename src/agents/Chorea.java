package agents;

import agents.Agent;
import cast.CastImpared;
import cast.CastNormal;
import character.Player;
import loot.LootImpared;
import loot.LootNormal;
import movement.MovementChorea;
import movement.MovementNormal;
import tester.testerClass;

public class Chorea extends Agent {
    /**
     * Agens konstruktora, beállítja a kapott játékost a payer változóban és alaphelyzetbe állítja a timeLeft számlálót.
     * @param p A jatekos, akihez tartozik az agens
     */
    public Chorea(Player p) {
        super(p);
    }

    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     * @param p A jatekos akinek a karakterere rekentek az agenst
     */
    public void takeEffect(Player p) {
        player = p;
        player.setCast(new CastImpared(player));
        player.setMovement(new MovementChorea(player));
        player.setLoot(new LootImpared(player));
        player.addActiveAgent(this);
        timeToLive = 5;
    }

    /**
     * Az agens hatasa lejar
     * @param player A jatekos akinek a karakteren van az agens
     */
    public void loseEffect(Player player) {
        testerClass.print();
        player.setCast(new CastNormal());
        player.setMovement(new MovementNormal(player));
        player.setLoot(new LootNormal());
        player.removeActiveAgent(this);
        player.deleteActiveAgent(this);
    }
}
