package graphics.loot;

import character.Player;
import field.Field;
import field.Safehouse;
import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SafehouseLootView implements LootView {
    private Safehouse field;
    private JLabel label = new JLabel();

    @Override
    public JLabel getLabel() {
        return label;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Event() {

    }

    public SafehouseLootView(Rectangle r, String ImageName, Field f) {

        label.setBounds(r);
        field = (Safehouse) f;

        Image image = Toolkit.getDefaultToolkit().getImage(ImageName);
        image = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Player player = Game.getInstance().gc.getTurnOf();
                player.addEquipment(field.getStored());
                field.takeEquipment();
                Game.getInstance().inTurn = false;
            }
        });
    }
}
