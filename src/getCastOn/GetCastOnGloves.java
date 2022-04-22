package getCastOn;

import agents.Agent;
import equipment.Gloves;
import tester.testerClass;
import character.Player;

/**
 * Az agens kenes elszenvedeset kezelo osztaly sebezhetetlen esetben
 */
public class GetCastOnGloves implements GetCastOn {
    /**
     * A játékos, aki stratégiája ez
     */
    protected final Player owner;
    private Gloves gloves;

    /**
     * Alap konstruktor
     * @param p a játékos, aki stratégiája ez
     */
    public GetCastOnGloves(Player p, Gloves g) {
        gloves = g;
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
        attacker.getCastOn(a, owner);
        //TODO nincs még implementálva
        //gloves.decreaseDurability();
    }
}
