package getCastOn;

import agents.Agent;
import character.Player;
import tester.testerClass;

import java.util.Scanner;

/**
 * Az ágens kenés elszenvedését kezelő osztály védett (köpenyes) esetben
 */
public class GetCastOnResistant implements GetCastOn {
    /**
     * Az ágens kenés elszenvedését végző függvény  védett esete, a kenés valamekkora valószínűséggel sikerül
     *
     * @param a        Ágens, amit felkennek a karakterre.
     * @param player   A játékos, akire kenik az ágenst.
     * @param attacker A játékos, aki keni az ágenst.
     */
    @Override
    public void getCastOn(Agent a, Player player, Player attacker) {
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
            a.takeEffect(player);
        }
    }
}
