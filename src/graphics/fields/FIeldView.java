package graphics.fields;

import character.Player;
import field.Field;
import graphics.GraphicsConstroller;
import graphics.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A mezok view osztalyanak kozos ose
 */

public class FIeldView implements IView {
    protected Field field;
    protected FieldControl control;
    protected GraphicsConstroller graphicsController;
    protected JLabel label = new JLabel();
    /**
     * Visszaadja a hozza tartozo labelt
     * @return
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * Konstuktor, kirajzolja a mezot
     * @param r A megjelenites helye es meretete
     * @param ImageName A kep ami az ikonhoz tartozik
     * @param f a  field
     */
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

    /**
     * Adatok frissitese es kirajzolasa
     */
    @Override
    public void Update() {

    }
    /**
     * Esemenykezelo, tovabblepteti a soron kovetkezo jatekost
     */
    @Override
    public void Event() {

    }
}
