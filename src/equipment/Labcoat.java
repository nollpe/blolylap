package equipment;

import character.Player;
import equipment.Equipment;
import getCastOn.GetCastOnNormal;
import getCastOn.GetCastOnResistant;
import tester.testerClass;

/**
 * A védőköpeny védőfelszerelés osztálya.
 * Hatására a játékosra valamekkora eséllyel nem hatnak az ágensek.
 */
public class Labcoat extends Equipment {
    /**
     * A védőköpeny megszerzését (aktiválását) kezeli.
     * Beállítja a karakternek a castolás elszenvedésének állapotát.
     *
     * @param c A karakter, aki megszerezte a védőköpenyt.
     */
    public void takeEffect(Player c) {
        testerClass.print();
        GetCastOnResistant gcor = new GetCastOnResistant(c);
        c.setGetCastOn(gcor);
    }

    /**
     * A védőköpeny elvesztésekor (deaktiválódásakor) hívódik meg.
     * Visszaállítja a karakter állapotát a kesztyű nélküli állapotba.
     *
     * @param c A karakter, aki elvesztette a védőköpenyt.
     */
    public void loseEffect(Player c) {
        testerClass.print();
        c.setGetCastOn(new GetCastOnNormal(c));
    }
}
