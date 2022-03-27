package loot;

import character.Player;
import tester.testerClass;

public class LootImpared implements Loot
{

    @Override
    public boolean loot(Player p1)
    {
        testerClass.print();
        return false;
    }
}
