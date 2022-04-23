package cast;

import agents.Agent;
import character.Player;
import tester.testerClass;

/**
 * Az ágens kenés vezéréléséért felelős osztály lebénult állapotban. Ilyenkor az ágens felkenése nem lehetséges.
 */
public class CastImpared implements Cast {
    /**
     * A tulajdonos játékos
     */
    private Player owner;

    /**
     * Konstruktor, beállítja a tulajdonos játékost
     *
     * @param owner tulajdonos
     */
    public CastImpared(Player owner) {
        this.owner = owner;
    }

    /**
     * Az ágens kenés függvénye lebénult esetben.
     *
     * @param player A játékos aki a kenést csinálja
     * @return A kenés sikeressége. Ebben az esetben mindig false.
     */
    @Override
    public boolean cast(Player player, Agent agent) {
        return false;
    }
}