package field;


import equipment.*;
import graphics.fields.SafehouseView;
import graphics.loot.SafehouseLootView;

import java.awt.*;
import java.util.Random;


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

        Rectangle r = new Rectangle(0, 0, 60, 60);
        view = new SafehouseView(r, "kepek/safehouse.png", this);

    }

    public Safehouse(String n) {
        this();
        Name = n;
    }

    /**
     * Megmutatja a tartalmazott lootot
     */
    public void showLoot() {

        System.out.println(stored.toString());
    }
    Random rand=new Random();
    /**
     * Időben lépteti a safehouset
     */
    public void tick() {

        super.tick();

        if (stored == null) {
            int gen = rand.nextInt(4);
            switch (gen) {
                case (0):
                    setStored(new Axe());
                    break;
                case (1):
                    setStored(new Labcoat());
                    break;
                case (2):
                    setStored(new Gloves());
                    break;
                case (3):
                    setStored(new Bag());
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Elvesz valamilyen lootot a safehouseból
     */
    public void takeLoot() {

    }

    /**
     * Elvesz egy védőfelszerelést a safehouseból
     *
     * @param e elvevendő védőfelszerelés
     */
    public void takeEquipment() {
        stored = null;
        lootView = null;
    }

    /**
     * Megadja a safehouse által tárolt védőfelszerelést
     *
     * @param newStored Tárolandó védőfelszerelés
     */
    public void setStored(Equipment newStored) {
        stored = newStored;
        String equipmentName = "kepek/" + stored.toString().toLowerCase() + ".png";
        lootView = new SafehouseLootView(new Rectangle(0, 0, 60, 60), equipmentName, this);
    }

    /**
     * Visszaadja a tárolt védőfelszerelést
     *
     * @return tárolt védőfelszerelés
     */
    public Equipment getStored() {
        return stored;
    }

    @Override
    public void vezerles_getstat() {
        super.vezerles_getstat();
        System.out.println("Loot:");
        System.out.println(stored.toString());
    }
}
