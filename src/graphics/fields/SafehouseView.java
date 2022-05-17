package graphics.fields;

import field.Field;

import java.awt.*;

/**
 * A menedék megjeleniteseert felelos osztaly
 */
public class SafehouseView extends FIeldView {
    /**
     * Konstruktor, meghivja az os konsturktorat a megfeleo keppel
     * @param r A megjelenites helye es meretete
     * @param ImageName A kep ami az ikonhoz tartozik
     * @param f a  field
     */
    public SafehouseView(Rectangle r, String ImageName, Field f) {
        super(r, "kepek/safehouse.png", f);
    }
}
