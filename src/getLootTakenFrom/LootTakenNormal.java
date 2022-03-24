package getLootTakenFrom;
import equipment.Equipment;

public class LootTakenNormal implements GetLootTakenFrom
{

    @Override
    public boolean getEquipmentTakenFrom(Equipment e)
    {
        return false;
    }

    @Override
    public int getNucleotideTakenFrom(int taken)
    {
        return 0;
    }

    @Override
    public int getAminoAcidTakenFrom(int taken)
    {
        return 0;
    }
}
