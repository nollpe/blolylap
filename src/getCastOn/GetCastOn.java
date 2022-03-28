package getCastOn;

import agents.Agent;
import character.Player;

/**
 * Az agens kenes elszenvedeset kezelo osztaly sebezhetetlen esetben
 */
public interface GetCastOn {
    /**
     * Az agens kenes elszenvedeset vegzo fuggveny sebezhetetetlen esete, a kenes nem sikerul.
     *
     * @param a        Agens, amit felkennek a karakterre.
     * @param player   A jatekos, akire kenik az agenst.
     * @param attacker A jatekos, aki keni az agenst.
     */
    void getCastOn(Agent a, Player player, Player attacker);
}
