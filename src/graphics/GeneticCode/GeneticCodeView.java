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

public class GeneticCodeView implements IView {
    GeneticCodeControll control;
    Player ownerPlayer;
    LinkedList<GeneticCode> owner;
    JLabel label;
    JComboBox combobox;

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

        //combobox.setSelectedIndex(0);
        //?? ez igy eleg?
    }

    public JComboBox getCombobox() {
        return combobox;
    }

    public JLabel getLabel() {
        return label;
    }

    public GeneticCodeView(LinkedList<GeneticCode> o, Player p) {
        owner = o;
        ownerPlayer = p;
    }

    public LinkedList<GeneticCode> getGeneticCodes() {
        return ownerPlayer.getGeneticCodes();
    }

    @Override
    public void Update() {

    }

    @Override
    public void Event() {

    }

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
            //Game.getInstance().gc.Update();
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
