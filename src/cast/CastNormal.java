package cast;

import agents.Agent;
import character.Player;
import tester.testerClass;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Az ágens kenés vezéréléséért felelős osztály normál állapotban. Ilyenkor az ágens felkenése lehetséges.
 */
public class CastNormal implements Cast {
    /**
     * A tulajdonos játékos
     */
    private Player owner;

    /**
     * Konstruktor, beállítja a tulajdonos játékost
     *
     * @param owner tulajdonos
     */
    public CastNormal(Player owner) {
        this.owner = owner;
    }

    /**
     * Az ágens kenés függvénye lebénult esetben.
     *
     * @param player A játékos aki a kenést csinálja
     * @return A kenés sikeressége.
     */
    @Override
    public boolean cast(Player player, Agent agent) {
        if (player.getLocation() == owner.getLocation()) {
            player.getCastOn(agent, player);
            owner.removeCastableAgent(agent);
            return true;
        } else {
            return false;
        }
    }
}