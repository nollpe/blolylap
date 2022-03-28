package getCastOn;

import agents.Agent;
import character.Player;
import tester.testerClass;

/**
 * Az ágens kenés elszenvedését kezelő osztály normás esetben
 */
public class GetCastOnNormal implements GetCastOn {
    /**
     * Az ágens kenés elszenvedését végző függvény normál esete, a kenés sikerül.
     *
     * @param a        Ágens, amit felkennek a karakterre.
     * @param player   A játékos, akire kenik az ágenst.
     * @param attacker A játékos, aki keni az ágenst.
     */
    @Override
    public void getCastOn(Agent a, Player player, Player attacker) {
        testerClass.print();
        a.takeEffect(player);
    }
}
