package character;

import agents.Agent;
import agents.GeneticCode;
import cast.Cast;
import cast.CastNormal;
import equipment.BrokenAxe;
import equipment.Equipment;
import field.Field;
import field.Safehouse;
import field.Warehouse;
import game.Game;
import getCastOn.GetCastOn;
import getCastOn.GetCastOnNormal;
import getLootTakenFrom.GetLootTakenFrom;
import getLootTakenFrom.LootTakenNormal;
import graphics.IView;
import graphics.player.PlayerControl;
import graphics.player.PlayerView;
import loot.Loot;
import loot.LootNormal;
import movement.Movement;
import movement.MovementNormal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Locale;

public class Player {
    //region variables
    private LinkedList<Agent> activeAgents;
    private LinkedList<Agent> castableAgents;
    private LinkedList<Equipment> equipments;
    private Inventory inventory;
    private Movement movement;
    private Cast cast;
    private GetCastOn getCastOn;
    private GetLootTakenFrom getLootTakenFrom;
    private Loot loot;
    private LinkedHashSet<GeneticCode> knownGeneticCodes;
    private final Game game;
    private Field location;
    private String Name;
    public PlayerView view;
    public PlayerControl control;

    //endregion
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public Player() {
        activeAgents = new LinkedList<>();
        castableAgents = new LinkedList<>();
        inventory = new Inventory(10);
        equipments = new LinkedList<>();
        movement = new MovementNormal(this);
        cast = new CastNormal(this);
        getCastOn = new GetCastOnNormal(this);
        getLootTakenFrom = new LootTakenNormal(this);
        loot = new LootNormal(this);
        knownGeneticCodes = new LinkedHashSet<>();
        game = Game.getInstance();
        location = game.spawnPlayer(this);
        view = new PlayerView(this);
        control = new PlayerControl(this);
    }

    public Player(String name) {
        Name = name;
        activeAgents = new LinkedList<>();
        castableAgents = new LinkedList<>();
        inventory = new Inventory(10);
        equipments = new LinkedList<>();
        movement = new MovementNormal(this);
        cast = new CastNormal(this);
        getCastOn = new GetCastOnNormal(this);
        getLootTakenFrom = new LootTakenNormal(this);
        loot = new LootNormal(this);
        knownGeneticCodes = new LinkedHashSet<>();
        game = Game.getInstance();
        location = game.spawnPlayer(this);
        view = new PlayerView(this);
        control = new PlayerControl(this);
    }

    public void die() {
        game.removePlayer(this);
        location.leave(this);
    }

    //region strategy pattern setter getter

    public Loot getLoot() {
        return loot;
    }

    public GetLootTakenFrom getGetLootTakenFrom() {
        return getLootTakenFrom;
    }

    public GetCastOn getGetCastOn() {
        return getCastOn;
    }

