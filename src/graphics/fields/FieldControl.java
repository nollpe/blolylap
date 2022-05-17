package graphics.fields;

import character.Player;
import field.Field;
import game.Game;

/**
 * A field kontrol osztalya, kezeli az eveneteket
 */
public class FieldControl {
    Player owner;
    /**
     * A fieldhez tartotó fieldview
     */
    FIeldView fieldView;
    /**
     * A hozzatartozo field
     */
    Field field;

    /**
     * Konstruktor, beallitja a hozza tartozo fieldet es fieldviewt
     * @param fV a fieldview
     * @param f a field
     */
    public FieldControl(FIeldView fV, Field f) {
        field = f;
        fieldView = fV;
    }

    /**
     * Esemenykezelo, tovabblepteti a soron kovetkezo jatekost
     */
    public void handleEvent() {
        Game.getInstance().gc.getTurnOf().move(field);
        Game.getInstance().gc.Update();
        Game.getInstance().inTurn = false;
    }
}
