package movement;

import character.Player;
import field.Direction;
import tester.testerClass;

public class MovementParalyzed implements  Movement
{

    @Override
    public void move(Direction dir, Player player)
    {
        testerClass.print();
        return;
    }
}
