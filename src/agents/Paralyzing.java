package agents;

import agents.Agent;
import cast.CastImpared;
import cast.CastNormal;
import character.Player;
import getCastOn.GetCastOnNormal;
import getLootTakenFrom.LootTakenNormal;
import getLootTakenFrom.LootTakenStunned;
import loot.LootImpared;
import loot.LootNormal;
import movement.MovementNormal;
import movement.MovementParalyzed;
import tester.testerClass;

public class Paralyzing extends Agent {
    public Paralyzing() {
        super();
        testerClass.print();
    }

    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     *
     * @param player A jatekos akinek a karakterere rekentek az agenst
     */
    public void takeEffect(Player player) {
        testerClass.print();
        player.setLoot(new LootImpared());
        player.setMovement(new MovementParalyzed(player));
        player.setCast(new CastImpared(player));
        player.setGetLootTakenFrom(new LootTakenStunned(player));
    }

    /**
     * Az agens hatasa lejar
     *
     * @param player A jatekos akinek a karakteren van az agens
     */
    public void loseEffect(Player player) {
        testerClass.print();
        player.setLoot(new LootNormal());
        player.setMovement(new MovementNormal(player));
        player.setCast(new CastNormal(player));
        player.setGetLootTakenFrom(new LootTakenNormal(player));
        player.removeActiveAgent(this);
    }
    public String ToString(){return "Paralyzing";}
}
