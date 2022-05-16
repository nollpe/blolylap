package graphics.Equipments;

import equipment.Equipment;

import java.awt.*;

/**
 * A kesztyu megjeleniteseert felelos osztaly
 */
public class GlovesView extends EquipmentView {
    /**
     * Meghivja az os konstuktorat az aktualis keppel
     */
    public GlovesView(Rectangle r, String ImageName, Equipment e) {
        super(r, "kepek/gloves.png", e);
    }
}
