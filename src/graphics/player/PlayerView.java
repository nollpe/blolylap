package graphics.player;

import character.Player;
import graphics.IView;

import javax.swing.*;
import java.awt.*;

public class PlayerView implements IView {
    Player player;
    JLabel label = new JLabel();
    public JLabel getLabel() {
        return label;
    }


    public void Update() {

    }

    public void Event() {

    }


    public PlayerView(Player p) {
        player = p;
        label.setBounds(470, 240, 60, 120);
        String a = ("kepek/"+player.getName()+".png");
        Image image = Toolkit.getDefaultToolkit().getImage(a);
        image = image.getScaledInstance(60, 120, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }

    public void setPos(int x) {
        label.setBounds(x, 240,60,120);
    }
}
