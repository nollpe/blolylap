package movement;

import character.Player;
import field.Direction;
import tester.testerClass;

/**
 * A mozgást kezelő osztály, ha a játékoson nincs semmi hatás
 */
public class MovementNormal implements Movement {

    /**
     * A mozgást végző függvény, elmozdítja a játékost a megadott irányba
     *
     * @param dir    az irány amibe a játékost mozgatni akarjuk
     * @param player a mozgatandó játékos
     */
    @Override
    public void move(Direction dir, Player player) {
        testerClass.print();
        if (player.getLocation().getNeighbours().size() == 0) {
            return;
        }
        player.setLocation(player.getLocation().getNeighbour(dir));
    }
}
