package graphics.fields;

import character.Player;
import field.Field;
import game.Game;

public class FieldControl {
    Player owner;
    FIeldView fieldView;
    Field field;

    public FieldControl(FIeldView fV, Field f) {
        field = f;
        fieldView = fV;
    }

    public void handleEvent() {
        Game.getInstance().gc.getTurnOf().move(field);
        Game.getInstance().gc.Update();
        Game.getInstance().inTurn = false;
    }
}
