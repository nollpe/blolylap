package graphics.Equipments;

import equipment.Equipment;
import graphics.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * A védőfelszerelések megjeleniteseert felelos osztalyok ose.
 */
public class EquipmentView implements IView {
    EquipmentControl control;
    Equipment equipment;
    JLabel label = new JLabel();

    public  JLabel getLabel()
    {
        return label;
    }

    public EquipmentView(Rectangle r, String ImageName, Equipment e) {

        label.setBounds(r);
        equipment = e;
        Image image = Toolkit.getDefaultToolkit().getImage(ImageName);
        image = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }

    public void Update() {

    }

    public void Event() {


    }

    class JavaMouseDeer implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            control.handleEvent(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    }

}
