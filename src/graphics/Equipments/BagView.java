package graphics.Equipments;

import equipment.Equipment;

import java.awt.*;
/**
 * A taska megjeleniteseert felelos osztaly
 */
public class BagView  extends  EquipmentView {
    /**
     * Meghivja az os konstuktorat az aktualis keppel
     */
    public BagView(Rectangle r, String ImageName, Equipment e) {
        super(r, "kepek/bag.png", e);
    }
}
