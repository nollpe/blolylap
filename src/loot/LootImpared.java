package loot;

import character.Player;
import tester.testerClass;

/**
 * Lootolás osztálya lebénult esetben.
 */
public class LootImpared implements Loot {

    /**
     * A lootolást végző függvény. Mivel a karakter le van bénulva, nem történik semmi.
     *
     * @param player A játékos, aki lootol.
     * @return A lootolás sikeressége. Ebben az esetben hamisat ad vissza.
     */
    @Override
    public boolean loot(Player player) {
        testerClass.print();
        return false;
    }
}
