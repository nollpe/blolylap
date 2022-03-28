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
     * Az ágens kenés függvénye lebénult esetben.
     *
     * @param player A játékos aki a kenést csinálja
     * @return A kenés sikeressége.
     */
    @Override
    public boolean cast(Player player) {
        testerClass.print();
        /**
         * Megkérdezi a mezőtől, hogy milyen játékosok állnak rajta.
         */
        LinkedList<Player> targetlist = player.getLocation().getInhabitants();

        /**
         * Abban az esetben, ha nem egyedül van a játékos a mezőn, végrehajtható az ágens kenése.
         */
        if (targetlist.size() > 0) {
            /**
             * Megkérdezi a felhasználótól, hogy melyik játékosra szeretne ágenst kenni
             * (Kesztyűs, köpenyes)
             */
            boolean valid = false;
            int n = 0;
            Scanner input = new Scanner(System.in);
            while (!valid) {
                System.out.println("Melyik játékosra szeretnél ágenst kenni?\n1-Önmaga \n2-Kesztyűs játékos \n3-Köpenyes játékos \n4-Normál játékos \n5-Sebezhetetlen játékos");
                n = Integer.parseInt(input.nextLine()) - 1;
                if (n >= 0 && n < targetlist.size()) valid = true;
            }

            /**
             * A kiválasztott karakter lesz a célpont.
             */
            Player target = targetlist.get(n);

            /**
             * Megkérdezi a felhasználót, hogy mit szeretne kenni (felejtő vagy sebezhetetlenséget okozó)
             */
            valid = false;
            while (!valid) {
                System.out.println("Mit szeretnél rákenni?\n1-Sebezhetetlenséget okozó ágenst\n2-Felejtést okozó ágenst");
                n = Integer.parseInt(input.nextLine()) - 1;
                if (n >= 0 && n < 2) valid = true;
            }
            LinkedList<Agent> castableAgents = player.getCastableAgents();
            Agent agent = castableAgents.get(n);

            /**
             * Attól függően, hogy a felhasználó anyagot vay felszerelést választotta, lefuttatja a megfelelő teszte.
             * Első: felszerelés lootolása.
             * Második: anyag lootolása.
             * Ha a lootolás sikerült, igazzal tér vissza.
             */
            target.getCastOn(agent, player);
        }
        return true;
    }
}