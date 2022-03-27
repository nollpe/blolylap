package loot;

import character.Inventory;
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
                    System.out.println("Melyik játékostól szeretnél lootolni?\n1-Lebénult karakter \n2-Nem lebénult karakter");
                    n = Integer.parseInt(input.nextLine());
                    if(n>0 && n <targetlist.size()) valid = true;
                }

                /**
                 * A kiválasztott karakter lesz a célpont.
                 */
                Player target = targetlist.get(n);

                /**
                 * Megkérdezi a felhasználót, hogy mit szeretne lootolni (felszerelés vagy anyag)
                 */
                valid = false;
                while(!valid){
                    System.out.println("Mit szeretnél lootolni?\n1-Feszereléstt \n2-Anyagot");
                    n = Integer.parseInt(input.nextLine());
                    if(n>=0 && n <3) valid = true;
                }


                /**
                 * Attól függően, hogy a felhasználó anyagot vay felszerelést választotta, lefuttatja a megfelelő teszte.
                 * Első: felszerelés lootolása.
                 * Második: anyag lootolása.
                 * Ha a lootolás sikerült, igazzal tér vissza.
                 */
                if(n == 1){
                    boolean succes = lootEquipment(target, player);
                    return true;
                }
                else{
                    boolean succes = lootAminoAndNucleotide(target, player);
                    return true;
                }
            }
        }

        /**
         * Ha nem sikerült a lootolás, hamissal tér vissza.
         */
        return false;
    }

    /**
     * Felszerelés lootolása
     * @param target A célpont, akitől elveszik a felszerelést.
     * @param player A  játékos, aki a lootolás kezdeményezte.
     * @return A lootolás sikeressége. Igaz ha sikerült (azaz le volt bénulva a másik karakter és volt mit elvenni tőle)
     */
    private boolean lootEquipment(Player target, Player player){
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int n = 0;
        /**
         * Lekérdezi, hogy a felhasználó által választott karakternél milyen védőfelszerelések vannak.
         */
        LinkedList<Equipment> equipmentlist = target.getStored();

        /**
         * Ha van a karatkernél nincsen egy felszerelés sem, a lootolás sikertelen volt.
         */
        if(equipmentlist.size() == 0){
            return false;
        }
        /**
         * Különben lehet lootolni:
         */
        else{
            /**
             * Megkérdezi a felhasználót, hogy a másik karakternél lévő védőfelszerelések  közül melyiket szeretné elvenni
             * (kesztyű, köpeny vagy táska)
             */
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
        return false;
    }

    /**
     * Anyag lootolása
     * @param target A célpont, akitől elveszik a anyagot.
     * @param player A  játékos, aki a lootolás kezdeményezte.
     * @return A lootolás sikeressége. Igaz ha sikerült (azaz le volt bénulva a másik karakter és volt mit elvenni tőle)
     */
    private boolean lootAminoAndNucleotide(Player target, Player player){
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int n = 0;
        /**
         * Megkérdezi a felhasználót, hogy milyen anyagot szeretne elvenni
         * (aminosav vagy nukleotide)
         */
        valid = false;
        while(!valid){
            System.out.println("Melyik anyagot szeretnéd elvenni?\n1-Aminosav \n2-Nukleotide");
            n = Integer.parseInt(input.nextLine());
            if(n>=0 && n <3) valid = true;
        }
        /**
         * A célpontnak szól, hogy elvettek tőle anyagot.
         * A kezdeményzező karakter megkap annyit amennyit sikerült elvenni (lehet kevesebb mint amennyit akart)
         * Ha nem kapott meg semennyit, nullát ad hozzá.
         */
        int lootedN = 0;
        Inventory inventory = player.getInventory();
        switch (n){
            case 1:
                lootedN = target.takeAminoAcid(3);
                inventory.addAminoAcid(lootedN);
                return true;
            case 2:
                lootedN = target.takeNukleotide(3);
                inventory.addNucleotide(lootedN);
                return true;
            default:
                System.out.println("Ilyen nincsen");
        }
        return false;
    }
}
