package field;

import agents.GeneticCode;
import character.Player;
import tester.testerClass;
import equipment.Equipment;

import java.util.EnumMap;
import java.util.LinkedList;


public class Field {
    private LinkedList<Field> neighbours;
    private LinkedList<Player> inhabitants;
    private String Name;

    public Field() {
        testerClass.print();
        this.neighbours = new LinkedList<>();
        this.inhabitants = new LinkedList<>();
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
        testerClass.print();
        inhabitants.add(c);
        c.setLocation(this);
    }

    public void leave(Player c) {
        testerClass.print();
        inhabitants.remove(c);
    }

    public void showLoot() {
        testerClass.print();
    }

    public void tick() {
        testerClass.print();
        //ne hívja meg a játékosokét mart jobb ha a game csinálja azt mert akkor a tick a játékos köre
        /*for (Player character : inhabitants) {
            character.tick();
        }*/
    }

    public void takeLoot() {
        testerClass.print();
    }

    public LinkedList<Player> getInhabitants() {
        testerClass.print();
        return inhabitants;
    }
    public int takeNukleotide(int n) {
        return 0;
    }
    public int takeAminoAcid(int n){
        return 0;
    }
    public void takeEquipment(Equipment e){}
    public GeneticCode readGeneticCode(){return null;}

}
