package graphics.GeneticCode;

import agents.GeneticCode;
import character.Player;
import game.Game;
import graphics.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

/**
 * A genetikai kod megjeleniteesert felelos osztaly
 */
public class GeneticCodeView implements IView {
    GeneticCodeControll control;
    /**
     * A jatekos akihez a genetikai kod tartozik
     */
    Player ownerPlayer;
    /**
     * A genetikai kodok listaja
     */
    LinkedList<GeneticCode> owner;
    /**
     * A label amire a genetikai kod kepe kerul
     */
    JLabel label;
    /**
     * Kombobox a genetikai kodok kilistazasara es kivalasztasra
     */
    JComboBox combobox;

    /**
     * Konstruktor, beallitja a jatekost, kirajzolja az genetikai kodokat es a komboboxot amiben az elkeszitendo genetikai kodot lehet kivalasztani
     * @param ow a jatekos
     */
    public GeneticCodeView(Player ow) {
        ownerPlayer = ow;
        owner = ow.getGeneticCodes();
        label = new JLabel();
        label.setBounds(880, 20, 80, 80);
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/agent_make.png");
        image = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        label.setIcon(icon2);
        MouseListener a = new JavaMouseDeer();
        label.addMouseListener(a);

        /** ComboBox az elkeszitheto genetikai kodok kilistázásához**/
        LinkedList<GeneticCode> geneticCodes = ownerPlayer.getGeneticCodes();
        String geneticCodesString[] = new String[geneticCodes.size()];
        for (int i = 0; i < geneticCodes.size(); i++) {
            geneticCodesString[i] = geneticCodes.get(i).getAgentType();
        }
        combobox = new JComboBox(geneticCodesString);
        combobox.setBounds(780, 20, 100, 20);

    }

    /**
     * Visszadja a comboboxot amiben a genetikai kodokat listazza ki
     * @return
     */
    public JComboBox getCombobox() {
        return combobox;
    }

    /**
     * Visszaadja a labelt amire a grafikus elemek kerulnek ki
     * @return
     */
    public JLabel getLabel() {
        return label;
    }

    public GeneticCodeView(LinkedList<GeneticCode> o, Player p) {
        owner = o;
        ownerPlayer = p;
    }

    /**
     * Visszaadja a jatekosnal levo genetikai kodokat
     */
    public LinkedList<GeneticCode> getGeneticCodes() {
        return ownerPlayer.getGeneticCodes();
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
     * MouseListener ami kezeli a genetikai kodra valo kattintast
     */
    private class JavaMouseDeer implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            String chosentype= (String) combobox.getSelectedItem();
            LinkedList<GeneticCode> gcs=ownerPlayer.getGeneticCodes();
            for(GeneticCode g:gcs)
            {
                if(g.getAgentType().equals(chosentype))
                {
                    ownerPlayer.makeAgent(g);
                }
            }
            Game.getInstance().gc.Update();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
