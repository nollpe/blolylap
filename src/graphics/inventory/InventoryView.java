package graphics.inventory;

import character.Inventory;
import character.Player;
import graphics.IView;

import javax.swing.*;
import java.awt.*;

/**
 * Az inventory megjelnitessert felelos ostaly, kiirja hogy hany aminosav es nukleitod van a jatekosnal
 */
public class InventoryView implements IView {
    InventoryControl control;
    /**Az "anyagok" szoveg labele*/
    JLabel label;
    /**A kepek labele*/
    JLabel label1;
    /**Az ertekek labele*/
    JLabel label2;
    JPanel panel;
    Player ownerPlayer;

    /**
     * Konstruktor, beallitja az inventoryhoz tartozo jatekost es a panelt amire kirakja a labeleket
     * @param player jatekos
     * @param p panel
     */
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

    /**
     * Visszaadja az inventoryhoz tartozo labelt
     * @return  a label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * Frissiti az anyagok kirajzolasat a kepernyot az aktualis adatok alapjan
     */
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

    /**
     * Esemenykezelo
     */
    @Override
    public void Event() {

    }
}
