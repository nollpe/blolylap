package graphics.Equipments;

import character.Player;
import equipment.Equipment;
import graphics.IControl;
import graphics.player.PlayerControl;

import java.awt.event.MouseEvent;

public class EquipmentControl implements IControl {
    EquipmentView view;
    Equipment owner;
    Player ownerPlayer;
    PlayerControl playercontrol;
    boolean selected;


    /**
     * Ha egy felszerelesre kattint a felhasznalo, akkor kijeloli azt.(es a kesobbi akciok ezzel a felszerelessel fognak megtortenni.
     *
     * @param e az esemeny
     */
    @Override
    public void handleEvent(MouseEvent e) {
        if (!selected) {
            selected = true;
            playercontrol.handleEvent(e);
        }
    }
}
