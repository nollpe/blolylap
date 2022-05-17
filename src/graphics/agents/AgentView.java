package graphics.agents;

import graphics.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AgentView implements IView {
    AgentControl control;
    JLabel label;

    public AgentView()
    {
        label=new JLabel();
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/Agent.png");
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

    public JLabel getLabel() {
        return label;
    }

    public void Update() {

    }

    public void Event() {

    }


}
