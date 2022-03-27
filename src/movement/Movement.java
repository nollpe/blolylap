package movement;

import character.Player;
import field.Direction;

public interface Movement
{
    void move(Direction dir, Player player);
}
