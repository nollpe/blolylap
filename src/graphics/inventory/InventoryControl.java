package graphics.inventory;

import character.Inventory;
import character.Player;
import graphics.IControl;

import java.awt.event.MouseEvent;

/**
 * Az inventory kontroll osztalya, kezeli az esemenyeket.
 */
public class InventoryControl implements IControl {
    Player ownerPlayer;
    InventoryView view;
    Inventory owner;


    /**
     * Esemenykezelo
     * @param e az esemeny.
     */
    @Override
    public void handleEvent(MouseEvent e) {

    }
}
