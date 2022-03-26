package field;

import tester.testerClass;

import java.util.LinkedList;

public class Field
{
    private LinkedList<Field> neighbours;

    public Field()
    {
        testerClass.print();
        this.neighbours=new LinkedList<Field>();
    }

    protected void addNeighbour(Field added)
    {
        testerClass.print();
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
    }

    public void takeLoot()
    {
        testerClass.print();
    }
}
