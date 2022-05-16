package graphics.inventory;

import character.Inventory;
import character.Player;
import graphics.IControl;

import java.awt.event.MouseEvent;

public class InventoryControl implements IControl {
    Player ownerPlayer;
    InventoryView view;
    Inventory owner;


    @Override
    public void handleEvent(MouseEvent e) {

    }
}
