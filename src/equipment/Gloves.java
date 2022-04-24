package equipment;

import character.Player;
import getCastOn.GetCastOnGloves;
import getCastOn.GetCastOnNormal;
import tester.testerClass;

/**
 * A kesztyű védőfelszerelés osztálya.
 * Hatására a játékos vissza tudja pattintani az ágenseket.
 */
public class Gloves extends Equipment {
    /**
     * A kesztyű élettartama
     */
    int durability = 3;

    /**
     * A kesztyű tulajdonosa
     */
    Player owner;

    /**
     * A kesztyű megszerzését (aktiválását) kezeli.
     * Beállítja a karakternek a castolás elszenvedésének állapotát.
     *
     * @param c A karakter, aki megszerezte a kesztyűt.
     */
    public void takeEffect(Player c) {
        c.setGetCastOn(new GetCastOnGloves(c, this));
        owner = c;
    }

    /**
     * A kesztyű elvesztésekor (deaktiválódásakor) hívódik meg.
     * Visszaállítja a karakter állapotát a kesztyű nélküli állapotba.
     *
     * @param c A karakter, aki elvesztette a kesztyűt.
     */
    public void loseEffect(Player c) {
        c.setGetCastOn(new GetCastOnNormal(c));
    }


    /**
     * Használja a felszerelést egy játékoson
     * Nincs Hatása
     *
     * @param p A megcélzott játékos
     */
    public void useOn(Player p) {
    }

    //TODO kell nekem valami amivel csökkenthetem a kesztyű élettartamát
    public String toString() {
        return "Gloves";
    }


    /**
     * Csökkenti a kesztyű élettartamát
     */
    public void decreaseDurability() {
        durability--;
        if (durability == 0) {
            loseEffect(owner);
            owner.removeLoot(this);
        }
    }

}
