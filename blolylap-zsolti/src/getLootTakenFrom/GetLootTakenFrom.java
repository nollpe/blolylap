package getLootTakenFrom;

import character.Player;
import equipment.Equipment;

public interface GetLootTakenFrom {
    boolean getEquipmentTakenFrom(Equipment e, Player player);

    int getNucleotideTakenFrom(int taken);

    int getAminoAcidTakenFrom(int taken);
}
