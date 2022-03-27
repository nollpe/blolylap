package movement;

import character.Player;
import field.Direction;
import tester.testerClass;

public class MovementChorea implements Movement {

    @Override
    public void move(Direction dir, Player player) {
        testerClass.print();
        player.setLocation(player.getLocation().getNeighbour(dir.randomDirection()));
    }
}
