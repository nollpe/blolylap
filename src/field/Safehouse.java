package field;


import equipment.Axe;
import equipment.Equipment;
import game.Game;
import graphics.fields.SafehouseView;
import graphics.loot.SafehouseLootView;

import java.awt.*;


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

    /**
     * Időben lépteti a safehouset
     */
    public void tick() {

        super.tick();

        if (stored == null) {
            int gen = (int) Math.random() * 4;
            switch (gen) {
                case (0):
                    stored = new Axe();
                    break;
            }



            /*System.out.println("Mit generáljon a safehouse?\n1:kesztyű\n2:köpeny\n3:tatyó\n0:semmit");
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
            }*/
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
    public void takeEquipment(Equipment e) {

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
