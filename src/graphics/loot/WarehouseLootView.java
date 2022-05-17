package graphics.loot;

import character.Player;
import field.Field;
import field.Warehouse;
import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Az raktart lootjainak megjeleniteseert felelos osztaly.
 */
public class WarehouseLootView implements LootView {
    /**
     * A mezo amihez a megjelenites tartozik
     */
    private Warehouse field;
    /**
     * A label amire a loot kepe kerul
     */
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

    /**
     * Az raktarbol szerezheto dolgok megjeleniteset vegzi.
     * @param r A megjelenites helye es meretete.
     * @param ImageName
     * @param f A mezo amihez a megjelenites tartozik.
     */
    public WarehouseLootView(Rectangle r, String ImageName, Field f) {

        label.setBounds(r);
        field = (Warehouse) f;
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/combined_resources.png");
        image = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Player player = Game.getInstance().gc.getTurnOf();
                player.getInventory().addAminoAcid(field.takeAminoAcid(2));
                player.getInventory().addNucleotide(field.takeNucleotide(2));
                Game.getInstance().inTurn = false;
            }
        });
    }
}
