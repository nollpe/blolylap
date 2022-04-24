package equipment;

import character.Player;

public class Axe extends Equipment {
    private Player owner;

    public Axe() {
        super();
    }

    /**
     * A védőfelszerelések megszerzésekor (aktiválódásakor) hívódik meg.
     * Módosítja a karakter állapotát az adott védőfelszerelést hatásának megfelelően.
     *
     * @param c A karakter, aki megszerezte a felszerelést.
     */
    public void takeEffect(Player c) {
        owner = c;
    }

    /**
     * A védőfelszerelések elvesztésekor (deaktiválódásakor) hívódik meg.
     * Visszaállítja a karakter állapotát a felszerelést nélküli állapotba.
     *
     * @param c A karakter, aki elvesztette a felszerelést.
     */
    public void loseEffect(Player c) {
    }

    /**
     * Használja a baltát egy játékoson
     * Megöli a játékost
     *
     * @param p A megcélzott játékos
     */
    public void useOn(Player p) {
        owner.removeLoot(this);
        //owner.getLoot(). add broken axe
        p.die();
    }

    public String toString() {
        return "Axe";
    }

}
