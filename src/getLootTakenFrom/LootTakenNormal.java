package getLootTakenFrom;
import equipment.Equipment;
import tester.testerClass;

public class LootTakenNormal implements GetLootTakenFrom
{

    @Override
    public boolean getEquipmentTakenFrom(Equipment e)
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
