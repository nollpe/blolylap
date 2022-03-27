package field;

import equipment.Bag;
import equipment.Equipment;
import equipment.Gloves;
import equipment.Labcoat;
import field.Field;
import tester.testerClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Safehouse extends Field
{
    private Equipment stored;

    public Safehouse()
    {
        super();
        testerClass.print();
    }

    public void showLoot()
    {
        testerClass.print();
    }

    public void tick()
    {
        testerClass.print();
        super.tick();
    }

    public void takeLoot()
    {
        testerClass.print();
    }

    public void takeEquipment(Equipment e)
    {
        testerClass.print();
        //ez miert void?
    }

    public void setStored(Equipment newStored) {
        stored =newStored;
    }

    public Equipment getStored() {
        return stored;
    }
}
