package field;

import character.Player;
import tester.testerClass;

import java.util.EnumMap;
import java.util.LinkedList;

public class Field {
    private EnumMap<Direction, Field> neighbours;
    private LinkedList<Player> inhabitants;

    public Field() {
        testerClass.print();
        this.neighbours = new EnumMap<>(Direction.class);
        this.inhabitants = new LinkedList<>();
    }

    /**
     * Hozzáad egy új szomszédot a mezőhöz
     *
     * @param added az új szomszéd
     * @param dir   megadja, hogy az új szomszéd milyen irányban van a mezőhöz képest
     */
    public void addNeighbour(Field added, Direction dir) {
        neighbours.put(dir, added);
    }

    /**
     * Megadja, hogy az adott irányban melyik mező van
     *
     * @param dir a keresett irány
     * @return a keresett mezőt adja vissza
     */
    public Field getNeighbour(Direction dir) {
        return neighbours.get(dir);
    }

    /**
     * Visszaadja a mező szomszédjait
     *
     * @return a mező szomszédjai
     */
    public EnumMap<Direction, Field> getNeighbours() {
        return neighbours;
    }

    public void enter(Player c) {
        testerClass.print();
        inhabitants.add(c);
    }

    public void leave(Player c) {
        testerClass.print();
    }

    public void showLoot() {
        testerClass.print();
    }

    public void tick() {
        testerClass.print();
        for (Player character : inhabitants) {
            character.tick();
        }
    }

    public void takeLoot() {
        testerClass.print();
    }

    public LinkedList<Player> getInhabitants() {
        testerClass.print();
        return inhabitants;
    }
}
