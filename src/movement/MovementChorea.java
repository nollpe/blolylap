package movement;

import character.Player;
import field.Field;
import tester.testerClass;
import java.util.Random;

/**
 * A mozgást kezelő osztály vírustánc esetén
 */
public class MovementChorea implements Movement {
    /**
     * A játékos, aki stratégiája ez
     */
    private final Player owner;

    /**
     * Alap konstruktor
     * @param p a játékos, aki stratégiája ez
     */
    public MovementChorea(Player p) {
        owner = p;
    }

    /**
     * A mozgást végző függvény, egy véletlenszerű irányba mozgatja a játékost
     *
     * @param field  a mező, ahova mozgatni akarjuk
     */
    @Override
    public void move(Field field) {
        testerClass.print();
        if (!owner.getLocation().getNeighbours().contains(field)) {
            return;
        }
        Random rand = new Random();
        int newIndex = rand.nextInt(owner.getLocation().getNeighbours().size());
        Field newField = owner.getLocation().getNeighbours().get(newIndex);
        owner.getLocation().leave(owner);
        newField.enter(owner);
    }
}