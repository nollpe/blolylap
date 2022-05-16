package loot;

import character.Player;
import equipment.Equipment;

/**
 * Lootolás osztálya lebénult esetben.
 */
public class LootImpared implements Loot {

    public final Player owner;

    public LootImpared(Player p) {
        owner = p;
    }

    /**
     * A lootolást végző függvény. Mivel a karakter le van bénulva, nem történik semmi.
     *
     * @param player A játékos, aki lootol.
     * @return A lootolás sikeressége. Ebben az esetben hamisat ad vissza.
     */
    @Override
    public boolean lootEquipment(Player player, Equipment e) {

        return false;
    }

    @Override
    public int lootAminoAcid(Player player, int taken) {
        return 0;
    }

    @Override
    public int lootNucleotide(Player player, int taken) {
        return 0;
    }
}
