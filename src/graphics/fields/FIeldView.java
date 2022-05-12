package graphics.fields;

import field.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class FIeldView extends JLabel
{
    JavaMouseDeer ml;
    Field field;

    public FIeldView(Rectangle r,String ImageName,Field f)
    {
        ml= new JavaMouseDeer();
        setBounds(r);
        field=f;

        setBounds(r);
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/"+ImageName);
        image = image.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        this.setIcon(icon);
    }


    //lesz szükségünk egy mouselistenerre mindenképp úgyhogy ezt csak itthagyom
    //minden egyes kattintható dolognak kéne egy ilyen belső class
    //(a neve marad.)
    static class JavaMouseDeer implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            //meghívja a field (vagy fieldView nemtudom) megfelelő függvényét
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
