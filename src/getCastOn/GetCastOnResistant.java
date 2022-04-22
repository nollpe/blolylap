package getCastOn;

import agents.Agent;
import character.Player;
import tester.testerClass;

import java.util.Random;
import java.util.Scanner;

/**
 * Az agens kenes elszenvedeset kezelo osztaly sebezhetetlen esetben
 */
public class GetCastOnResistant implements GetCastOn {
    /**
     * A játékos, aki stratégiája ez
     */
    protected final Player owner;

    /**
     * Alap konstruktor
     * @param p a játékos, aki stratégiája ez
     */
    public GetCastOnResistant(Player p) {
        owner = p;
    }

    /**
     * Az agens kenes elszenvedeset vegzo fuggveny sebezhetetetlen esete, a kenes nem sikerul.
     * @param a        Agens, amit felkennek a karakterre.
     * @param attacker A jatekos, aki keni az agenst.
     */
    @Override
    public void getCastOn(Agent a, Player attacker) {
        Random rand = new Random();
        int random = rand.nextInt(1000);
        if(random > 823){
            /**
             * Ha nem védte meg a köpeny:
             */
            a.takeEffect(owner);
            player.addActiveAgent(a);
        }
    }
}
