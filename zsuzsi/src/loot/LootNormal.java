package loot;

import character.Player;
import equipment.Equipment;
import tester.testerClass;

import java.util.LinkedList;
import java.util.Scanner;

public class LootNormal implements Loot {
    @Override
    public boolean loot(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Játékostól szeretnél lootolni? (I/N)");
        String s = input.nextLine();
        if(s.compareTo("I")==0) {
            testerClass.print();
            LinkedList<Player> targetlist = player.getLocation().getInhabitants();

            if (targetlist.size() > 0) {
                boolean valid = false;
                int n = 0;
                while(!valid){
                    System.out.println("Hanyadik játékostól szeretnél lootolni? 1-" + targetlist.size());
                    n = Integer.parseInt(input.nextLine()) - 1;
                    if(n>=0 && n <targetlist.size()) valid = true;
                }

                Player target = targetlist.get(n);

                Equipment[] equipmentlist = target.getStored();
                if (equipmentlist.length > 0) {
                    valid = false;
                    while(!valid){
                        System.out.println("Hanyadik eszközt szeretnéd elvenni? 1-" + equipmentlist.length);
                        n = Integer.parseInt(input.nextLine()) - 1;
                        if(n>=0 && n <equipmentlist.length) valid = true;
                    }

                    Equipment equipment = equipmentlist[n];
                    boolean succes = target.getLootTakenFrom(equipment);
                    if (succes) {
                        equipment.takeEffect(player);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
