package field;

import character.Player;
import tester.testerClass;

import java.util.LinkedList;
import java.util.EnumMap;

public class Field {
    private EnumMap<Direction, Field> neighbours;
    private LinkedList<Player> inhabitants;

    public Field() {
        testerClass.print();
        this.neighbours = new EnumMap<>(Direction.class);
        this.inhabitants = new LinkedList<>();
    }

    public void addNeighbour(Field added, Direction dir) {
        neighbours.put(dir, added);
    }

    public Field getNeighbour(Direction dir) {
        return neighbours.get(dir);
    }

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
