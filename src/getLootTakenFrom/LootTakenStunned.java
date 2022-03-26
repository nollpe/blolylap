package getLootTakenFrom;
import equipment.Equipment;
import tester.testerClass;

public class LootTakenStunned implements GetLootTakenFrom
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
        return taken;
    }

    @Override
    public int getAminoAcidTakenFrom(int taken)
    {
        testerClass.print();
        return taken;
    }
}
