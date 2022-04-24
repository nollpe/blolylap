package agents;

import cast.CastImpared;
import cast.CastNormal;
import character.Player;
import getLootTakenFrom.LootTakenNormal;
import getLootTakenFrom.LootTakenStunned;
import loot.LootImpared;
import loot.LootNormal;
import movement.MovementNormal;
import movement.MovementParalyzed;
import tester.testerClass;

/**
 * A bénulást okozó ágens osztálya
 */
public class Paralyzing extends Agent {
    /**
     * Forget agens konstruktora, beállítja a kapott játékost a payer változóban és alaphelyzetbe állítja a timeLeft számlálót.
     *
     * @param p A jatekos, akihez tartozik az agens
     */
    public Paralyzing(Player p) {
        super(p);
        testerClass.print();
    }

    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     *
     * @param p A jatekos akinek a karakterere rekentek az agenst
     */
    public void takeEffect(Player p) {
        player = p;
        player.setLoot(new LootImpared(player));
        player.setMovement(new MovementParalyzed(player));
        player.setCast(new CastImpared(player));
        player.setGetLootTakenFrom(new LootTakenStunned(player));
        timeToLive = 5;
    }

    /**
     * Az agens hatasa lejar
     *
     * @param player A jatekos akinek a karakteren van az agens
     */
    public void loseEffect(Player player) {
        testerClass.print();
        player.setLoot(new LootNormal(player));
        player.setMovement(new MovementNormal(player));
        player.setCast(new CastNormal(player));
        player.setGetLootTakenFrom(new LootTakenNormal(player));
        player.removeActiveAgent(this);
    }

    public String ToString() {
        return "Paralyzing";
    }
}
