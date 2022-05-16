package graphics.fields;

import field.Field;
import graphics.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class FIeldView implements IView
{
    JavaMouseDeer ml;
    Field field;

    public FIeldView(Rectangle r,String ImageName,Field f)
    {
        ml= new JavaMouseDeer();
        label.setBounds(r);
        field=f;

        label.setBounds(r);
        Image image = Toolkit.getDefaultToolkit().getImage(ImageName);
        image = image.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }

    @Override
    public void Update() {

    }

    @Override
    public void Event() {

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
