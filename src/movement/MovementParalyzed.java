package movement;

import character.Player;
import field.Direction;
import tester.testerClass;

/**
 * A mozgást kezelő osztály, ha a játékos le van bénulva
 */
public class MovementParalyzed implements Movement {

    /**
     * Nem csinál semmit, nem mozdítja el a játékost
     *
     * @param dir    az irány amibe a játékost mozgatni akarjuk
     * @param player a mozgatandó játékos
     */
    @Override
    public void move(Direction dir, Player player) {
        testerClass.print();
        return;
    }
}