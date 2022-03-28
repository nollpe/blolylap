package getCastOn;

import agents.Agent;
import tester.testerClass;
import character.Player;

/**
 * Az ágens kenés elszenvedését kezelő osztály kesztyűs esetben
 */
public class GetCastOnGloves implements GetCastOn {
    /**
     * Az ágen kenés elszenvedését végző függvény kesztyűs esete. Az ágens visszapattan a támadóra.
     *
     * @param a        Ágens, amit felkennek a karakterre.
     * @param player   A játékos, akire kenik az ágenst.
     * @param attacker A játékos, aki keni az ágenst.
     */
    @Override
    public void getCastOn(Agent a, Player player, Player attacker) {
        testerClass.print();
        player.setGetCastOn(new GetCastOnNormal());
        attacker.getCastOn(a, player);
    }
}
