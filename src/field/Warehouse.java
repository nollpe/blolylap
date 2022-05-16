package field;

import character.Inventory;
import game.Game;
import graphics.fields.WarehouseView;
import graphics.loot.WarehouseLootView;

import java.awt.*;


public class Warehouse extends Field {
    private Inventory stored;

    public Warehouse() {
        super();

        stored = new Inventory(50);
        Rectangle r = new Rectangle(0, 0, 60, 60);
        view = new WarehouseView(r, "kepek/warehouse.png", this);
        lootView = new WarehouseLootView(r, "kepek/combined_resources.png", this);

    }

    public Warehouse(String n) {
        this();
        Name = n;
    }

    /**
     * Megmutatja melyik alapanyagból mennyi található itt
     */
    public void showLoot() {

        System.out.println("aminosav :" + stored.getAminoAcid() + "\nnukleotid: " + stored.getNucleotide());
    }


    /**
     * minden körben van esély, hogy "termelődik" új aminosav és nukleotid
     */
    public void tick() {

        super.tick();


        stored.addAminoAcid((int) (Math.random() * 2));
        stored.addNucleotide((int) (Math.random() * 2));


    }

    public void takeLoot() {

    }

    public Inventory getStored() {
        return stored;
    }

    /**
     * @param taken ennyi nukleotidot akarunk kivenni
     * @return ennyi nukleotidot sikerült kivenni
     */
    public int takeNucleotide(int taken) {

        return stored.takeNucleotide(taken);
    }

    /**
     * @param taken ennyi amiosavat akarunk kivenni
     * @return ennyi aminosavat sikerült kivenni
     */
    public int takeAminoAcid(int taken) {

        return stored.takeAminoAcid(taken);
    }

    public void setStored(Inventory stored) {
        this.stored = stored;
    }

    @Override
    public int getNucleotide() {
        return stored.getNucleotide();
    }

    @Override
    public int getAminoAcid() {
        return stored.getAminoAcid();
    }

    @Override
    public void vezerles_getstat() {
        super.vezerles_getstat();
        System.out.println("Loot:");
        System.out.println("nucleotide: " + stored.getNucleotide() + " aminoacid: " + stored.getAminoAcid());
    }
}