    public Cast getCast() {
        return cast;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setGetLootTakenFrom(GetLootTakenFrom g) {
        getLootTakenFrom = g;
    }

    public void setGetCastOn(GetCastOn g) {

        getCastOn = g;
    }

    public void setLoot(Loot l) {

        loot = l;
    }

    public void setMovement(Movement m) {

        movement = m;
    }

    public void setCast(Cast c) {

        cast = c;
    }
    //endregion

    //region spellcasting

    /**
     * A karakter felken egy ??genst
     *
     * @param player A j??t??kos akit kennek
     * @param agent  A felkent ??gens
     * @return A ken??s sikeress??ge
     */
    boolean cast(Player player, Agent agent) {
        return cast.cast(player, agent);
    }

    /**
     * A karakterre felkennek egy ??genst
     *
     * @param a Amit kennek
     * @param c Aki keni
     */
    public void getCastOn(Agent a, Player c) {

        getCastOn.getCastOn(a, c);
    }
    //endregion

    //region sima getter setterek

    public IView getView() {
        return view;
    }

    public PlayerControl getControl() {
        return control;
    }

    public String getName() {
        return Name;
    }

    public LinkedList<GeneticCode> getGeneticCodes() {
        LinkedList<GeneticCode> temp=new LinkedList<GeneticCode>();
        for(GeneticCode itr:knownGeneticCodes)
        {
            temp.add(itr);
        }

        return temp;
    }

    //endregion

    //region vezerles, player kore

    /**
     * @param split a parancs amit be??rt a felhaszn??l??
     * @return ha siker??lt v??grehajtani a parancsot true ha nem siker??lt false;
     */
    public boolean vezerles_attack(String[] split) {
        for (Equipment eq : equipments) {
            if (eq.toString().equals("Axe")) {
                LinkedHashSet<Player> temp = this.location.getInhabitants();
                for (Player p : temp) {
                    if (p.getName().equals(split[1])) {
                        p.die();
                        equipments.remove(eq);
                        equipments.add(new BrokenAxe());
                        return true;

                    }
                }
            }
        }
        return false;
    }

    /**
     * @param split a parancs amit be??rt a felhaszn??l??
     * @return ha siker??lt v??grehajtani a parancsot true ha nem siker??lt false;
     */
    public boolean vezerles_castAgent(String[] split) {
        LinkedHashSet<Player> temp = this.location.getInhabitants();
        for (Player p : temp) {
            if (p.getName().equals(split[1])) {
                for (Agent casted : castableAgents) {
                    if (casted.toString().toLowerCase(Locale.ROOT).equals(split[2].toLowerCase(Locale.ROOT))) {
                        cast(p, casted);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param split a parancs amit be??rt a felhaszn??l??
     * @return ha siker??lt v??grehajtani a parancsot true ha nem siker??lt false;
     */
    public boolean vezerles_makeagent(String[] split) {
        for (GeneticCode gen : knownGeneticCodes) {
            if (split[1].toLowerCase(Locale.ROOT).equals(gen.getAgentType().toLowerCase(Locale.ROOT))) {
                Agent temp = gen.makeAgent(inventory);
                if (temp != null) {
                    System.out.println(temp.toString());
                    castableAgents.add(temp);
                    return true;
                } else {
                    System.out.println("can't make " + split[1]);
                }
            }
        }
        return false;
    }

    public boolean vezerles_loot(String[] split) {
        if (split[1].equals("field")) {
            switch (split[2].toLowerCase(Locale.ROOT)) {
                case ("nucleotide"):
                    int taken = location.takeNucleotide(Integer.parseInt(split[3]));
                    int addedToInventory = inventory.addNucleotide(taken);
                    if (addedToInventory != taken && taken != 0) {
                        Warehouse xd = (Warehouse) location;
                        xd.getStored().addNucleotide(taken - addedToInventory);
                        //mert akkor nem tudja belerakni az inventoryba ez??rt visszarakjuk a hely??re
                        //hogy ne lehessen csak ??gy elvinni mindent
                        //??ljetek meg
                    }
                    break;
                case ("aminoacid"):
                    int takena = location.takeAminoAcid(Integer.parseInt(split[3]));
                    int addedToInventorya = inventory.addAminoAcid(takena);
                    if (addedToInventorya != takena && takena != 0) {
                        Warehouse xd = (Warehouse) location;
                        xd.getStored().addAminoAcid(takena - addedToInventorya);

                    }
                    break;
                case ("geneticcode"):
                    GeneticCode EEEEEE = location.readGeneticCode();
                    if (EEEEEE != null) {
                        for (GeneticCode genc : knownGeneticCodes) {
                            if (EEEEEE.getAgentType().equals(genc.getAgentType())) {
                                System.out.println("you already know this GeneticCode B");
                                return false;
                            }
                        }
                        knownGeneticCodes.add(EEEEEE.clone());//ha ugye nem tudja m??g csak akkor adjuk hozz??
                    }
                    break;
                default:

                    Safehouse safewtrngt = (Safehouse) location;
                    if (safewtrngt.getStored().toString().toLowerCase(Locale.ROOT).equals(split[2].toLowerCase(Locale.ROOT))) {

                        location.takeEquipment(safewtrngt.getStored());
                    }

                    break;
            }


        } else {
            for (Player ppl : location.getInhabitants())//megkeresi a jatekost
            {
                if (ppl.getName().equals(split[1])) {
                    for (Equipment eqsch : ppl.getStored())//megkersi az equipmentet
                    {
                        if (eqsch.toString().toLowerCase(Locale.ROOT).equals(split[2].toLowerCase(Locale.ROOT))) {
                            if (loot.lootEquipment(ppl, eqsch))//megnezi, hogy elveheti-e
                            {
                                return true;
                            }
                        }
                    }
                    if (split[2].toLowerCase(Locale.ROOT).equals("aminoacid")) {
                        this.lootAminoAcid(ppl, Integer.parseInt(split[3]));
                        //loot.lootAminoAcid(ppl, Integer.parseInt(split[3]));
                        return true;
                    } else if (split[2].toLowerCase(Locale.ROOT).equals("nucleotide")) {
                        this.lootNucleotide(ppl, Integer.parseInt(split[3]));
                        //loot.lootNucleotide(ppl, Integer.parseInt(split[3]));
                        return true;

                    }

                }
            }
            System.out.println("nem siker??lt a lootol??s");
        }
        return false;
    }

    public void vezerles_getstat() {
        System.out.println("Location:\n\t" + location.getName());
        System.out.println("Active agents:");
        for (Agent a : activeAgents) {
            System.out.println("\t" + a.toString());
        }
        System.out.println("Castable agents:");
        for (Agent a : castableAgents) {
            System.out.println("\t" + a.toString());
        }
        System.out.println("Equipments:");
        for (Equipment a : equipments) {
            System.out.println("\t" + a.toString());
        }
        System.out.println("Resources:\n\taminoacid: " + inventory.getAminoAcid() + "\n\tnucleotide: " + inventory.getNucleotide());
        System.out.println("Known genetic codes:" + knownGeneticCodes.size());
        for (GeneticCode a : knownGeneticCodes) {
            System.out.println("\t" + a.getAgentType());
        }
    }

    public void vezerles_playerTurn(BufferedReader br) {
        System.out.println("playerturn:");
        String input = "ribancos kifli";
        boolean canMove = true;
        boolean canCast = true;
        boolean canMake = true;
        boolean canAttack = true;
        boolean canLoot = true;
        while (!input.equals("exit")) {
            String[] split = new String[1];//placeholder a new String
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            input = input.toLowerCase(Locale.ROOT);
            split = input.split(" ");
            switch (split[0]) {
                case ("moveto"):
                    if (canMove) {
                        this.move(game.vezerles_determineField(split[1]));
                    }
                    break;
                case ("loot"):
                    if (canLoot) {
                        canLoot = !this.vezerles_loot(split);
                    }
                    break;
                case ("makeagent"):
                    if (canMake)
                        canMake = !this.vezerles_makeagent(split);
                    break;
                case ("castagent"):
                    if (canCast) {
                        canCast = !this.vezerles_castAgent(split);
                    }
                    break;
                case ("slay"):
                    if (canAttack) {
                        ;
                        canAttack = !this.vezerles_attack(split);
                    }
                    break;
                case ("drop"):
                    String[] finalSplit = split;
                    equipments.removeIf(eq -> eq.toString().toLowerCase(Locale.ROOT).equals(finalSplit[1].toLowerCase(Locale.ROOT)));
                    break;
                case ("getstat"):
                    if (split[1].length() == 2) {
                        game.vezerles_determineField(split[2]).vezerles_getstat();
                    } else {
                        for (Player p : game.getAllPlayers()) {
                            if (p.getName().equals(split[1])) {
                                p.vezerles_getstat();
                                break;
                            }
                        }
                    }
                    break;
                case ("endturn"):
                    this.tick();
                    return;
                default:
                    System.out.println("invalid command");
                    break;
            }
        }
    }
    //endregion

    /**
     * Egy k??r m??l??s????rt felel, az ??gensek id??tartam??t cs??kkentik
     */
    public void tick() {
        for (Agent agent : activeAgents) {
            agent.tick();
        }
        for (Agent agent : castableAgents) {
            agent.tick();
        }


        //TODO k??ne egy thread ami itt csak alszik am??g nem nincs endturn ??s akkor lehet kattintgatni a graphics controllerrel
        //legal??bbis ez az ??tletem
    }

    //region lootolnak tole


    /**
     * A karaktert??l lootolni akarnak. Megh??vja a lootol??s eszenved??s????rt felel??s oszt??lyt.
     *
     * @param e A v??d??felszerel??st amit el akarnak venni.
     * @return Az elv??tel sikeress??ge.
     */
    public boolean getLootTakenFrom(Equipment e) {

        return getLootTakenFrom.getEquipmentTakenFrom(e);
    }

    /**
     * A karakter lootolni akar egy felszerel??st. Megh??vja a lootol??s??rt felel??s oszt??lyt.
     *
     * @param target akit??l lootolni akar
     * @param eq     amit lootolni akar
     * @return sikeres volt-e
     */
    public boolean lootEquipment(Player target, Equipment eq) {
        return loot.lootEquipment(target, eq);
    }

    /**
     * A karakter lootolni akar amino savat. Megh??vja a lootol??s??rt felel??s oszt??lyt.
     *
     * @param target akit??l lootolni akar
     * @param n      amennyit lootolni akar
     * @return amennyit siker??lt lootolni
     */
    public int lootAminoAcid(Player target, int n) {
        return inventory.addAminoAcid(loot.lootAminoAcid(target, n));
    }

    /**
     * A karakter lootolni akar nukleotidot. Megh??vja a lootol??s??rt felel??s oszt??lyt.
     *
     * @param target akit??l lootolni akar
     * @param n      amennyit lootolni akar
     * @return amennyit siker??lt lootolni
     */
    public int lootNucleotide(Player target, int n) {
        return inventory.addNucleotide(loot.lootNucleotide(target, n));
    }

    /**
     * Elt??vol??t egy v??d??felszerel??st
     *
     * @param e Elt??vol??tand?? v??d??felszerel??s
     * @return Sikeres volt-e
     */
    public boolean removeLoot(Equipment e) {

        equipments.remove(e);

        return true;

    }

    /**
     * Elvesz valamennyi nukleotidot a karaktert??l
     *
     * @param d1 - h??nyat akarunk elvenni
     * @return - h??nyat tudtunk elvenni
     */
    public int takeNucleotide(int d1) {
        return inventory.takeNucleotide(d1);
    }

    /**
     * Elvesz??nk amino acidot
     *
     * @param d1 ennyit akarunk elvenni
     * @return ennyit tudunk elvenni
     */
    public int takeAminoAcid(int d1) {
        return inventory.takeAminoAcid(d1);
    }

    /**
     * A j??t??kost??l nukleotidot akarnak lootolni
     *
     * @param taken Amennyit el akarnak venni
     * @return Amennyit siker??l
     */
    public int getNucleotideTakenFrom(int taken) {
        return getLootTakenFrom.getNucleotideTakenFrom(taken);
    }

    /**
     * A j??t??kost??l aminosavat akarnak lootolni
     *
     * @param taken Amennyit el akarnak venni
     * @return Amennyit siker??l
     */
    public int getAminoAcidTakenFrom(int taken) {
        return getLootTakenFrom.getAminoAcidTakenFrom(taken);
    }

    /**
     * Megmutatja milyen equipmentjei vannak a playernek
     *
     * @return V??d??felszerel??sek list??ja
     */
    public LinkedList<Equipment> showLoot() {
        return equipments;
    }
    //endregion

    /**
     * Hozz??adunk egy GeneticCode-ot
     *
     * @param gc GeneticCode
     */
    public void addGeneticCode(GeneticCode gc) {
        knownGeneticCodes.add(gc);
    }


    /**
     * Elmozd??tja a j??t??kost a megadott mez??re
     *
     * @param field a megadott ??gt??j
     */
    public void move(Field field) {
        movement.move(field);
    }

    //region adderek removerek

    /**
     * Hozz??adunk egy v??d??felszerel??st
     *
     * @param eq v??d??felszerel??s
     */
    public void addEquipment(Equipment eq) {
        equipments.add(eq);
        eq.takeEffect(this);
    }

    /**
     * ActiveAgent hozz??ad??sa
     *
     * @param agent ??j akt??v agent
     */
    public void addActiveAgent(Agent agent) {
        activeAgents.add(agent);
        agent.setActive(true);
    }

    /**
     * AkticeAgent elt??vol??t??sa
     *
     * @param agent elt??vol??tand?? akt??v agent
     */
    public void removeActiveAgent(Agent agent) {
        activeAgents.remove(agent);
    }

    /**
     * Minden genetikus k??dot elfelejtett a j??t??kossal
     */
    public void forgetAllGeneticCodes() {
        knownGeneticCodes = new LinkedHashSet<>();
    }

    /**
     * Megadja, hogy melyik mez??n ??ll a j??t??kos
     *
     * @return A mez??
     */
    public Field getLocation() {

        return location;
    }

    /**
     * Be??ll??tja a j??t??kosban, hogy melyik mez??n ??ll
     *
     * @param f A mez??
     */
    public void setLocation(Field f) {

        location = f;
    }

    /**
     * Megadja, hogy milyen v??d??felszerel??sek vannak a karaktern??l.
     *
     * @return A v??d??felszerl??sek list??ja.
     */
    public LinkedList<Equipment> getStored() {
        return equipments;
    }

    /**
     * Be??ll??tja a karakterhez tartoz?? inventoryt.
     *
     * @param i A karakterhez tartoz?? inventory.
     */
    public void setInventory(Inventory i) {
        inventory = i;
    }

    /**
     * Megadja karakterhez tartoz?? inventoryt.
     *
     * @return A karakterhez tartoz?? inventory.
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Megmutatja milyen kenhet?? ??genseink vannak
     *
     * @return kenhet?? ??gensek list??ja
     */
    public LinkedList<Agent> getCastableAgents() {
        return castableAgents;
    }

    /**
     * Kenhet?? ??gens hozz??ad??sa
     *
     * @param castableAgent kenhet?? ??gens
     */
    public void addCastableAgent(Agent castableAgent) {
        castableAgents.add(castableAgent);
    }

    /**
     * Kit??rli az castolhat?? ??gensek k??z??l a kapott ??genset
     *
     * @param a az ??gens, amit ki kell t??r??lni
     */
    public void removeCastableAgent(Agent a) {
        castableAgents.remove(a);
    }


    public void makeAgent(GeneticCode geneticCode) {
        Agent temp=geneticCode.makeAgent(this.inventory);
        if(temp!=null)
        {
            this.castableAgents.add(temp);
        }
    }

    //endregion
}
