package field;

import character.Player;
import tester.testerClass;

import java.util.LinkedList;
import java.util.Random;

public class City {
    private LinkedList<Field> map;


    public City() {
        testerClass.print();
        map = null;

    }

    public void setMap(LinkedList<Field> ll) {
        map = ll;
    }

    private void makeNeighbours(Field f1, Field f2, Direction dir) {
        f1.addNeighbour(f2, dir);
        f2.addNeighbour(f1, dir.oppositeDirection());
    }

    public void tick() {
        testerClass.print();
        for (Field f : map) {
            f.tick();
        }
    }

    public void showCity() {
        testerClass.print();
    }

    /**
     * egyelőre legyen egy egyszerű 4 elemből álló teljes gráf amiben mindenféle field létezik egyszer
     * véletlenül sem azért mert még foggalmam sincs hogy hogyan kéne kinéznie
     * vagy hogyan kéne megcsinálni...
     * ha van ötlet pls mindjátok
     * ja igen és nemtudom mondanom kell-e
     * de kurvaronda
     * kettőspont nagyDé
     * ...
     * <p>
     * zsolti: mivel négyzetrácsos a map, ezért teljes gráf már nem lehet, szóval egy kicsit megváltoztattam
     */
    public void generateMap() {
        map = new LinkedList<>();

        //létrehozzuk a fieldeket
        Field basicField = new Field();
        Laboratory laboratory = new Laboratory();
        Safehouse safehouse = new Safehouse();
        Warehouse warehouse = new Warehouse();

        //belerakjuk a mappba
        map.add(basicField);
        map.add(laboratory);
        map.add(safehouse);
        map.add(warehouse);

        //szomszédok lettek
        makeNeighbours(basicField, laboratory, Direction.NORTH);
        makeNeighbours(basicField, safehouse, Direction.WEST);

        makeNeighbours(laboratory, warehouse, Direction.WEST);
        makeNeighbours(safehouse, warehouse, Direction.NORTH);

        testerClass.print();
    }

    public Field spawnPlayer(Player character) {
        Random rand = new Random();
        int randint = rand.nextInt(map.size());
        map.get(randint).enter(character);
        return map.get(randint);
    }
}
