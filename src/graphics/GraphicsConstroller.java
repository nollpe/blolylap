package graphics;


import agents.Agent;
import agents.Chorea;
import agents.Forget;
import agents.GeneticCode;
import character.Player;
import equipment.Equipment;
import field.Field;
import game.Game;
import graphics.GeneticCode.GeneticCodeView;
import graphics.inventory.InventoryView;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.locks.StampedLock;

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
        views.clear();
        frame.getContentPane().removeAll();
        panel = new JPanel();

        for (Player player : Game.getInstance().getAllPlayers()) {
            views.add(player.getView());
        }

        //TODO kivenni xd
        turnOf.addGeneticCode(new GeneticCode(new Chorea(turnOf),2,2));
        turnOf.addGeneticCode(new GeneticCode(new Forget(turnOf),3,3));
        turnOf.getInventory().addAminoAcid(5);
        turnOf.getInventory().addNucleotide(5);
        //eddig

        //háttér betöltése
        int sides = turnOf.getLocation().getNeighbours().size();

        JLabel background = new JLabel();
        background.setBounds(0, 0, 1000, 600);
        String s = "kepek/fieldx.png";
        String nev = s.substring(0, 11) + ((char) (sides + 48)) + s.substring(12);
        Image image = Toolkit.getDefaultToolkit().getImage(nev);
        image = image.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        background.setIcon(icon);


        panel.setLayout(null);
        int i = 1;

        //equipmentek
        for (Equipment eq : turnOf.getStored()) {

            views.add(eq.getView());
            eq.getView().getLabel().setBounds(20, 40 + 80 * i, 60, 60);

            i++;

            //equimpemntLabels.add(eq.getView().getLabel());
        }

        //szomszédok tm


        LinkedList<Field> neighbours = turnOf.getLocation().getNeighbours();
        i = 0;

        double theta = 2 * Math.PI / sides;

        for (Field f : neighbours) {
            double x = Math.cos(theta * i - Math.PI / (sides * sides));
            double y = Math.sin(theta * i - Math.PI / (sides * sides));
            views.add(f.getView());
            f.getView().getLabel().setBounds(500 + (int) (250 * x), 300 + (int) (200 * y), 60, 60);
            i++;

        }

        //főzősmcs
        GeneticCodeView makeAgent = new GeneticCodeView(turnOf);
        panel.add(makeAgent.getLabel());
        //fozosmcs hez combobox
        panel.add(makeAgent.getCombobox());

        //lootview
        if (turnOf.getLocation().getLootView() != null) {
            JLabel tempforlootview = turnOf.getLocation().getLootView().getLabel();
            if (tempforlootview != null) {
                tempforlootview.setBounds(460, 360, 60, 60);
                panel.add(tempforlootview);
            }
        }

        //castolható agensek
        LinkedList<Agent> csa=turnOf.getCastableAgents();
        i=0;
        for(Agent tempagent:csa)
        {
            if(tempagent==null)
            {
                System.out.println("tempagent==null");
            }
            if(tempagent.getView()==null)
            {
                System.out.println("tempagent.getView()==null");
            }
            JLabel templb= tempagent.getView().getLabel();
            panel.add(templb);
            templb.setBounds(920,200+i*80,60,60);
            i++;
        }


        //inventory
        InventoryView inventoryView = new InventoryView(turnOf, panel);

        //add to panel
        for (IView iv : views) {
            panel.add(iv.getLabel());

        }
        panel.add(background);

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
