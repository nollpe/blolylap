package getLootTakenFrom;
import equipment.Equipment;

public class LootTakenStunned implements GetLootTakenFrom
{
    @Override
    public boolean getEquipmentTakenFrom(Equipment e)
    {
        return false;
    }

    @Override
    public int getNucleotideTakenFrom(int taken)
    {
        return taken;
    }

    @Override
    public int getAminoAcidTakenFrom(int taken)
    {
        return taken;
    }
}
