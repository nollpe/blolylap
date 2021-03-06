package agents;

import cast.CastImpared;
import cast.CastNormal;
import character.Player;
import graphics.agents.AgentView;
import graphics.agents.ChoreaView;
import loot.LootImpared;
import loot.LootNormal;
import movement.MovementChorea;
import movement.MovementNormal;

/**
 * A vitustáncot okozó ágens osztálya
 */
public class Chorea extends Agent {
    /**
     * Agens konstruktora, beállítja a kapott játékost a payer változóban és alaphelyzetbe állítja a timeLeft számlálót.
     *
     * @param p A jatekos, akihez tartozik az agens
     */
    public Chorea(Player p) {
        super(p);
        view=new AgentView();
    }

    public Chorea() {
        super();
    }

    public String toString() {
        return "Chorea";
    }

    public Chorea(Chorea c) {
        super(c);
    }

    /**
     * Az agens fel lett kenve valakire elkezdi kifejeteni hatasat
     *
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
     *
     * @param player A jatekos akinek a karakteren van az agens
     */
    public void loseEffect(Player player) {
        player.setCast(new CastNormal(player));
        player.setMovement(new MovementNormal(player));
        player.setLoot(new LootNormal(player));
        player.removeActiveAgent(this);
        player.removeActiveAgent(this);
    }
}
