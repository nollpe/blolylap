package game;

import agents.GeneticCode;
import character.Player;
import field.City;
import field.Field;
import tester.testerClass;

public class Game
{
    private Timer timer;
    private City city;
    private GeneticCode[] AllGeneticCodes;

    //privát konstruktor
    private Game()
    {

    }

    public void Tick()
    {
        testerClass.print();
        city.tick();
    }

    //ebben tároljuk az egyedet
    private static Game singleInstance=null;

    //ezzel tudjuk lekérni az egyedet
    public static Game getInstance()
    {
        testerClass.print();
        //ha még nem létezik létrehozzuk
        if (singleInstance == null)
            singleInstance = new Game();

        return singleInstance;
    }

    /**
     * Lerak egy játékost a pályára
     * @param character a játékos akit le akarunk rekni a pályára
     * @return A mező ahova a játékos került
     */
    public Field spawnPlayer(Player character)
    {
        return city.spawnPlayer(character);
    }

    /**
     * Beállítja a játékhoz tartoó várost
     * @param c A várost, ami a játékhoz tartozik.
     */
    public void setCity(City c){
        testerClass.print();
        city = c;
    }
}
/*
 Azért, hogy singleton legyen:
 privát a konstruktora,
 egy statickus változóban tároljuk az egyetlen egyedet és azt udjuk lekérdezni egy szintén statikus függvénnyel
 így nem tudunk létrhozni egyedet, hanem csak a class tud ami csak egyet fog
 a getInstance függvénnyel lehet elérni

 */
