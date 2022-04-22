package getCastOn;

import agents.Agent;
import character.Player;
import tester.testerClass;

public class GetCastOnBear {
    protected final Player owner;

    /**
     * Alap konstruktor
     * @param p a játékos, aki stratégiája ez
     */
    public GetCastOnBear(Player p) {
        owner = p;
    }

    /**
     * Az agens kenes elszenvedeset vegzo fuggveny sebezhetetetlen esete, a kenes nem sikerul.
     *
     * @param a        Agens, amit felkennek a karakterre.
     * @param attacker A jatekos, aki keni az agenst.
     */
    @Override
    public void getCastOn(Agent a, Player attacker) {
        testerClass.print();
        owner.setGetCastOn(new GetCastOnNormal(owner));
        attacker.getCastOn(a, owner);
    }
}
