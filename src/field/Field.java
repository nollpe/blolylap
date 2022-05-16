package field;

import agents.GeneticCode;
import character.Player;
import equipment.Equipment;
import game.Game;
import graphics.IView;
import graphics.fields.FIeldView;
import graphics.loot.FieldLootView;
import graphics.loot.LootView;

import java.awt.*;
import java.util.LinkedHashSet;
import java.util.LinkedList;


public class Field {
    private LinkedList<Field> neighbours;
    private LinkedHashSet<Player> inhabitants;
    protected String Name;
    protected IView view;
    protected LootView lootView;


    public Field() {
        this.neighbours = new LinkedList<>();
        this.inhabitants = new LinkedHashSet<Player>();
        Rectangle r = new Rectangle(0, 0, 60, 60);
        view = new FIeldView(r, "kepek/field.png", this);
        lootView = new FieldLootView();
    }

    public IView getView() {
        return view;
    }

    public Field(String n) {
        this();
        Name = n;
    }

    public String getName() {
        return Name;
    }

    /**
     * Hozzáad egy új szomszédot a mezőhöz
     *
     * @param added az új szomszéd
     */
    public void addNeighbour(Field added) {
        neighbours.add(added);
    }

    /**
     * Megadja, hogy az adott irányban melyik mező van
     *
     * @param dir a keresett irány
     * @return a keresett mezőt adja vissza
     */
/*    public Field getNeighbour(Direction dir) {
        return neighbours.get(dir);
    }*/

    /**
     * Visszaadja a mező szomszédjait
     *
     * @return a mező szomszédjai
     */
    public LinkedList<Field> getNeighbours() {
        return neighbours;
    }

    public void enter(Player c) {
        inhabitants.add(c);
        c.setLocation(this);
    }

    public void leave(Player c) {
        inhabitants.remove(c);
    }

    public void showLoot() {

    }

    public void tick() {
        //ne hívja meg a játékosokét mart jobb ha a game csinálja azt mert akkor a tick a játékos köre
        /*for (Player character : inhabitants) {
            character.tick();
        }*/
    }


    public LinkedHashSet<Player> getInhabitants() {
        return inhabitants;
    }

    public int takeNucleotide(int n) {
        return 0;
    }

    public int takeAminoAcid(int n) {
        return 0;
    }

    public void takeEquipment(Equipment e) {
    }

    public GeneticCode readGeneticCode() {
        return null;
    }

    public int getNucleotide() {
        return 0;
    }

    public int getAminoAcid() {
        return 0;
    }


    public void vezerles_getstat() {
        System.out.println("Neighbours:");
        for (Field f : neighbours) {
            System.out.println('\t' + f.getName());
        }
        System.out.println("Players:");
        for (Player p : inhabitants) {
            System.out.println('\t' + p.getName());
        }
    }

    public LootView getLootView() {
        return lootView;
    }
}
