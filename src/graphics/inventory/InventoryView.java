package graphics.inventory;

import character.Inventory;
import character.Player;
import graphics.IView;

import javax.swing.*;
import java.awt.*;


public class InventoryView implements IView {
    InventoryControl control;
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JPanel panel;
    Player ownerPlayer;

    public InventoryView(Player player, JPanel p) {
        panel = p;
        ownerPlayer = player;
        label = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label.setBounds(20, 450, 80, 20);
        label1.setBounds(20, 480, 80, 50);
        label2.setBounds(20, 500, 80, 80);
        Update();
    }


    public JLabel getLabel() {
        return label;
    }

    @Override
    public void Update() {
        Inventory inventory = ownerPlayer.getInventory();
        int nucletoide = inventory.getAminoAcid();
        int amino = inventory.getAminoAcid();

        label.setText("Alapanyagok:");
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/combined_resources.png");
        image = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label1.setIcon(icon);
        String string = "  " + amino + "       " + nucletoide;
        label2.setText(string);
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
    }

    @Override
    public void Event() {

    }
}
