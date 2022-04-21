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
     * A kesztyű megszerzését (aktiválását) kezeli.
     * Beállítja a karakternek a castolás elszenvedésének állapotát.
     *
     * @param c A karakter, aki megszerezte a kesztyűt.
     */
    public void takeEffect(Player c) {
        testerClass.print();
        c.setGetCastOn(new GetCastOnGloves(c));
    }

    /**
     * A kesztyű elvesztésekor (deaktiválódásakor) hívódik meg.
     * Visszaállítja a karakter állapotát a kesztyű nélküli állapotba.
     *
     * @param c A karakter, aki elvesztette a kesztyűt.
     */
    public void loseEffect(Player c) {
        testerClass.print();
        c.setGetCastOn(new GetCastOnNormal(c));
    }
}
