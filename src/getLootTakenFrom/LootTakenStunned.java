package getLootTakenFrom;

import character.Inventory;
import character.Player;
import equipment.Equipment;
import tester.testerClass;

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
        testerClass.print();
        return owner.removeLoot(e);
    }

    /**
     * Nukleotide elvétele a karaktertől.
     *
     * @param takenTry Ennyit próbálnak meg elvenni tőle
     * @return Amennyit sikerült elvenni tőle (ha többet próbálnak elvenni tőle, mint amennyi van nála, akkor annyit ad
     * oda, amennyi van neki).
     */
    @Override
    public int getNucleotideTakenFrom(int takenTry) {
        testerClass.print();
        Inventory inventory = owner.getInventory();
        int takenActual = inventory.takeNucleotide(takenTry);
        return takenActual;
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
        testerClass.print();
        Inventory inventory = owner.getInventory();
        int takenActual = inventory.takeAminoAcid(takenTry);
        return takenActual;
    }
}
