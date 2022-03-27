package getCastOn;
import agents.Agent;
import tester.testerClass;
import character.Player;

/**
 * Az ágens kenés elszenvedését kezelő osztály sebezhetetlen esetben
 */
public class GetCastOnInvulnerable implements GetCastOn
{
    /**
     * Az ágens kenés elszenvedését végző függvény sebezhetetetlen esete, a kenés nem sikerül.
     * @param a Ágens, amit felkennek a karakterre.
     * @param player A játékos, akire kenik az ágenst.
     * @param attacker A játékos, aki keni az ágenst.
     */
    @Override
    public void getCastOn(Agent a, Player player, Player attacker)
    {
        testerClass.print();
    }
}
