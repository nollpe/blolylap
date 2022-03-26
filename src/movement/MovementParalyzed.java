package movement;

import tester.testerClass;

public class MovementParalyzed implements  Movement
{

    @Override
    public void move()
    {
        testerClass.print();
    }
}
