package loot;

import tester.testerClass;

public class LootNormal implements Loot
{
    @Override
    public boolean loot()
    {
        testerClass.print();
        return false;
    }
}
