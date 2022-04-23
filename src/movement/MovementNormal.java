package movement;

import character.Player;
import field.Field;
import tester.testerClass;

/**
 * A mozgást kezelő osztály, ha a játékoson nincs semmi hatás
 */
public class MovementNormal implements Movement {
    /**
     * A játékos, aki stratégiája ez
     */
    protected final Player owner;

    /**
     * Alap konstruktor
     *
     * @param p a játékos, aki stratégiája ez
     */
    public MovementNormal(Player p) {
        owner = p;
    }

    /**
     * A mozgást végző függvény, elmozdítja a játékost a megadott irányba
     *
     * @param field a mező amibe a játékost mozgatni akarjuk
     */
    @Override
    public void move(Field field) {
        testerClass.print();
        if (!owner.getLocation().getNeighbours().contains(field)) {
            return;
        }
        owner.getLocation().leave(owner);
        field.enter(owner);
    }
}