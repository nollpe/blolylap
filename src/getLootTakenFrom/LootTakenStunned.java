package getLootTakenFrom;

import character.Player;
import equipment.Equipment;

/**
 * A lootolás elszenvedésének osztálya lebénult esetben. Ilyenkor lehet a karaktertől loootlni.
 */
public class LootTakenStunned implements GetLootTakenFrom {
    /**
     * A játékos, aki stratégiája ez
     */
    protected final Player owner;

    /**
     * Alap konstruktor
     *
     * @param p a játékos, aki stratégiája ez
     */
    public LootTakenStunned(Player p) {
        owner = p;
    }

    /**
     * Védőfelszerelés elvétele karaktertől lebénult esetben. Mivel a karakter le van bénulva, a lootolás megtörétnik.
     *
     * @param e A védőfelszerlés amit el akarnak venni a karaktertől.
     * @return A lootolás sikeressége. Ebben az esetben mindig igazat ad vissza, tehát a lootolás sikerült.
     */
    @Override
    public boolean getEquipmentTakenFrom(Equipment e) {

        return owner.removeLoot(e);
    }

    /**
     * Nucleotide elvétele a karaktertől.
     *
     * @param takenTry Ennyit próbálnak meg elvenni tőle
     * @return Amennyit sikerült elvenni tőle (ha többet próbálnak elvenni tőle, mint amennyi van nála, akkor annyit ad
     * oda, amennyi van neki).
     */
    @Override
    public int getNucleotideTakenFrom(int takenTry) {
        return owner.takeNucleotide(takenTry);
    }

    /**
     * Aminosav elvétele a karaktertől.
     *
     * @param takenTry Ennyit próbálnak meg elvenni tőle
     * @return Amennyit sikerült elvenni tőle (ha többet próbálnak elvenni tőle, mint amennyi van nála, akkor annyit ad
     * oda, amennyi van neki).
     */
    @Override
    public int getAminoAcidTakenFrom(int takenTry) {
        return owner.takeAminoAcid(takenTry);
    }
}
