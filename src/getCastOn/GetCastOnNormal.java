package getCastOn;

import agents.Agent;
import character.Player;

/**
 * Az agens kenes elszenvedeset kezelo osztaly normál esetben
 */
public class GetCastOnNormal implements GetCastOn {
    /**
     * A játékos, akihez a stratégia tartozik
     */
    protected final Player owner;

    /**
     * Alap konstruktor
     *
     * @param p a játékos, aki stratégiája ez
     */
    public GetCastOnNormal(Player p) {
        owner = p;
    }

    /**
     * Az agens kenes elszenvedeset vegzo fuggveny normál esete, a kenes sikerull.
     *
     * @param a        Agens, amit felkennek a karakterre.
     * @param attacker A jatekos, aki keni az agenst.
     */
    @Override
    public void getCastOn(Agent a, Player attacker) {
        a.takeEffect(owner);
    }
}
