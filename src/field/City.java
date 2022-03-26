package field;

import field.Field;
import game.Timer;
import tester.testerClass;

import java.util.LinkedList;

public class City
{
    private LinkedList<Field> map;

    /*
    * egyenlőre legyen egy egyszerű 4 elemből álló teljes gráf amiben mindenféle field létezik egyszer
    * véletlenül sem azért mert még foggalmam sincs hogy hogyan kéne kinéznie
    * vagy hogyan kéne megcsinálni...
    * ha van ötlet pls mindjátok
    * ja igen és nemtudom mondanom kell-e
    * de kurvaronda
    * kettőspont nagyDé
    * ...
    *  */
    public City()
    {
        testerClass.print();
        map=new LinkedList<Field>();

        //létrehozzuk a fieldeket
        Field basicField=new Field();
        Laboratory laboratory= new Laboratory();
        Safehouse safehouse= new Safehouse();
        Warehouse warehouse = new Warehouse();

        //belerakjuk a mappba
        map.add(basicField);
        map.add(laboratory);
        map.add(safehouse);
        map.add(warehouse);

        //szomszédok lettek
        makeNeighbours(basicField,laboratory);
        makeNeighbours(basicField,safehouse);
        makeNeighbours(basicField,warehouse);
        makeNeighbours(laboratory,safehouse);
        makeNeighbours(laboratory,warehouse);
        makeNeighbours(safehouse,warehouse);


    }

    private void makeNeighbours(Field f1,Field f2)
    {
        f1.addNeighbour(f2);
        f2.addNeighbour(f1);
    }

    public void tick()
    {
        testerClass.print();
        for(Field f:map)
        {
            f.tick();
        }
    }

    public void showCity()
    {
        testerClass.print();
    }

    public void generateMap()
    {
        testerClass.print();
    }
}
