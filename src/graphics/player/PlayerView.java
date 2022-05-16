package graphics.player;

import character.Player;
import field.Field;
import graphics.fields.FIeldView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayerView extends JLabel
{
    JavaMouseDeer ml;
    Player player;

    public void Update()
    {

    }

    public void Event()
    {

    }

    public PlayerView(Rectangle r, String ImageName,Player p)
    {

        player=p;
        ml= new JavaMouseDeer();
        setBounds(r);

        setBounds(r);
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/"+ImageName);
        image = image.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        this.setIcon(icon);
    }




    static class JavaMouseDeer implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            //valami
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e){}
        @Override
        public void mouseExited(MouseEvent e){}
        @Override
        public void mouseReleased(MouseEvent e){}
    }
}
