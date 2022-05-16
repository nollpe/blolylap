package graphics.player;

import character.Player;
import graphics.IView;

import javax.swing.*;
import java.awt.*;

public class PlayerView implements IView {
    Player player;


    public void Update() {

    }

    public void Event() {

    }

    public PlayerView(Player p) {

        player = p;

        //label=new JLabel();
        label.setBounds(470, 240, 60, 120);
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/player.png");
        image = image.getScaledInstance(60, 120, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }

}
