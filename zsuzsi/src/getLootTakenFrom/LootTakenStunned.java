package getLootTakenFrom;
import character.Player;
import equipment.Equipment;
import tester.testerClass;

public class LootTakenStunned implements GetLootTakenFrom
{
    @Override
    public boolean getEquipmentTakenFrom(Equipment e, Player player)
    {
        player.takeLoot(e);
        testerClass.print();
        return true;
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
