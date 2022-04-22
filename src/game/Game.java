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

    //region vezerles

    // a pálya előkészítéséhez vannak ezek a változók
    LinkedList<Field> fields = new LinkedList<>();
    LinkedList<Warehouse> warehouses = new LinkedList<>();
    LinkedList<Safehouse> safehouses = new LinkedList<>();
    LinkedList<Laboratory> laboratories = new LinkedList<>();


    //megkap egy kétkarakteres stringet pl:F2 es erre visszaadja az ennek megfelelő mezőt, pl: erre a 2 es számú fieldet

    /**
     * mező neve -> a mező
     *
     * @param fieldName egy mező neve <típus><szám>
     * @return a mező amire referáltunk
     */
    public Field vezerles_determineField(String fieldName) {
        int index = Integer.parseInt(String.valueOf(fieldName.charAt(1)));
        switch (fieldName.charAt(0)) {
            case ('f'):
                return fields.get(index);
            case ('s'):
                return safehouses.get(index);
            case ('w'):
                return warehouses.get(index);
            case ('l'):
                return laboratories.get(index);
            default:
                return null;
        }
    }

    /**
     * bézikly felszerelésnév -> felszerelés
     *
     * @param eqName a felszaerelés neve amit a felhasználó adott meg
     * @return a felszerelést
     */
    public Equipment vezerles_determineLoot(String eqName) {
        switch (eqName) {
            case ("axe"):
                return new Axe();
            case ("bag"):
                return new Bag();
            case ("gloves"):
                return new Gloves();
            case ("labcoat"):
                return new Labcoat();
            default:
                return null;
        }
    }

    /**
     * lényegében ágensnév -> ágens
     *
     * @param agentName az ágens neve, ezt a felhasználó adja meg
     * @return azt az ágenst amit a felhasználó kért
     */
    public Agent vezerles_determineAgent(String agentName) {
        switch (agentName) {
            case ("chorea"):
                return new Chorea();
            case ("Bear"):
                return new Bear();
            case ("Forget"):
                return new Forget();
            case ("Invulnerable"):
                return new Invulnerable();
            case ("Paralyzing"):
                return new Paralyzing();
            default:
                return null;

        }
    }

    /**
     * egy mezőhöz hozzáadunk egy lootot
     *
     * @param split az inputcommand argumentumokkal, szavanként szétválasztva
     */
    public void vezerles_addLoot(String[] split) {
        switch (split[1].charAt(0)) {
            case ('s'):
                safehouses.get(Integer.parseInt(String.valueOf(split[1].charAt(1)))).setStored(vezerles_determineLoot(split[2]));
                break;
            case ('w'):
                if (split[2].equals("aminoacid")) {
                    warehouses.get(Integer.parseInt(String.valueOf(split[1].charAt(1)))).getStored().addAminoAcid(Integer.parseInt(String.valueOf(split[3])));
                } else if (split[2].equals("nucleotide")) {
                    warehouses.get(Integer.parseInt(String.valueOf(split[1].charAt(1)))).getStored().addNucleotide(Integer.parseInt(String.valueOf(split[3])));
                }
                break;
            case ('l'):
                //TODO: meg kéne oldani hogy mindegyik genetikai kód annyi ágenst kérjen amennyit meghatároztunk
                laboratories.get(Integer.parseInt(String.valueOf(split[1].charAt(1)))).init(new GeneticCode(vezerles_determineAgent(split[2]), 2, 2));
            default:
                return;
        }
    }

    public void vezerles_playerCommands() {
        //TODO:ez a geci maj playerturn ami valójába na player tickje ami asszem nem az én dolgom
    }

    /**
     * a playerhez hozzáad egy felszerelést vagy ágenst vagy alapanyagot
     *
     * @param split az inputcommand argumentumokkal, szavanként szétválasztva
     */
    public void vezerles_playerAdd(String[] split) {
        for (Player p : allPlayers) {
            if (p.getName().equals(split[0])) {
                Equipment Eqtemp = vezerles_determineLoot(split[2]);
                if (Eqtemp != null) {
                    p.addEquipment(Eqtemp);
                    return;
                }
                Agent Agtemp = vezerles_determineAgent(split[2]);
                if (Agtemp != null) {
                    if (split[3].equals("active")) {
                        p.addActiveAgent(Agtemp);
                    } else if (split[3].equals("castable")) {
                        p.addCastableAgent(Agtemp);
                    }
                    return;
                }
                if (split[2].equals("aminoacid")) {
                    p.getInventory().addAminoAcid(Integer.parseInt(split[3]));
                } else if (split[2].equals("nucleotide")) {
                    p.getInventory().addNucleotide(Integer.parseInt(split[3]));
                }
                return;
            }
        }
    }

    public void vezerles() {
        String input = "ribancos kifli";
        while (!input.equals("exit")) {
            String[] split = new String[1];//placeholder a new String
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            split = input.split(" ");
            switch (split[0]) {
                case ("createmap"):
                    while (input != "done") {
                        try {
                            input = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        split = input.split(" ");

                        int temp;
                        switch (split[0]) {
                            case ("field"):
                                temp = Integer.parseInt(split[1]);
                                for (int i = 0; i < temp; i++) {
                                    fields.add(new Field());
                                }
                                break;
                            case ("laboratory"):
                                temp = Integer.parseInt(split[1]);
                                for (int i = 0; i < temp; i++) {
                                    laboratories.add(new Laboratory());
                                }
                                break;
                            case ("warehouse"):
                                temp = Integer.parseInt(split[1]);
                                for (int i = 0; i < temp; i++) {
                                    warehouses.add(new Warehouse());
                                }
                                break;
                            case ("safehouse"):
                                temp = Integer.parseInt(split[1]);
                                for (int i = 0; i < temp; i++) {
                                    safehouses.add(new Safehouse());
                                }
                                break;
                            case ("addneighbours"):
                                city.makeNeighbours(vezerles_determineField(split[1]), vezerles_determineField(split[2]));
                                break;
                            case ("addloot"):
                                vezerles_addLoot(split);
                                break;
                            case ("spawnplayer"):
                                Player tempPlayer = new Player(split[2]);
                                Field location = vezerles_determineField(split[1]);
                                location.enter(tempPlayer);
                                tempPlayer.setLocation(location);
                                break;
                            default:
                                vezerles_playerAdd(split);
                                break;
                        }

                    }
                    LinkedList<Field> map = new LinkedList<>();
                    map.addAll(0, fields);
                    map.addAll(0, warehouses);
                    map.addAll(0, safehouses);
                    map.addAll(0, laboratories);
                    break;
                case ("playerturn"):
                    for (Player p : allPlayers) {
                        if (p.getName().equals(split[1])) {
                            p.vezerles_playerTurn(br);
                            break;
                        }
                    }
                    break;

                case ("exit"):
                    return;
                default:
                    break;

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
