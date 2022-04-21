package game;

import agents.*;
import character.Player;
import equipment.*;
import field.*;
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
        AllGeneticCodes = new GeneticCode[4];
        allPlayers = new LinkedList<Player>();
        city = new City();
        vezerles();

    }

    //input a protohoz csak ahoz kell amugy meg actionlistenerek lesznek ezek helyett
    //es igen majd kibaszom egy külön függvénybe

    //region vezerles
    LinkedList<Field> fields=new LinkedList<>();
    LinkedList<Warehouse> warehouses=new LinkedList<>();
    LinkedList<Safehouse> safehouses=new LinkedList<>();
    LinkedList<Laboratory> laboratories=new LinkedList<>();


    //megkap egy kétkarakteres stringet pl:F2 es erre visszaadja az ennek megfelelő mezőt, pl: erre a 2 es számú fieldet
    public Field vezerles_determineField(String fieldName)
    {
        int index = Integer.parseInt(String.valueOf(fieldName.charAt(1)));
        switch(fieldName.charAt(0))
        {
            case('f'):
                return fields.get(index);
            case('s'):
                return safehouses.get(index);
            case('w'):
                return warehouses.get(index);
            case('l'):
                return laboratories.get(index);
            default:
                return null;
        }
    }

    public Equipment vezerles_determineLoot(String eqName)
    {
        switch(eqName)
        {
            case("axe"):
                return new Axe();
            case("bag"):
                return new Bag();
            case("gloves"):
                return new Gloves();
            case("labcoat"):
                return new Labcoat();
            default:
                return null;
        }
    }

    public Agent vezerles_determineAgent(String agentName)
    {
        switch(agentName)
        {
            case("chorea"):
                return new Chorea();
            case("Bear"):
                return new Bear();
            case("Forget"):
                return new Forget();
            case("Invulnerable"):
                return new Invulnerable();
            case("Paralyzing"):
                return new Paralyzing();
            default:
                return null;

        }
    }

    public void vezerles_addLoot(String[] split)
    {
        Field ribancoskifli=vezerles_determineField(split[1]);
        switch(split[1].charAt(0))
        {
            case('s'):
                safehouses.get(Integer.parseInt(String.valueOf(split[1].charAt(1)))).setStored(vezerles_determineLoot(split[2]));
                break;
            case('w'):
                if(split[2].equals("aminoacid"))
                {
                    warehouses.get(Integer.parseInt(String.valueOf(split[1].charAt(1)))).getStored().addAminoAcid(Integer.parseInt(String.valueOf(split[3])));
                }
                else if(split[2].equals("nucleotide"))
                {
                    warehouses.get(Integer.parseInt(String.valueOf(split[1].charAt(1)))).getStored().addNucleotide(Integer.parseInt(String.valueOf(split[3])));
                }
                break;
            case('l'):
                //TODO: meg kéne oldani hogy mindegyik genetikai kód annyi ágenst kérjen amennyit meghatároztunk
                laboratories.get(Integer.parseInt(String.valueOf(split[1].charAt(1)))).init(new GeneticCode(vezerles_determineAgent(split[2]),2,2));
            default:
                return;
        }
    }

    public void vezerles()
    {
        String input = "ribancos kifli";
        while (input != "exit") {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (input) {
                case ("createmap"):
                    String[] split = new String[1];//placeholder
                    while (input != "done") {
                        try {
                            input = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        split = input.split(" ");
                    }
                    int temp;
                    switch (split[0]) {
                        case("Field"):
                            temp=Integer.parseInt(split[1]);
                            for(int i=0;i<temp;i++)
                            {
                                fields.add(new Field());
                            }
                            break;
                        case("Laboratory"):
                            temp=Integer.parseInt(split[1]);
                            for(int i=0;i<temp;i++)
                            {
                                laboratories.add(new Laboratory());
                            }
                            break;
                        case("Warehouse"):
                            temp=Integer.parseInt(split[1]);
                            for(int i=0;i<temp;i++)
                            {
                                warehouses.add(new Warehouse());
                            }
                            break;
                        case("Safehouse"):
                            temp=Integer.parseInt(split[1]);
                            for(int i=0;i<temp;i++)
                            {
                                safehouses.add(new Safehouse());
                            }
                            break;
                        case("addneighbours"):
                            city.makeNeighbours(vezerles_determineField(split[1]),vezerles_determineField(split[2]));
                            break;
                        case("addloot"):
                            vezerles_addLoot(split);
                            break;
                        case("spawnplayer"):
                            Player tempPlayer=new Player(split[2]);
                            Field location=vezerles_determineField(split[1]);
                            location.enter(tempPlayer);
                            tempPlayer.setLocation(location);

                            break;
                    }
            }

        }

    }
    //endregion

    public void Tick() {

        for (int i = 0; i < allPlayers.size(); i++) {
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
     *
     * @param player a játékos akir le akarunk rakni
     * @param field  a mező ahová le akarjuk rakni
     */
    public void spawnPlayer(Player player, Field field) {
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
