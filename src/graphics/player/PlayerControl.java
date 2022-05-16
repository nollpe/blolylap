package graphics.player;

import character.Player;
import equipment.Equipment;
import graphics.IControl;

import java.awt.event.MouseEvent;

public class PlayerControl implements IControl {
    Player owner;
    Equipment selectedEquipment;

    public PlayerControl(Player player) {

    }

    @Override
    public void handleEvent(MouseEvent e) {
        if(false /*hogy azonositjuk h equipmentre kattintott? getComponent() valami*/){
            //selectedEquipment = valami.
        }
    }
}

