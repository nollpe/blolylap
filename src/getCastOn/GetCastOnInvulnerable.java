package getCastOn;

import agents.Agent;
import character.Player;

/**
 * Az agens kenes elszenvedeset kezelo osztaly sebezhetetlen esetben
 */
public class GetCastOnInvulnerable implements GetCastOn {
    /**
     * A játékos, akihez a stratégia tartozik
     */
    protected final Player owner;

    /**
     * Alap konstruktor
     *
     * @param p a játékos, aki stratégiája ez
     */
    public GetCastOnInvulnerable(Player p) {
        owner = p;
    }

    /**
     * Az agens kenes elszenvedeset vegzo fuggveny sebezhetetetlen esete, a kenes nem sikerul.
     *
     * @param a        Agens, amit felkennek a karakterre.
     * @param attacker A jatekos, aki keni az agenst.
     */
    @Override
    public void getCastOn(Agent a, Player attacker) {
    }
}
