package graphics.Equipments;

import equipment.Equipment;

import java.awt.*;

/**
 * A laborkopeny megjeleniteseert felelos osztaly
 */
public class LabcoatView extends EquipmentView{
    /**
     * Meghivja az os konstuktorat az aktualis keppel
     */
    public LabcoatView(Rectangle r, String ImageName, Equipment e) {
        super(r, "kepek/labcoat.png", e);
    }
}
