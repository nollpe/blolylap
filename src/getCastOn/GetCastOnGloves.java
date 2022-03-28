package getCastOn;

import agents.Agent;
import tester.testerClass;
import character.Player;

/**
 * Az agens kenes elszenvedeset kezelo osztaly sebezhetetlen esetben
 */
public class GetCastOnGloves implements GetCastOn {
    /**
     * Az agens kenes elszenvedeset vegzo fuggveny sebezhetetetlen esete, a kenes nem sikerul.
     *
     * @param a        Agens, amit felkennek a karakterre.
     * @param player   A jatekos, akire kenik az agenst.
     * @param attacker A jatekos, aki keni az agenst.
     */
    @Override
    public void getCastOn(Agent a, Player player, Player attacker) {
        testerClass.print();
        player.setGetCastOn(new GetCastOnNormal());
        attacker.getCastOn(a, player);
    }
}
