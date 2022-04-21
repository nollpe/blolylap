package field;

import character.Player;
import field.Field;
import game.Timer;
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

    /**
     * Beállít két mezőt szomszédosnak
     *
     * @param f1 az egyik mező
     * @param f2 a másik mező
     */
    private void makeNeighbours(Field f1, Field f2) {
        f1.addNeighbour(f2);
        f2.addNeighbour(f1);
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

    /**
     * generál egy 4 mezőből álló pályát amiben mindenféle mező megjelenik és mindegyik szomszédja mindegyiknek
     */
    public void generateMap() {
        /*
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
        */
    }

    /**
     * Egy karaktert lerak a pályára egy random helyre
     *
     * @param character a player akit le kell rakni a pályán
     * @return a mező ahova lerakta
     */
    public Field spawnPlayer(Player character) {
        Random rand = new Random();
        int randint = rand.nextInt(map.size());
        map.get(randint).enter(character);
        return map.get(randint);
    }

}
