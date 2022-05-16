package graphics.inventory;

import character.Inventory;
import character.Player;
import graphics.IControl;

public class InventoryControll implements IControl
{
    Player ownerPlayer;
    InventoryView view;
    Inventory owner;


    @Override
    public void handleEvent() {

    }
}
