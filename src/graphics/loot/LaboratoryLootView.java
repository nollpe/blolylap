package graphics.loot;

import character.Player;
import field.Field;
import field.Laboratory;
import game.Game;
import graphics.fields.LaboratoryView;

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

    /**
     * Visszaadja az inventoryhoz tartozo labelt
     * @return  a label
     */
    @Override
    public JLabel getLabel() {
        return label;
    }

    /**
     * Adatok frissitese es kirajzolasa
     */
    @Override
    public void Update() {

    }
    /**
     * Esemeny kezeles
     */
    @Override
    public void Event() {

    }

    /**
     * Visszaadja a kepet ami az ikonhoz tartozik
     * @return
     */
    public String getImage() {
        return "kepek/agent.png";
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

    /**
     * Beallitja az ikon kepet
     * @param agent Az agens aminek a kepet be kell allitani
     */
    public void setImage(String agent) {
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/" + agent + ".png");
        image = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }
}
