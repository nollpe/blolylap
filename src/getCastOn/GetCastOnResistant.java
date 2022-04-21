package getCastOn;

import agents.Agent;
import character.Player;
import tester.testerClass;

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
        testerClass.print();
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String s = "";
        while (!valid) {
            System.out.println("Megvédte a karaktert a köpeny? (I/N)");
            s = input.nextLine();
            /**
             * Ellenőrzi, hogy értelmes választ adott-e a felhasználó
             */
            if (s.compareTo("I") == 0 || s.compareTo("N") == 0) valid = true;
        }

        /**
         * Ha nem védte meg a köpeny:
         */
        if (s.compareTo("N") == 0) {
            a.takeEffect(owner);
        }
    }
}
