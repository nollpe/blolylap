package game;

import agents.*;
import character.Player;
import equipment.*;
import field.*;
import graphics.GraphicsConstroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;

public class Game {

    private Timer timer;
    private City city;
    private GeneticCode[] AllGeneticCodes;
    private LinkedList<Player> allPlayers;
    public GraphicsConstroller gc;
    public boolean inTurn;
    public boolean inGame;
    //privát konstruktor

    /**
     * ide rakom be a menüt is ami a bemeneti nyelvet kezeli(kinda)
     */
    private Game() {
        AllGeneticCodes = new GeneticCode[4];
        allPlayers = new LinkedList<Player>();
        city = new City();
        inTurn = true;
        inGame = true;
        //vezerles();
        //worst idea ever a vezerlest iderakni xd
    }

    public void removePlayer(Player p) {
        allPlayers.remove(p);
    }

    //input a protohoz csak ahoz kell amugy meg actionlistenerek lesznek ezek helyett

    //region vezerles


    //megkap egy kétkarakteres stringet pl:F2 es erre visszaadja az ennek megfelelő mezőt, pl: erre a 2 es számú fieldet

    /**
     * mező neve -> a mező
     *
     * @param fieldName egy mező neve <típus><szám>
     * @return a mező amire referáltunk
     */
    public Field vezerles_determineField(String fieldName) {
        for (Field f : city.getMap()) {
            if (fieldName.toLowerCase(Locale.ROOT).equals(f.getName().toLowerCase(Locale.ROOT))) {
                return f;
            }
        }
        return null;
    }

