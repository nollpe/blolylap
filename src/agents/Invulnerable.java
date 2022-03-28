package agents;

import agents.Agent;
import character.Player;
import getCastOn.GetCastOnInvulnerable;
import getCastOn.GetCastOnNormal;
import tester.testerClass;

public class Invulnerable extends Agent {
    /**
     * Az ágens fel lett kenve valakire elkezdi kifejeteni hatását
     *
     * @param player A játékos akinek a karakterére rákenték az ágenst
     */
    public void takeEffect(Player player) {
        player.setGetCastOn(new GetCastOnInvulnerable());
        testerClass.print();
    }

    public Invulnerable() {
        super();
        testerClass.print();
    }

    /**
     * Az ágens hatása lejár
     *
     * @param player A játékos akinek a karakterén van az ágens
     */
    public void loseEffect(Player player) {
        testerClass.print();
        player.setGetCastOn(new GetCastOnNormal());
        player.removeActiveAgent(this);
    }
}
