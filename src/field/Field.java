package field;

import character.Character;
import tester.testerClass;
import java.util.LinkedList;

public class Field
{
    private LinkedList<Field> neighbours;
    private LinkedList<Character> inhabitants;

    public Field()
    {
        testerClass.print();
        this.neighbours=new LinkedList<Field>();
        this.inhabitants=new LinkedList<Character>();
    }

    protected void addNeighbour(Field added)
    {
        neighbours.add(added);
    }

    public void enter(Character c)
    {
        testerClass.print();
    }

    public void leave(Character c)
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
        for(Character character:inhabitants)
        {
            character.tick();
        }
    }

    public void takeLoot()
    {
        testerClass.print();
    }
}
