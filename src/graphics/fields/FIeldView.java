package graphics.fields;

import character.Player;
import field.Field;
import graphics.GraphicsConstroller;
import graphics.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FIeldView implements IView {
    protected Field field;
    protected FieldControl control;
    protected GraphicsConstroller graphicsController;
    protected JLabel label = new JLabel();

    public JLabel getLabel() {
        return label;
    }

    public FIeldView(Rectangle r, String ImageName, Field f) {
        control = new FieldControl(this, f);
        label.setBounds(r);
        field = f;

        Image image = Toolkit.getDefaultToolkit().getImage(ImageName);
        image = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                control.handleEvent();
            }
        });

    }


    @Override
    public void Update() {

    }

    @Override
    public void Event() {

    }
}
