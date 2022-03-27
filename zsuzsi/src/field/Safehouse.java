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
    private LinkedList<Equipment> stored;

    public Safehouse()
    {
        super();
        testerClass.print();
        stored=new LinkedList<Equipment>();
    }

    public void showLoot()
    {
        testerClass.print();
    }

    public void tick()
    {
        super.tick();
        System.out.println("melyik generálódjon?");
        System.out.println("1 Gloves:");
        System.out.println("2 Labcoat");
        System.out.println("3 Bag");

        int chosen=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            chosen=Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //mAgAS sZInTű nYElv
        //chosen=getchar();

        switch(chosen)
        {
            case(1):
                stored.add(new Gloves());
                break;
            case(2):
                stored.add(new Labcoat());
                break;
            case(3):
                stored.add(new Bag());
                break;
            default:

                break;
        }

        testerClass.print();
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
}
