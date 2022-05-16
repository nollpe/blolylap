package graphics.Equipments;


import equipment.Bag;
import equipment.Equipment;
import game.Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A taska megjeleniteseert felelos osztaly
 */
public class BagView extends EquipmentView {
    /**
     * Meghivja az os konstuktorat az aktualis keppel
     */
    public BagView(Rectangle r, String ImageName, Equipment e) {
        super(r, "kepek/bag.png", e);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                BagControl bagControl = new BagControl((Bag) equipment, Game.getInstance().gc.getTurnOf().getInventory());
            }
        });
    }

}
