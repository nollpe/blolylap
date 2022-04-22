package loot;

import character.Player;
import equipment.Equipment;
import tester.testerClass;

/**
 * Lootolás osztálya lebénult esetben.
 */
public class LootImpared implements Loot {

    public final Player owner;
    public LootImpared(Player p ){
       owner =p;
    }
    /**
     * A lootolást végző függvény. Mivel a karakter le van bénulva, nem történik semmi.
     *
     * @param player A játékos, aki lootol.
     * @return A lootolás sikeressége. Ebben az esetben hamisat ad vissza.
     */
    @Override
    public boolean lootEquipment(Player player, Equipment e) {
        testerClass.print();
        return false;
    }
    @Override
    public boolean lootAminoAcid(Player player, int taken){
        return false;
    }
    @Override
    public boolean lootNukleotide(Player player, int taken){
        return false;
    }
}
