package getCastOn;

import agents.Agent;
import character.Player;


/**
 * Az agens kenes elszenvedeset kezelo osztaly medvevírusos esetben
 */
public class GetCastOnBear implements GetCastOn {
    /**
     * A játékos, akihez a stratégia tartozik
     */
    protected final Player owner;

    /**
     * Alap konstruktor
     *
     * @param p a játékos, aki stratégiája ez
     */
    public GetCastOnBear(Player p) {
        owner = p;
    }

    /**
     * Az agens kenes elszenvedeset vegzo fuggveny medve vírusos esete, a kenes nem sikerul.
     *
     * @param a        Agens, amit felkennek a karakterre.
     * @param attacker A jatekos, aki keni az agenst.
     */
    @Override
    public void getCastOn(Agent a, Player attacker) {

    }
}
