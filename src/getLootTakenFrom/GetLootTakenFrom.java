package getLootTakenFrom;

import character.Player;
import equipment.Equipment;

/**
 * A lootolás elszenvedésének ősosztálya.
 * Az osztály leszármazottjai valósítják meg a lootolás elszenvedését  a különböző állapotokban.
 */
public interface GetLootTakenFrom {

    /**
     * A lootolást elszenveédésnek függvénye.
     *
     * @param e A védőfelszerlés amit el akarnak venni a karaktertől.
     * @return A lootolás sikeressége.
     */
    boolean getEquipmentTakenFrom(Equipment e);

    int getNucleotideTakenFrom(int taken);

    int getAminoAcidTakenFrom(int taken);
}
