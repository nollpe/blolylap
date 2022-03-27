package loot;

import character.Player;
import equipment.Equipment;
import tester.testerClass;

import java.util.LinkedList;
import java.util.Scanner;

public class LootNormal implements Loot
{
    @Override
    public boolean loot(Player player) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String s = "";
        while(!valid) {
            System.out.println("Játékostól szeretnél lootolni? (I/N)");
            s = input.nextLine();
            if(s.compareTo("I")==0 || s.compareTo("N")==0) valid = true;
        }

        if(s.compareTo("I")==0) {
            testerClass.print();
            LinkedList<Player> targetlist = player.getLocation().getInhabitants();

            if (targetlist.size() > 0) {
                valid = false;
                int n = 0;
                while(!valid){
                    System.out.println("Hanyadik játékostól szeretnél lootolni?\n1-Lebénult karakter \n2-Nem lebénult karakter");
                    n = Integer.parseInt(input.nextLine());
                    if(n>0 && n <targetlist.size()) valid = true;
                }

                Player target = targetlist.get(n);

                LinkedList<Equipment> equipmentlist = target.getStored();
                if (equipmentlist.size() > 0) {
                    valid = false;
                    while(!valid){
                        System.out.println("Hanyadik eszközt szeretnéd elvenni?\n1-Kesztyű \n2-Köpeny \n3-Táska");
                        n = Integer.parseInt(input.nextLine())-1;
                        if(n>=0 && n <equipmentlist.size()) valid = true;
                    }

                    Equipment equipment = equipmentlist.get(n);
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
