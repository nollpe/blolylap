package loot;

import character.Player;
import equipment.Equipment;

/**
 * Lootolást vezérlő osztályok őse.
 */
public interface Loot {

    /**
     * A lootolást végző függvény.
     *
     * @param target A játékos, aki lootol.
     * @return A lootolás sikeressége.
     */
    public boolean lootEquipment(Player target, Equipment e);
    public boolean lootAminoAcid(Player target, int taken);
    public boolean lootNukleotide(Player target, int taken);
}
