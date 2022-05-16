package graphics.fields;

import field.Field;
import graphics.IView;

import javax.swing.*;
import java.awt.*;

public class FIeldView implements IView {
    protected Field field;
    protected JLabel label = new JLabel();

    public JLabel getLabel() {
        return label;
    }

    public FIeldView(Rectangle r, String ImageName, Field f) {

        label.setBounds(r);
        field = f;

        Image image = Toolkit.getDefaultToolkit().getImage(ImageName);
        image = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }

    @Override
    public void Update() {

    }

    @Override
    public void Event() {

    }
}
