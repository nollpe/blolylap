package game;

import agents.GeneticCode;
import character.Player;
import field.City;
import field.Field;
import tester.testerClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Game {
    private Timer timer;
    private City city;
    private GeneticCode[] AllGeneticCodes;
    private LinkedList<Player> allPlayers;

    //privát konstruktor

    /**
     * ide rakom be a menüt is ami a bemeneti nyelvet kezeli(kinda)
     */
    private Game() {
        AllGeneticCodes=new GeneticCode[4];
        allPlayers=new LinkedList<Player>();
        city=new City();
        String input="ribancos kifli";
        while(input!="exit")
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch(input)
            {
                case("createmap"):
                    String[] split=new String[1];//placeholder
                    while(input!="done")
                    {
                        try {
                            input = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        split=input.split(" ");
                    }
                    switch (split[0])
                    {
                        //TODO: a különböző commandok lehet külön függvényben kéne
                    }
            }
        }

    }

    public void Tick() {

        for(int i=0;i<allPlayers.size();i++)
        {
            allPlayers.get(i).tick();
        }
        city.tick();
    }

    //ebben tároljuk az egyedet
    private static Game singleInstance = null;

    //ezzel tudjuk lekérni az egyedet
    public static Game getInstance() {
        testerClass.print();
        //ha még nem létezik létrehozzuk
        if (singleInstance == null)
            singleInstance = new Game();

        return singleInstance;
    }

    /**
     * Lerak egy játékost a pályára
     *
     * @param character a játékos akit le akarunk rekni a pályára
     * @return A mező ahova a játékos került
     */
    public Field spawnPlayer(Player character) {
        return city.spawnPlayer(character);
    }


    /**
     * Lerak egy játékost a pályára
     * @param player a játékos akir le akarunk rakni
     * @param field a mező ahová le akarjuk rakni
     */
    public void spawnPlayer(Player player,Field field)
    {
        field.enter(player);
    }

    /**
     * Beállítja a játékhoz tartoó várost
     *
     * @param c A várost, ami a játékhoz tartozik.
     */
    public void setCity(City c) {
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
