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
        map = new LinkedList<Field>();

    }

    public void setMap(LinkedList<Field> ll) {
        map = ll;
    }

    public LinkedList<Field> getMap() {
        return map;
    }

    /**
     * Beállít két mezőt szomszédosnak
     *
     * @param f1 az egyik mező
     * @param f2 a másik mező
     */
    public void makeNeighbours(Field f1, Field f2) {
        if (f1 == null || f2 == null) {
            System.out.println("null valamelyik");
            return;
        }
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
     * szóval majd lesz egy ilyen amikor kell
     * random pályát fog csinálni
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
        makeNeighbours(basicField, laboratory);
        makeNeighbours(basicField, safehouse);
        makeNeighbours(basicField, warehouse);

        makeNeighbours(laboratory, warehouse);
        makeNeighbours(safehouse, warehouse);

        makeNeighbours(safehouse, laboratory);

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
