package getCastOn;
import agents.Agent;
import character.Player;
import tester.testerClass;

import java.util.Scanner;

public class GetCastOnResistant implements GetCastOn
{
    @Override
    public void getCastOn(Agent a, Player player, Player attacker)
    {
        testerClass.print();
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String s = "";
        while(!valid) {
            System.out.println("Megvédte a karaktert a köpeny? (I/N)");
            s = input.nextLine();
            /**
             * Ellenőrzi, hogy értelmes választ adott-e a felhasználó
             */
            if(s.compareTo("I")==0 || s.compareTo("N")==0) valid = true;
        }

        /**
         * Ha nem védte meg a köpeny:
         */
        if(s.compareTo("N")==0){
            a.takeEffect(player);
        }
    }
}
