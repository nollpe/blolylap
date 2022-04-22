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
    public Chorea() {
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
        player.setCast(new CastImpared(player));
        player.setMovement(new MovementChorea(player));
        player.setLoot(new LootImpared());
        player.addActiveAgent(this);
    }

    /**
     * Az agens hatasa lejar
     *
     * @param player A jatekos akinek a karakteren van az agens
     */
    public void loseEffect(Player player) {
        testerClass.print();
        player.setCast(new CastNormal(player));
        player.setMovement(new MovementNormal(player));
        player.setLoot(new LootNormal());
        player.removeActiveAgent(this);

    }
}
