package field;

import agents.*;
import character.Player;
import equipment.BrokenAxe;
import equipment.Gloves;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class City {
    private LinkedList<Field> map;


    public City() {

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
        if (f1 == null || f2 == null || f1.getNeighbours().size()>=6 || f2.getNeighbours().size()>=6) {

            return;
        }
        f1.addNeighbour(f2);
        f2.addNeighbour(f1);
    }

    public void tick() {

        for (Field f : map) {
            f.tick();
        }
    }

    public void showCity() {

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
    public void generateMap(int players) {

        map = new LinkedList<>();

        //a 4 fajta lab ami kel (+majd bearlab de hát igen)
        Laboratory forgetlab = new Laboratory();
        forgetlab.init(new GeneticCode(new Forget(), 2, 2));

        Laboratory chorealab=new Laboratory();
        chorealab.init(new GeneticCode(new Chorea(), 2, 2));

        Laboratory involab=new Laboratory();
        involab.init(new GeneticCode(new Invulnerable(), 2, 2));

        Laboratory paralab=new Laboratory();
        paralab.init(new GeneticCode(new Paralyzing(), 2, 2));

        map.add(forgetlab);
        map.add(chorealab);
        map.add(involab);
        map.add(paralab);

        //a többiböl playerek száma szerint
        //fieldből
        for(int i=0;i<players*2;i++)
        {
            map.add(new Field());
        }
        //Safehouse és warehouse
        for(int i=0;i<players/2+2;i++)
        {
            map.add(new Safehouse());
            map.add(new Warehouse());
        }
        for(int j=0;j<2;j++)
        {
            //összekeverjük
            Collections.shuffle(map);

            //minenkinek legyen legalább egy szomszédja
            //ezért az utánna és előtte lévővel szomszédosak lesznek, ami ugye random mert összekevert
            makeNeighbours(map.getFirst(),map.getLast());
            for(int i=0;i<map.size()-1;i++)
            {
                makeNeighbours(map.get(i),map.get(i+1));
            }
        }
        Random rand=new Random();
        for(int i=0;i<players;i++)
        {
            makeNeighbours(map.get(rand.nextInt(map.size())),map.get(rand.nextInt(map.size())));
        }

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
