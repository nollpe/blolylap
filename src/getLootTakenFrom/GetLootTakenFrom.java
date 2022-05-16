package getLootTakenFrom;

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

    /**
     * Nucleotide lootolás elszenvedésének függvénye
     *
     * @param taken Amennyit el akarnak venni
     * @return Amennyit sikerül
     */
    int getNucleotideTakenFrom(int taken);

    /**
     * Aminosav lootolás elszenvedésének függvénye
     *
     * @param taken Amennyit el akarnak venni
     * @return Amennyit sikerül
     */
    int getAminoAcidTakenFrom(int taken);
}
