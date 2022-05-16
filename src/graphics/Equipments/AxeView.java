package graphics.Equipments;

import equipment.Equipment;

import java.awt.*;

/**
 * A fejsze megjeleniteseert felelos osztaly
 */

public class AxeView extends EquipmentView{
    /**
     * Meghivja az os konstuktorat az aktualis keppel
     */
    public AxeView(Rectangle r, String ImageName, Equipment e) {
        super(r, "kepek/axe.png", e);
    }
}