    /**
     * bézikly felszerelésnév -> felszerelés
     *
     * @param eqName a felszaerelés neve amit a felhasználó adott meg
     * @return a felszerelést
     */
    public Equipment vezerles_determineLoot(String eqName) {
        switch (eqName.toLowerCase(Locale.ROOT)) {
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
    public Agent vezerles_determineAgent(String agentName, Player player) {
        switch (agentName.toLowerCase(Locale.ROOT)) {
            case ("chorea"):
                return new Chorea(player);
            case ("bear"):
                return new Bear(player);
            case ("forget"):
                return new Forget(player);
            case ("invulnerable"):
                return new Invulnerable(player);
            case ("paralyzing"):
                return new Paralyzing(player);
            default:
                return null;

        }
    }

    public void vezerles_getstat(String[] split) {
        if (split[1].length() == 2) {
            vezerles_determineField(split[1]).vezerles_getstat();
        } else {
            for (Player p : allPlayers) {
                if (p.getName().equals(split[1])) {
                    p.vezerles_getstat();
                    break;
                }
            }
        }
    }

    /**
     * egy mezőhöz hozzáadunk egy lootot
     *
     * @param split az inputcommand argumentumokkal, szavanként szétválasztva
     */
    public void vezerles_addLoot(String[] split) {
        Field f = vezerles_determineField(split[1]);
        switch (split[1].charAt(0)) {
            case ('s'):
                Safehouse s = (Safehouse) f;
                s.setStored(vezerles_determineLoot(split[2]));
                break;
            case ('w'):
                Warehouse w = (Warehouse) f;
                if (split[2].equals("aminoacid")) {
                    w.getStored().addAminoAcid(Integer.parseInt(String.valueOf(split[3])));
                } else if (split[2].equals("nucleotide")) {
                    w.getStored().addNucleotide(Integer.parseInt(String.valueOf(split[3])));
                }
                break;
            case ('l'):
                Laboratory l = (Laboratory) f;
                //TODO: meg kéne oldani hogy mindegyik genetikai kód annyi ágenst kérjen amennyit meghatároztunk
                l.init(new GeneticCode(vezerles_determineAgent(split[2], null), 2, 2));
            default:
                return;
        }
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
                if (!Objects.isNull(Eqtemp)) {
                    p.addEquipment(Eqtemp);
                    return;
                }
                Agent Agtemp = vezerles_determineAgent(split[2], p);
                if (!Objects.isNull(Agtemp)) {
                    if (split[3].equals("active")) {
                        Agtemp.takeEffect(p);
                    } else if (split[3].equals("castable")) {

                        p.addCastableAgent(Agtemp);
                    } else if (split[1].toLowerCase(Locale.ROOT).equals("addgeneticcode")) {
                        p.addGeneticCode(new GeneticCode(Agtemp, Integer.parseInt(split[4]), Integer.parseInt(split[3])));
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
        String input = "";
        while (!input.equals("exit")) {
            System.out.println("sima vezerles:");
            String[] split = new String[1];//placeholder a new String
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            input = input.toLowerCase(Locale.ROOT);
            split = input.split(" ");
            switch (split[0]) {
                case ("createmap"):
                    System.out.println("createmap:");
                    while (!input.equals("done")) {
                        try {
                            input = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        split = input.split(" ");
                        int temp;
                        switch (split[0].toLowerCase(Locale.ROOT)) {
                            case ("field"):
                                temp = Integer.parseInt(split[1]);
                                for (int i = 0; i < temp; i++) {
                                    city.getMap().add(new Field("f" + String.valueOf(i + 1)));
                                }
                                break;
                            case ("laboratory"):
                                temp = Integer.parseInt(split[1]);
                                for (int i = 0; i < temp; i++) {
                                    city.getMap().add(new Laboratory("l" + String.valueOf(i + 1)));
                                }
                                break;
                            case ("warehouse"):
                                temp = Integer.parseInt(split[1]);
                                for (int i = 0; i < temp; i++) {
                                    city.getMap().add(new Warehouse("w" + String.valueOf(i + 1)));
                                }
                                break;
                            case ("safehouse"):
                                temp = Integer.parseInt(split[1]);
                                for (int i = 0; i < temp; i++) {
                                    city.getMap().add(new Safehouse("s" + String.valueOf(i + 1)));
                                }
                                break;
                            case ("addneighbours"):
                                city.makeNeighbours(vezerles_determineField(split[1]), vezerles_determineField(split[2]));
                                break;
                            case ("addloot"):
                                vezerles_addLoot(split);
                                break;
                            case ("spawnplayer"):
                                if (split[2].length() < 3) {
                                    System.out.println("player name too short must be at least 3 characters");
                                    break;
                                }
                                Player tempPlayer = new Player(split[2]);
                                Field location = vezerles_determineField(split[1]);
                                location.enter(tempPlayer);
                                allPlayers.add(tempPlayer);
                                break;
                            default:
                                vezerles_playerAdd(split);
                                break;
                        }

                    }
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
                case ("getstat"):
                    vezerles_getstat(split);
                    break;
                default:
                    break;

            }

        }

    }
    //endregion

    public void Tick() {
        while(inGame) {
            for (Player allPlayer : allPlayers) {
                //TODO szóval a player dolgait kirajzolni és kattintgathatóvá tenni
                gc.setTurnOf(allPlayer);
                gc.Update();

                allPlayer.tick();

                while (Game.getInstance().inTurn) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Game.getInstance().inTurn = true;
                //ide várni amig lenyomjuk az end turn gombot
            }
            city.tick();
        }
    }

    //ebben tároljuk az egyedet
    private static Game singleInstance = null;

    //ezzel tudjuk lekérni az egyedet
    public static Game getInstance() {

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

        city = c;
    }

    public LinkedList<Player> getAllPlayers() {
        return allPlayers;
    }

    /**
     *
     *
     * @return amennyi playert akarunk
     */
    public int Menu()
    {
        final int[] revalue = {0};
        JFrame manuframe=new JFrame();
        JComboBox combobox;
        String geneticCodesString[] = new String[5];
        for (int i = 0; i < 5; i++) {
            geneticCodesString[i] = String.valueOf(i+1);

        }
        combobox = new JComboBox(geneticCodesString);
        JButton okbutton=new JButton();
        okbutton.setText("ok");
        okbutton.setEnabled(true);
        okbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                revalue[0] = Integer.parseInt(String.valueOf(combobox.getSelectedItem()));
            }
        });

        Image image = Toolkit.getDefaultToolkit().getImage("kepek/player.png");
        image = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        okbutton.setIcon(icon2);
        manuframe.setSize(240,100);
        combobox.setBounds(20,20,80,20);
        okbutton.setBounds(120,20,60,20);
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.add(combobox);
        panel.add(okbutton);
        manuframe.add(panel);
        manuframe.setVisible(true);
        while(revalue[0]==0)
        {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        manuframe.dispose();

        return revalue[0];
    }

    public void startGame() {
        int players=Menu();
        city.generateMap();

        for(int i=0;i<players;i++)
        {
            Player tempPlayer=new Player("player"+(i+1));
            allPlayers.add(tempPlayer);
        }

        /*Player player = new Player("rib");
        player.addEquipment(new Bag());
        allPlayers.add(player);
        Player player2 = new Player("rib2");
        allPlayers.add(player2);*/

        gc = new GraphicsConstroller();
        this.Tick();
    }

}
/*
 Azért, hogy singleton legyen:
 privát a konstruktora,
 egy statickus változóban tároljuk az egyetlen egyedet és azt udjuk lekérdezni egy szintén statikus függvénnyel
 így nem tudunk létrhozni egyedet, hanem csak a class tud ami csak egyet fog
 a getInstance függvénnyel lehet elérni

 */
