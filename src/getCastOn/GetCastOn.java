package getCastOn;

import agents.Agent;
import character.Player;

/**
 * Az agens kenes elszenvedeset kezelo osztály interfésze
 */
public interface GetCastOn {
    /**
     * A játékos, akihez a stratégia tartozik
     */
    Player player = null;
    
    /**
     * Az agens kenes elszenvedeset vegzo fuggveny, minden az interfészt megvalósító osztályban máshogy történik
     * @param a        Agens, amit felkennek a karakterre.
     * @param attacker A jatekos, aki keni az agenst.
     */
    void getCastOn(Agent a, Player attacker);
}
