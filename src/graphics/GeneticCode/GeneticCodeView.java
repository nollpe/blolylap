package graphics.GeneticCode;

import agents.GeneticCode;
import character.Player;
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

    public GeneticCodeView(Player ow)
    {
        ownerPlayer=ow;
        owner=ow.getGeneticCodes();
        label = new JLabel();
        label.setBounds(880,20,80,80);
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/agent_make.png");
        image = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        label.setIcon(icon2);
        MouseListener a=new JavaMouseDeer();
        label.addMouseListener(a);
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

    private class JavaMouseDeer implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            //TODO comboboxban lugro geciben hogy mit tud főzni
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
