package getCastOn;

import agents.Agent;
import character.Player;
import tester.testerClass;

import java.io.BufferedReader;
import java.util.Random;
import java.util.Scanner;

/**
 * Az agens kenes elszenvedeset kezelo osztaly köpenyes esetben
 */
public class GetCastOnResistant implements GetCastOn {
    /**
     * A játékos, akihez a stratégia tartozik
     */
    protected final Player owner;

    /**
     * Alap konstruktor
     *
     * @param p a játékos, aki stratégiája ez
     */
    public GetCastOnResistant(Player p) {
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
        Random rand = new Random();
        System.out.println("Kerek egy random szamot: 1 - 1000 kozott");

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int num = Integer.parseInt(s);
        while (!(num > 0 && num <= 1000)) {
            s = in.nextLine();
            num = Integer.parseInt(s);
        }
        if (num > 823) {
            /**
             * Ha nem védte meg a köpeny:
             */
            a.takeEffect(owner);
        }
    }
}
