package graphics;

import agents.Agent;
import character.Player;
import equipment.Equipment;
import field.Field;
import graphics.GeneticCode.GeneticCodeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GraphicsConstroller {
    Set<IControl> controllers;
    Set<IView> views;
    Player turnOf=new Player();

    public Player getTurnOf() {
        return turnOf;
    }

    public void setTurnOf(Player turnOf) {
        this.turnOf = turnOf;
    }

    //region adderek removerek

    public void addView(IView e) {
        views.add(e);
    }

    public void addController(IControl c) {
        controllers.add(c);
    }

    public void removeView(IView e) {
        views.remove(e);
    }

    public void removeController(IControl c) {
        controllers.remove(c);
    }

    //endregion

    public GraphicsConstroller() {
        controllers = new HashSet<IControl>();
        views = new HashSet<IView>();
        frame = new JFrame("viribirigeci");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //views=new endTurnButton();
    }

    JFrame frame;
    JPanel panel;


    public void Update()
    {
        panel=new JPanel(){@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int sides=turnOf.getLocation().getNeighbours().size();

            JLabel label=new JLabel();
            label.setBounds(0,0,1000,600);
            String s="kepek/playerx.png";
            String nev = s.substring(0,12)+((char)(sides+48))+s.substring(13);
            Image image = Toolkit.getDefaultToolkit().getImage(nev);
            image = image.getScaledInstance(1000,600,Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            label.setIcon(icon);
            this.add(label);

        }
        };

        panel.setLayout(null);

        //equipmentek
        LinkedList<JLabel> equimpemntLabels=new LinkedList<>();
        for(Equipment eq:turnOf.getStored())
        {
            //equimpemntLabels.add(eq.getView().getLabel());
        }
        //castolható shitek
        LinkedList<JLabel> castableLabels=new LinkedList<>();
        for(Agent a:turnOf.getCastableAgents())
        {
            //CastableLabels.add(a.);//TODO
        }
        //szomszédok tm
        LinkedList<Label> neighbours=new LinkedList<>();
        for(Field f:turnOf.getLocation().getNeighbours())
        {
            //neighbours.add(f.getView());
        }

        //inventory TODO

        //főzős
        JLabel fozos=new JLabel();
        //fozos.add(new MouseListener());
        // TODO kell mouslistener amire megjelenik egy combobox ami tartalmazza a csinálható ágenseket, ha rákattintasz megcsinálja




        /*for(IView iv:views)
        {
            panel.add(iv.getLabel());

        }*/

        frame.setSize(1000, 600);
        frame.add(panel);


        frame.setVisible(true);
    }

    public void Create() {

    }

    //ahogy elképzelem:
    //ezt hívja meg egy field ha rákattintanak
    public void fieldClicked(Field f) {
        //igazából itt "kijelölté" válik a field
    }


}
