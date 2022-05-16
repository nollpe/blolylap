package graphics.fields;

import field.Field;
import graphics.GraphicsConstroller;
import graphics.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FIeldView implements IView {
    protected Field field;
    protected FieldControl control;
    protected GraphicsConstroller graphicsController;
    protected JLabel label = new JLabel();

    public JLabel getLabel() {
        return label;
    }

    public FIeldView(Rectangle r, String ImageName, Field f) {
        control = new FieldControl(this, field);
        label.setBounds(r);
        field = f;

        Image image = Toolkit.getDefaultToolkit().getImage(ImageName);
        image = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
        JavaMouseDeer a = new JavaMouseDeer();
        label.addMouseListener(a);
    }

    private class JavaMouseDeer implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            control.handleEvent();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    @Override
    public void Update() {

    }

    @Override
    public void Event() {

    }
}
