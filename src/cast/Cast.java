package cast;

import agents.Agent;
import character.Player;

/**
 * Az ágens kenés vezéréléséért felelős osztályok őse.
 */
public interface Cast {
    /**
     * Az ágens kenés függvénye, különböző állapotokban különböző képpen működik
     *
     * @param player A játékos aki a kenést csinálja
     * @param agent  A felkent ágens
     * @return A kenés sikeressége
     */
    boolean cast(Player player, Agent agent);
}
