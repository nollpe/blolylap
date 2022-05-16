package graphics.Equipments;


import equipment.Equipment;

import java.awt.*;

/**
 * Az elhasznalt fejsze megjeleniteseert felelos osztaly
 */
public class BrokenAxeView extends EquipmentView {
    /**
     * Meghivja az os konstuktorat az aktualis keppel
     */
    public BrokenAxeView(Rectangle r, String ImageName, Equipment e) {
        super(r, "kepek/broken_axe.png", e);
    }
}
