package graphics;

import field.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GraphicsConstroller
{
    Set<IControl> controllers;
    Set<IView> views;

    //region adderek removerek

    public void addView(IView e)
    {
        views.add(e);
    }

    public void addController(IControl c)
    {
        controllers.add(c);
    }

    public void removeView(IView e)
    {
        views.remove(e);
    }

    public void removeController(IControl c)
    {
        controllers.remove(c);
    }

    //endregion

    public GraphicsConstroller()
    {
        controllers=new HashSet<IControl>();
        views=new HashSet<IView>();
        frame=new JFrame("viribirigeci");
        //views=new endTurnButton();
    }

    JFrame frame;
    JPanel panel;

    public void Update()
    {
        frame.getContentPane().removeAll();
        panel=new JPanel(){@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
        };
        /*for(IView iv:views)
        {
            iv.Update();
        }*/
        panel.setLayout(null);

        for(IView iv:views)
        {
            panel.add(iv.getLabel());

        }

        frame.setSize(1000,600);
        frame.add(panel);


        frame.setVisible(true);
    }

    public void Create()
    {

    }

    //ahogy elképzelem:
    //ezt hívja meg egy field ha rákattintanak
    public void fieldClicked(Field f)
    {
        //igazából itt "kijelölté" válik a field
    }





}
