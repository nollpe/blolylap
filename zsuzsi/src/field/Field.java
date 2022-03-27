package field;

import character.Player;
import tester.testerClass;
import java.util.LinkedList;

public class Field
{
    private LinkedList<Field> neighbours;
    private LinkedList<Player> inhabitants;

    public Field()
    {
        testerClass.print();
        this.neighbours=new LinkedList<Field>();
        this.inhabitants=new LinkedList<Player>();
    }

    protected void addNeighbour(Field added)
    {
        neighbours.add(added);
    }

    public void enter(Player c)
    {
        inhabitants.add(c);
        testerClass.print();
    }

    public void leave(Player c)
    {
        testerClass.print();
    }

    public void showLoot()
    {
        testerClass.print();
    }

    public void tick()
    {
        testerClass.print();
        for(Player character:inhabitants)
        {
            character.tick();
        }
    }

    public void takeLoot()
    {
        testerClass.print();
    }

    public LinkedList<Player> getInhabitants(){
        testerClass.print();
        return inhabitants;
    }
}
