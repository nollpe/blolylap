package movement;

import character.Player;
import field.Direction;
import tester.testerClass;

import java.util.Random;

public class MovementChorea implements Movement
{

    @Override
    public void move(Direction dir, Player player)
    {
        testerClass.print();
        player.setLocation(player.getLocation().getNeighbour(dir.randomDirection()));
    }
}
