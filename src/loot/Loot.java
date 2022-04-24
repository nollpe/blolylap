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

    public int lootAminoAcid(Player target, int taken);

    public int lootNucleotide(Player target, int taken);
}
