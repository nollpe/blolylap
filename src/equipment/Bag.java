package equipment;

import character.Inventory;

import character.Player;
import equipment.Equipment;
import getCastOn.GetCastOnNormal;
import tester.testerClass;

/**
 * A táska védőfelszerelés osztálya.
 * Hatására több dolog lehet a játékosnál.
 */
public class Bag extends Equipment {
    /**
     * Az inventory, amiben a táskában lévő dolgokat lehet tárolni.
     */
    private Inventory inventory;

    /**
     * A táska megszerzésekor hívodik meg a függvény.
     *
     * @param c A karakter, aki megszerezte a táskát.
     */
    public void takeEffect(Player c) {
    }

    /**
     * A táska elvesztésekor hívodik meg.
     *
     * @param c A karakter, aki elveszített a tásktát.
     */
    public void loseEffect(Player c) {
    }

    public Bag() {
        inventory = new Inventory(5);
    }

    /**
     * @param added ennyi nucleotidot akarunk belerakni
     * @return ennyi nukleotidot sikerült belerakni
     */
    public int addNucleotide(int added) {
        return inventory.addNucleotide(added);
    }

    /**
     * @param added ennyi aminosavat akarunk belerakni
     * @return ennyi aminosavat sikerült belerakni
     */
    public int addAminoAcid(int added) {
        return inventory.addAminoAcid(added);
    }

    /**
     * @param take ennyi amiosavat akarunk kivenni
     * @return ennyi aminosavat sikerült kivenni
     */
    public int takeAminoAcid(int take) {
        return inventory.takeAminoAcid(take);
    }

    /**
     * @param take ennyi nukleotidot akarunk kivenni
     * @return ennyi nukleotidot sikerült kivenni
     */
    public int takeNucleotide(int take) {
        return inventory.takeNucleotide(take);
    }


    /**
     * Használja a felszerelést egy játékoson
     * Nincs Hatása
     *
     * @param p A megcélzott játékos
     */
    public void useOn(Player p) {
    }

    public String toString() {
        return "Bag";
    }

    public Inventory getInventory() {
        return inventory;
    }

}