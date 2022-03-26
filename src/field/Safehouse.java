package field;

import equipment.Equipment;
import field.Field;
import tester.testerClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        super.tick();
        System.out.println("1 generate:");
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

                break;
            case(2):

                break;
            case(3):

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
