package loot;

import tester.testerClass;

public class LootImpared implements Loot
{

    @Override
    public boolean loot()
    {
        testerClass.print();
        return false;
    }
}
