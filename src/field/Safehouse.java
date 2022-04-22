package field;

import equipment.Bag;
import equipment.Equipment;
import equipment.Gloves;
import equipment.Labcoat;
import field.Field;
import tester.testerClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Safehouse extends Field {
    /**
     * Tárolt védőfelszerelés
     */
    private Equipment stored;

    /**
     * Konstruktor
     * Alapból nullra állítja a tárolt védőfelszerelést
     */
    public Safehouse() {
        super();
        stored = null;
        testerClass.print();
    }

    /**
     * Megmutatja a tartalmazott lootot
     */
    public void showLoot() {
        testerClass.print();
        System.out.println(stored.toString());
    }

    /**
     * Időben lépteti a safehouset
     */
    public void tick() {
        testerClass.print();
        super.tick();

        if (stored == null) {
            System.out.println("Mit generáljon a safehouse?\n1:kesztyű\n2:köpeny\n3:tatyó\n0:semmit");
            int chosen = 0;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                chosen = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (chosen) {
                case (1):
                    stored = new Gloves();
                    break;
                case (2):
                    stored = new Gloves();
                    break;
                case (3):
                    stored = new Bag();
                    break;
                case (0):
                    break;
                default:
                    System.out.println("ez nem jött be bruhtyókám");
            }
        }
    }

    /**
     * Elvesz valamilyen lootot a safehouseból
     */
    public void takeLoot() {
        testerClass.print();
    }

    /**
     * Elvesz egy védőfelszerelést a safehouseból
     *
     * @param e elvevendő védőfelszerelés
     */
    public void takeEquipment(Equipment e) {
        testerClass.print();
        stored=null;
    }

    /**
     * Megadja a safehouse által tárolt védőfelszerelést
     *
     * @param newStored Tárolandó védőfelszerelés
     */
    public void setStored(Equipment newStored) {
        stored = newStored;
    }

    /**
     * Visszaadja a tárolt védőfelszerelést
     *
     * @return tárolt védőfelszerelés
     */
    public Equipment getStored() {
        return stored;
    }
}
