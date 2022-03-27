package getLootTakenFrom;
import character.Inventory;
import character.Player;
import equipment.Equipment;
import tester.testerClass;

/**
 * A lootolás elszenvedésének osztálya lebénult esetben. Ilyenkor lehet a karaktertől loootlni.
 */
public class LootTakenStunned implements GetLootTakenFrom
{
    /**
     * Védőfelszerelés elvétele karaktertől lebénult esetben. Mivel a karakter le van bénulva, a lootolás megtörétnik.
     * @param e A védőfelszerlés amit el akarnak venni a karaktertől.
     * @param player A játékos akitől el akarják venni a védőfelszerlést.
     * @return A lootolás sikeressége. Ebben az esetben mindig igazat ad vissza, tehát a lootolás sikerült.
     */
    @Override
    public boolean getEquipmentTakenFrom(Equipment e, Player player)
    {
        testerClass.print();
        boolean succes = player.takeLoot(e);
        return succes;
    }

    /**
     * Nukleotide elvétele a karaktertől.
     * @param takenTry Ennyit próbálnak meg elvenni tőle
     * @param player A karakter, akitől elveszik az anyagot.
     * @return Amennyit sikerült elvenni tőle (ha többet próbálnak elvenni tőle, mint amennyi van nála, akkor annyit ad
     * oda, amennyi van neki).
     */
    @Override
    public int getNucleotideTakenFrom(int takenTry, Player player)
    {
        testerClass.print();
        Inventory inventory = player.getInventory();
        int takenActual = inventory.takeNucleotide(takenTry);
        return takenActual;
    }

    /**
     * Aminosav elvétele a karaktertől.
     * @param takenTry Ennyit próbálnak meg elvenni tőle
     * @param player A karakter, akitől elveszik az anyagot.
     * @return Amennyit sikerült elvenni tőle (ha többet próbálnak elvenni tőle, mint amennyi van nála, akkor annyit ad
     * oda, amennyi van neki).
     */
    @Override
    public int getAminoAcidTakenFrom(int takenTry, Player player)
    {
        testerClass.print();
        Inventory inventory = player.getInventory();
        int takenActual = inventory.takeAminoAcid(takenTry);
        return takenActual;
    }
}
