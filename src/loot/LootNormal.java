package loot;

import character.Inventory;
import character.Player;
import equipment.Equipment;
import tester.testerClass;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Lootolás osztálya alapesetben, amikor nincsen lebénulva a játékos.
 */
public class LootNormal implements Loot {

    public final Player owner;

    public LootNormal(Player p ){
        owner =p;
    }
    /**
     * A lootolást végző függvény
     *
     * @param target A játékos, aki lootol
     * @return A lootolás sikeressége. Igazat ad vissza, ha sikerült a lootlás, hamisat, ha nem.
     */
    @Override
    public boolean lootEquipment(Player target, Equipment e) {
        testerClass.print();
        target.getLootTakenFrom(e);
        return true;
    }

    @Override
    public boolean lootAminoAcid(Player target, int taken){
        target.takeAminoAcid(taken);
        return true;
    }
    @Override
    public boolean lootNukleotide(Player target, int taken){
        target.takeNukleotide(taken);
        return true;
    }
}
