package cast;

import character.Player;
import tester.testerClass;

/**
 * Az ágens kenés vezéréléséért felelős osztály lebénult állapotban. Ilyenkor az ágens felkenése nem lehetséges.
 */
public class CastImpared implements Cast {
    /**
     * Az ágens kenés függvénye lebénult esetben.
     *
     * @param player A játékos aki a kenést csinálja
     * @return A kenés sikeressége. Ebben az esetben mindig false.
     */
    @Override
    public boolean cast(Player player) {
        testerClass.print();
        return false;
    }
}