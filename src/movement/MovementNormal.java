package movement;

import character.Player;
import field.Direction;
import field.Field;
import tester.testerClass;

public class MovementNormal implements Movement
{

    @Override
    public void move(Direction dir, Player player)
    {
        testerClass.print();
        player.setLocation(player.getLocation().getNeighbour(dir));
    }
}
