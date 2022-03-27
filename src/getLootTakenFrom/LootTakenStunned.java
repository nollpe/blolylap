package getLootTakenFrom;
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

    @Override
    public int getNucleotideTakenFrom(int taken)
    {
        testerClass.print();
        return taken;
    }

    @Override
    public int getAminoAcidTakenFrom(int taken)
    {
        testerClass.print();
        return taken;
    }
}
