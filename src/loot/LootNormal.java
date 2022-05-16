package loot;

import character.Player;
import equipment.Equipment;
import tester.testerClass;

/**
 * Lootolás osztálya alapesetben, amikor nincsen lebénulva a játékos.
 */
public class LootNormal implements Loot {

    public final Player owner;

    public LootNormal(Player p) {
        owner = p;
    }

    /**
     * A lootolást végző függvény
     *
     * @param target A játékos, aki lootol
     * @return A lootolás sikeressége. Igazat ad vissza, ha sikerült a lootlás, hamisat, ha nem.
     */
    @Override
    public boolean lootEquipment(Player target, Equipment e) {

        if (target.getLootTakenFrom(e)) {
            owner.addEquipment(e);
            return true;
        }
        return false;
    }

    @Override
    public int lootAminoAcid(Player target, int taken) {
        return target.getAminoAcidTakenFrom(taken);
    }

    @Override
    public int lootNucleotide(Player target, int taken) {
        return target.getNucleotideTakenFrom(taken);
    }
}
