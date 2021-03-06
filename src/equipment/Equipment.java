package equipment;

import character.Player;
import graphics.Equipments.EquipmentView;
import graphics.IView;

/**
 * A védőfeszerlések ősosztálya, ami lehetővé teszi az egységes kezelést.
 */
public class Equipment {

    EquipmentView view;

    public Equipment() {
        //view=new EquipmentView();
    }

    /**
     * A védőfelszerelések megszerzésekor (aktiválódásakor) hívódik meg.
     * Módosítja a karakter állapotát az adott védőfelszerelést hatásának megfelelően.
     *
     * @param c A karakter, aki megszerezte a felszerelést.
     */
    public void takeEffect(Player c) {
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
     * Használja a felszerelést egy játékoson
     * Nincs Hatása
     *
     * @param p A megcélzott játékos
     */
    public void useOn(Player p) {
    }

    public IView getView() {
        return view;
    }

    public String toString() {
        return null;
    }

}
