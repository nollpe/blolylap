package getCastOn;

import agents.Agent;
import character.Player;

/**
 * Az ágens kenés elszenvedését kezelő osztályok őse
 */
public interface GetCastOn {
    /**
     * Az ágens kenés elszenvedését végző függvény, különböző hatások alatt különbözően működik.
     *
     * @param a        Ágens, amit felkennek a karakterre.
     * @param player   A játékos, akire kenik az ágenst.
     * @param attacker A játékos, aki keni az ágenst.
     */
    void getCastOn(Agent a, Player player, Player attacker);
}
