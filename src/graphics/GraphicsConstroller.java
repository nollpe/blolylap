package graphics;

import agents.Chorea;
import character.Player;
import equipment.Equipment;
import equipment.Gloves;
import equipment.Labcoat;
import field.Field;
import graphics.GeneticCode.GeneticCodeView;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GraphicsConstroller {
    Set<IControl> controllers;
    Set<IView> views;
    Player turnOf = new Player();

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


    public void Update() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

            }

        };

        turnOf.addEquipment(new Gloves());
        turnOf.addEquipment(new Labcoat());
        turnOf.addCastableAgent(new Chorea(turnOf));

        //háttér betöltése
        int sides = turnOf.getLocation().getNeighbours().size();

        JLabel backgroung = new JLabel();
        backgroung.setBounds(0, 0, 1000, 600);
        String s = "kepek/fieldx.png";
        String nev = s.substring(0, 11) + ((char) (sides + 48)) + s.substring(12);
        Image image = Toolkit.getDefaultToolkit().getImage(nev);
        image = image.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        backgroung.setIcon(icon);


        panel.setLayout(null);
        int i = 1;

        //equipmentek


        for (Equipment eq : turnOf.getStored()) {

            views.add(eq.getView());
            eq.getView().getLabel().setBounds(20, 40+80*i, 60, 60);

            i++;

            //equimpemntLabels.add(eq.getView().getLabel());
        }

        //szomszédok tm

        LinkedList<Field> neighbours=turnOf.getLocation().getNeighbours();
        i=0;
        double theta = 2 * Math.PI / sides;

        for(Field f:neighbours)
        {
            double x = Math.cos(theta * i-Math.PI/(sides*sides));
            double y = Math.sin(theta * i-Math.PI/(sides*sides));
            views.add( f.getView());
            f.getView().getLabel().setBounds(500+(int)(250*x),300+(int)(200*y),60,60);i++;

        }

        //főzősmcs
        GeneticCodeView makeAgent=new GeneticCodeView(turnOf);
        panel.add(makeAgent.getLabel());
            //fozosmcs hez combobox
            panel.add(makeAgent.getCombobox());

        //lootview
        if(turnOf.getLocation().getLootView()!=null)
        {
            JLabel tempforlootview=turnOf.getLocation().getLootView().getLabel();
            if(tempforlootview!=null)
            {
                tempforlootview.setBounds(460,360,60,60);
                panel.add(tempforlootview);
            }
        }


        //inventory TODO

        //add to panel
        for (IView iv : views) {
            panel.add(iv.getLabel());

        }
        panel.add(backgroung);

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
