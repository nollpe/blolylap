package graphics.agents;

import graphics.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Az agen view osztalyok kozos ose
 */
public class AgentView implements IView {
    AgentControl control;
    JLabel label;

    /**
     * Konstruktor, beallitja az ikon kepet es mouselistenert
     */
    public AgentView()
    {
        label=new JLabel();
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/agent.png");
        image = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //TODO
            }
        });
    }

    /**
     * Visszaadja a hozza tartozo labelt
     * @return
     */
    public JLabel getLabel() {
        return label;
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
