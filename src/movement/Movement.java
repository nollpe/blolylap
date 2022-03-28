package movement;

import character.Player;
import field.Direction;

/**
 * A mozgást kezelő osztályok őse
 */
public interface Movement {
    /**
     * A mozgást végző függvény, különböző hatások alatt mást csinál
     *
     * @param dir    az irány amibe a játékost mozgatni akarjuk
     * @param player a mozgatandó játékos
     */
    void move(Direction dir, Player player);
}