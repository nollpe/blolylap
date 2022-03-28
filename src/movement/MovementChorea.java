package movement;

import character.Player;
import field.Direction;
import field.Field;
import tester.testerClass;

/**
 * A mozgást kezelő osztály vírustánc esetén
 */
public class MovementChorea implements Movement {

    /**
     * A mozgást végző függvény, egy véletlenszerű irányba mozgatja a játékost
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
        Field newField = null;
        while (newField == null) {
            newField = player.getLocation().getNeighbour(dir.randomDirection());
        }
        player.setLocation(newField);
    }
}