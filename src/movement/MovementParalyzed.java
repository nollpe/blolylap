package movement;

import character.Player;
import field.Direction;
import field.Field;
import tester.testerClass;

/**
 * A mozgást kezelő osztály, ha a játékos le van bénulva
 */
public class MovementParalyzed implements Movement {
    /**
     * A játékos, aki stratégiája ez
     */
    protected final Player owner;

    /**
     * Alap konstruktor
     *
     * @param p a játékos, aki stratégiája ez
     */
    public MovementParalyzed(Player p) {
        owner = p;
    }

    /**
     * Nem csinál semmit, nem mozdítja el a játékost
     *
     * @param field a mező amibe a játékost mozgatni akarjuk
     */
    @Override
    public void move(Field field) {
        testerClass.print();
        return;
    }
}