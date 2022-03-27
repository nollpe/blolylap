package loot;

import character.Player;
import equipment.Equipment;
import tester.testerClass;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Lootolás osztálya alapesetben, amikor nincsen lebénulva a játékos.
 */
public class LootNormal implements Loot
{
    /**
     * A lootolást végző függvény
     * @param player A játékos, aki lootol
     * @return A lootolás sikeressége. Igazat ad vissza, ha sikerült a lootlás, hamisat, ha nem.
     */
    @Override
    public boolean loot(Player player) {
        testerClass.print();
        /**
         * Megkérdezi a felhasználót, hogy játékostól szeretne-e lootolni (másik lehetőség: a mezőtől)
         */
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String s = "";
        while(!valid) {
            System.out.println("Játékostól szeretnél lootolni? (I/N)");
            s = input.nextLine();
            /**
             * Ellenőrzi, hogy értelmes választ adott-e a felhasználó
             */
            if(s.compareTo("I")==0 || s.compareTo("N")==0) valid = true;
        }

        /**
         * Ha játékostól szeretne:
         */
        if(s.compareTo("I")==0) {
            /**
             * Megkérdezi a mezőtől, hogy milyen játéko sok állnak rajta.
             */
            LinkedList<Player> targetlist = player.getLocation().getInhabitants();

            /**
             * Abban az esetben, ha nem egyedül van a játékos a mezőn, végrehajtható a lootolás.
             */
            if (targetlist.size() > 0) {
                /**
                 * Megkérdezi a felhasználótól, hogy melyik játékostól szeretne lootolni
                 * A lebénult karaktertől sikeres lesz a lootolás.
                 * A nem lebénulttól nem lehet lootolni.
                 */
                valid = false;
                int n = 0;
                while(!valid){
                    System.out.println("Hanyadik játékostól szeretnél lootolni?\n1-Lebénult karakter \n2-Nem lebénult karakter");
                    n = Integer.parseInt(input.nextLine());
                    if(n>0 && n <targetlist.size()) valid = true;
                }

                /**
                 * Megkérdezi a felhasználót, hogy mit szeretne lootolni.
                 */
                valid = false;
                while(!valid){
                    System.out.println("Mit szeretnél lootolni??\n1-Feszereléstt \n2-Anyagot");
                    n = Integer.parseInt(input.nextLine())-1;
                    if(n>=0 && n <3) valid = true;
                }
                if(n == 1){}

                /**
                 * Lekérdezi, hogy a felhasználó által választott karakternél milyen védőfelszerelések vannak.
                 */
                Player target = targetlist.get(n);
                LinkedList<Equipment> equipmentlist = target.getStored();

                /**
                 * Megkérdezi a felhasználót, hogy a másik karakternél lévő védőfelszerelések  közül melyiket szeretné elvenni
                 * (kesztyű, köpeny vagy táska)
                 */
                if (equipmentlist.size() > 0) {
                    valid = false;
                    while(!valid){
                        System.out.println("Hanyadik eszközt szeretnéd elvenni?\n1-Kesztyű \n2-Köpeny \n3-Táska");
                        n = Integer.parseInt(input.nextLine())-1;
                        if(n>=0 && n <equipmentlist.size()) valid = true;
                    }

                    /**
                     * Kiválasztja a listából a megadott védőfelszerelést.
                     */
                    Equipment equipment = equipmentlist.get(n);
                    /**
                     * A célponton meghívja a lootolás elszenvedésének függvényét.
                     * Ha igazzal tér vissza, sikerült a lootolás (azaz le van bénulva a célpont, így el lehet tőle venni)
                     */
                    boolean succes = target.getLootTakenFrom(equipment);
                    if (succes) {
                        equipment.takeEffect(player);
                        return true;
                    }
                }
            }
        }
        /**
         * Ha nem sikerült a lootolás, hamissal tér vissza.
         */
        return false;
    }
}
