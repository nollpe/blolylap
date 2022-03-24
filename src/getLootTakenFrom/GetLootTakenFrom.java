package getLootTakenFrom;
import equipment.Equipment;

public interface GetLootTakenFrom
{
    boolean getEquipmentTakenFrom(Equipment e);
    int getNucleotideTakenFrom(int taken);
    int getAminoAcidTakenFrom(int taken);
}
