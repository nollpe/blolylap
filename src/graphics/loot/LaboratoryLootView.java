package graphics.loot;

import character.Player;
import field.Field;
import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * A laboratorium lootjainak megjeleniteseert felelos osztaly.
 */
public class LaboratoryLootView implements LootView {
    /**
     * A mezo amihez a megjelenites tartozik
     */
    private Field field;
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
     * Megjeleniti a laboratioimbol szerehezo dolgokat
     * @param r A megjelenites helye es meretete
     * @param ImageName -
     * @param f A mezo amihez a megjelenites tartozik
     */
    public LaboratoryLootView(Rectangle r, String ImageName, Field f) {

        label.setBounds(r);
        field = f;

        Image image = Toolkit.getDefaultToolkit().getImage("kepek/agent.png");
        image = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Player player = Game.getInstance().gc.getTurnOf();
                player.addGeneticCode(field.readGeneticCode());
                Game.getInstance().inTurn = false;
            }
        });
    }
}
