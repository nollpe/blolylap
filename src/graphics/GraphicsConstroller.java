package graphics;

import agents.Agent;
import agents.Chorea;
import character.Player;
import equipment.Equipment;
import equipment.Gloves;
import field.Field;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
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
        panel = new JPanel();

        turnOf.addEquipment(new Gloves());
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
            eq.getView().getLabel().setBounds(200 + i * 80, 100, 60, 60);
            i++;

            //equimpemntLabels.add(eq.getView().getLabel());
        }

        //szomszédok tm
        LinkedList<Field> neighbours=turnOf.getLocation().getNeighbours();
        neighbours.add(turnOf.getLocation());
        for(Field f:neighbours)
        {
            views.add( f.getView());
            f.getView().getLabel().setBounds(i*60,i*60,60,60);i++;
        }

        //inventory TODO

        //főzős
        JLabel fozos = new JLabel();
        //fozos.add(new MouseListener());
        // TODO kell mouslistener amire megjelenik egy combobox ami tartalmazza a csinálható ágenseket, ha rákattintasz megcsinálja

        System.out.println(views.size());
        for (IView iv : views) {
            panel.add(iv.getLabel());

            /*Class<? extends IView> aClass = iv.getClass();
            try {
                IView aClass1 = aClass.getDeclaredConstructor(iv.getClass()).newInstance(iv);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            System.out.println(aClass.toString());*/

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
