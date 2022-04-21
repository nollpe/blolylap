package movement;

import character.Player;
import field.Direction;
import field.Field;

/**
 * A mozgást kezelő osztályok őse
 */
public interface Movement {

    /**
     * A mozgást végző függvény, különböző hatások alatt mást csinál
     *
     * @param field    a mező amibe a játékost mozgatni akarjuk
     */
    void move(Field field);
}