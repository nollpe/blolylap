package graphics;

import field.Field;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class FIeldView extends JLabel
{



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
