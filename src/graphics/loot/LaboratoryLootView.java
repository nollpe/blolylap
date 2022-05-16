package graphics.loot;

import field.Field;

import javax.swing.*;
import java.awt.*;

public class LaboratoryLootView implements LootView {
    private Field field;
    private JLabel label = new JLabel();

    @Override
    public JLabel getLabel() {
        return null;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Event() {

    }

    public LaboratoryLootView(Rectangle r, String ImageName, Field f) {

        label.setBounds(r);
        field = f;

        Image image = Toolkit.getDefaultToolkit().getImage("kepek/agent.png");
        image = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }
}
