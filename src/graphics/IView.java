package graphics;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface IView
{
    public JLabel label = new JLabel();

    public default JLabel getLabel()
    {
        return label;
    }
    public void Update();
    public void Event();

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
