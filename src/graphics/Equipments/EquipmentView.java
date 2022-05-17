package graphics.Equipments;

import equipment.Equipment;
import graphics.IView;

import javax.swing.*;
import java.awt.*;

/**
 * A védőfelszerelések megjeleniteseert felelos osztalyok ose.
 */
public class EquipmentView implements IView {
    EquipmentControl control;
    /**
     * A felszereles amihez a megjelenites tartozik
     */
    Equipment equipment;
    /**
     * A label amire a kep kerul
     */
    JLabel label = new JLabel();

    /**
     * Visszaadja a hozza tartozo labelt
     * @return
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * Konstruktor, inicializalja az ikont
     * @param r A megjelenites helye es meretete
     * @param ImageName A kep ami az ikonhoz tartozik
     * @param e A felszereles amit megjelenit
     */

    public EquipmentView(Rectangle r, String ImageName, Equipment e) {

        label.setBounds(r);
        equipment = e;
        Image image = Toolkit.getDefaultToolkit().getImage(ImageName);
        image = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }

    /**
     * Adatok frissitese es kirajzolasa
     */
    public void Update() {

    }

    /**
     * Esemeny kezeles
     */
    public void Event() {
    }

}
