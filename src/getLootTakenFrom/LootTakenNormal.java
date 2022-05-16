package getLootTakenFrom;

import character.Player;
import equipment.Equipment;
import tester.testerClass;

/**
 * A lootolás elszenvedésének osztálya normál esetben. Ilyenkor nem lehet a karaktertől loootlni.
 */
public class LootTakenNormal implements GetLootTakenFrom {
    /**
     * A játékos, aki stratégiája ez
     */
    protected final Player owner;

    /**
     * Alap konstruktor
     *
     * @param p a játékos, aki stratégiája ez
     */
    public LootTakenNormal(Player p) {
        owner = p;
    }

    /**
     * Védőfelszerelés elvétele karaktertől normál esetben. Mivel nem lebénult karakteről nem lehet lootolni,
     * nem történik semmi.
     *
     * @param e A védőfelszerlés amit el akarnak venni a karaktertől.
     * @return A lootolás sikeressége. Ebben az esetben mindig hamisat ad vissza, tehát a lootolás nem sikerült.
     */
    @Override
    public boolean getEquipmentTakenFrom(Equipment e) {

        return false;
    }

    /**
     * Nucleotide elvétele karaktertől normál állapotban. Mivel nincs lebénulva, nem lehet tőle lootolni.
     *
     * @param takenTry Ennyit próbálnak meg elvenni tőle
     * @return Amennyit sikerült elvenni tőle. Ebben az esetben 0.
     */
    @Override
    public int getNucleotideTakenFrom(int takenTry) {

        return 0;
    }

    /**
     * Aminosav elvétele karaktertől normál állapotban. Mivel nincs lebénulva, nem lehet tőle lootolni.
     *
     * @param takenTry Ennyit próbálnak meg elvenni tőle
     * @return Amennyit sikerült elvenni tőle. Ebben az esetben 0.
     */
    @Override
    public int getAminoAcidTakenFrom(int takenTry) {

        return 0;
    }
}
