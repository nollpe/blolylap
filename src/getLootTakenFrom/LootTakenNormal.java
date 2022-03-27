package getLootTakenFrom;
import character.Player;
import equipment.Equipment;
import tester.testerClass;

/**
 * A lootolás elszenvedésének osztálya normál esetben. Ilyenkor nem lehet a karaktertől loootlni.
 */
public class LootTakenNormal implements GetLootTakenFrom
{
    /**
     * Védőfelszerelés elvétele karaktertől normál esetben. Mivel nem lebénult karakteről nem lehet lootolni,
     * nem történik semmi.
     * @param e A védőfelszerlés amit el akarnak venni a karaktertől.
     * @param player A játékos akitől el akarják venni a védőfelszerlést.
     * @return A lootolás sikeressége. Ebben az esetben mindig hamisat ad vissza, tehát a lootolás nem sikerült.
     */
    @Override
    public boolean getEquipmentTakenFrom(Equipment e, Player player)
    {
        testerClass.print();
        return false;
    }


    @Override
    public int getNucleotideTakenFrom(int taken)
    {
        testerClass.print();
        return 0;
    }

    @Override
    public int getAminoAcidTakenFrom(int taken)
    {
        testerClass.print();
        return 0;
    }
}
