package loot;

import character.Player;

/**
 * Lootolást vezérlő osztályok őse.
 */
public interface Loot
{
    /**
     * A lootolást végző függvény.
     * @param player A játékos, aki lootol.
     * @return A lootolás sikeressége.
     */
    boolean loot(Player player);
}
