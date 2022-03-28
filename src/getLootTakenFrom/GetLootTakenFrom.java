package getLootTakenFrom;
import character.Player;
import equipment.Equipment;

/**
 * A lootolás elszenvedésének ősosztálya.
 * Az osztály leszármazottjai valósítják meg a lootolás elszenvedését  a különböző állapotokban.
 */
public interface GetLootTakenFrom
{
    /**
     * A lootolást elszenveédésnek függvénye.
     * @param e A védőfelszerlés amit el akarnak venni a karaktertől.
     * @param player A játékos akitől el akarják venni a védőfelszerlést.
     * @return A lootolás sikeressége.
     */
    boolean getEquipmentTakenFrom(Equipment e, Player player);
    int getNucleotideTakenFrom(int taken, Player player);
    int getAminoAcidTakenFrom(int taken, Player player);
}
