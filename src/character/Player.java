package character;

import agents.*;
import cast.*;
import equipment.*;
import field.*;
import game.*;
import getCastOn.*;
import getLootTakenFrom.GetLootTakenFrom;
import getLootTakenFrom.LootTakenNormal;
import loot.*;
import movement.*;
import tester.testerClass;


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
    private LinkedList<GeneticCode> knownGeneticCodes;
    private Game game;
    private Field location;
    private String Name;

    //endregion
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public Player() {
        activeAgents = new LinkedList<Agent>();
        castableAgents = new LinkedList<Agent>();
        inventory = new Inventory(10);
        equipments = new LinkedList<Equipment>();
        movement = new MovementNormal(this);
        cast = new CastNormal(this);
        getCastOn = new GetCastOnNormal(this);
        getLootTakenFrom = new LootTakenNormal(this);
        loot = new LootNormal(this);
        knownGeneticCodes = new LinkedList<GeneticCode>();
        game = Game.getInstance();
        location=game.spawnPlayer(this);
    }

    public Player(String name)
    {
        this();
        Name=name;
    }

    public void die()
    {
        game.removePlayer(this);
        location.leave(this);
        //TODO hogy a faszba kell megszüntetni egy ilyen gecit?
        //TODO also az összes cuccát ami van
    }

    //region strategy pattern setter getter

    public Loot getLoot() {
        testerClass.print();
        return loot;
    }

    public GetLootTakenFrom getGetLootTakenFrom() {
        testerClass.print();
        return getLootTakenFrom;
    }

    public GetCastOn getGetCastOn() {
        testerClass.print();
        return getCastOn;
    }

    public Cast getCase() {
        testerClass.print();
        return cast;
    }

    public Movement getMovement() {
        testerClass.print();
        return movement;
    }

    public void setGetLootTakenFrom(GetLootTakenFrom g) {
        testerClass.print();
        getLootTakenFrom = g;
    }

    public void setGetCastOn(GetCastOn g) {
        testerClass.print();
        getCastOn = g;
    }

    public void setLoot(Loot l) {
        testerClass.print();
        loot = l;
    }

    public void setMovement(Movement m) {
        testerClass.print();
        movement = m;
    }

    public void setCast(Cast c) {
        testerClass.print();
        cast = c;
    }
    //endregion

    //region spellcasting
    public void castSpell() {
        testerClass.print();
        //TODO ??
        //cast.cast(this);
    }

    public void getCastOn(Agent a, Player c) {
        testerClass.print();
        getCastOn.getCastOn(a, c);
    }
    //endregion

    //region sima getter setterek

    public String getName()
    {
        return Name;
    }

    //endregion

    //region vezerles, player kore

    /**
     *
     * @param split a parancs amit beírt a felhasználó
     * @return ha sikerült végrehajtani a parancsot true ha nem sikerült false;
     */
    public boolean vezerles_attack(String[] split)
    {
        for(Equipment eq:equipments)
        {
            if(eq.toString().equals("Axe"))
            {
                LinkedHashSet<Player> temp=this.location.getInhabitants();
                for(Player p:temp)
                {
                    if(p.getName().equals(split[1]))
                    {
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
     *
     * @param split a parancs amit beírt a felhasználó
     * @return ha sikerült végrehajtani a parancsot true ha nem sikerült false;
     */
    public boolean vezerles_castAgent(String[] split)
    {
        LinkedHashSet<Player> temp=this.location.getInhabitants();
        for(Player p:temp)
        {
            if(p.getName().equals(split[1]))
            {
                for(Agent casted:castableAgents)
                {
                    if(casted.toString().equals(split[2]))
                    {
                        p.getCastOn.getCastOn(casted,this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * @param split a parancs amit beírt a felhasználó
     * @return ha sikerült végrehajtani a parancsot true ha nem sikerült false;
     */
    public boolean vezerles_makeagent(String[] split)
    {
        for (GeneticCode gen : knownGeneticCodes)
        {
            if(split[1].equals(gen.getAgentType()))
            {
                Agent temp=gen.makeAgent(inventory);
                if(temp!=null)
                {
                    castableAgents.add(temp);
                    return true;
                }
                else
                {
                    System.out.println("can't make " + split[1]);
                }
            }
        }
        return false;
    }

    public boolean vezerles_loot(String[] split)
    {
        if(split[1].equals("feild"))
        {
            switch (split[2].toLowerCase(Locale.ROOT))
            {
                case("nucleotide"):
                    int taken=location.takeNukleotide(Integer.parseInt(split[3]));
                    int addedToInventory=inventory.addNucleotide(taken);
                    if(addedToInventory!=taken && taken !=0)
                    {
                        Warehouse xd=(Warehouse)location;
                        xd.getStored().addNucleotide(taken-addedToInventory);
                        //mert akkor nem tudja belerakni az inventoryba ezért visszarakjuk a helyére
                        //hogy ne lehessen csak úgy elvinni mindent
                        //öljetek meg
                    }
                    break;
                case("aminoacid"):
                    int takena=location.takeAminoAcid(Integer.parseInt(split[3]));
                    int addedToInventorya=inventory.addAminoAcid(takena);
                    if(addedToInventorya!=takena && takena !=0)
                    {
                        Warehouse xd=(Warehouse)location;
                        xd.getStored().addAminoAcid(takena-addedToInventorya);

                    }
                    break;
                case("geneticcode"):
                    GeneticCode EEEEEE=location.readGeneticCode();
                    if(EEEEEE!=null)
                    {
                        for(GeneticCode genc:knownGeneticCodes)
                        {
                            if(EEEEEE.getAgentType().equals(genc.getAgentType()))
                            {
                                System.out.println("you already know this GeneticCode B");
                                return false;
                            }
                        }
                        knownGeneticCodes.add(EEEEEE.clone());//ha ugye nem tudja még csak akkor adjuk hozzá
                    }
                    break;
                default:
                    Safehouse safewtrngt=(Safehouse)location;
                    if(safewtrngt.getStored().toString().toLowerCase(Locale.ROOT).equals(split[2].toLowerCase(Locale.ROOT)))
                    {
                        location.takeEquipment(safewtrngt.getStored());
                    }

                    break;
            }

        }
        else
        {
            for(Player ppl:location.getInhabitants())//megkeresi a jatekost
            {
                if(ppl.getName().equals(split[1]))
                {
                    for(Equipment eqsch:ppl.getStored())//megkersi az equipmentet
                    {
                        if(eqsch.toString().toLowerCase(Locale.ROOT).equals(split[2].toLowerCase(Locale.ROOT)))
                        {
                            if(loot.lootEquipment(ppl,eqsch))//megnezi, hogy elveheti-e
                            {
                                return true;
                            }
                        }
                    }
                    if(split[2].toLowerCase(Locale.ROOT).equals("aminoacid"))
                    {
                        loot.lootAminoAcid(ppl,Integer.parseInt(split[3]));
                        return true;
                    }
                    else if(split[2].toLowerCase(Locale.ROOT).equals("nucleotide"))
                    {
                        loot.lootNukleotide(ppl,Integer.parseInt(split[3]));
                        return true;
                    }

                }
            }
            System.out.println("nem sikerült a lootolás");
        }
        return false;
    }

    public void vezerles_getstat()
    {
        System.out.println("Location:\n\t" + location.getName());
        System.out.println("Active agents:");
        for(Agent a:activeAgents)
        {
            System.out.println("\t" + a.toString());
        }
        System.out.println("Castable agents:");
        for(Agent a:castableAgents)
        {
            System.out.println("\t" + a.toString());
        }
        System.out.println("Equipments:");
        for(Equipment a:equipments)
        {
            System.out.println("\t" + a.toString());
        }
        System.out.println("Resources:\n\taminoacid: " + inventory.getAminoAcid() + "\n\tnucleotide: "+inventory.getNukleotide());
        System.out.println("Known genetic codes:");
        for(GeneticCode a:knownGeneticCodes)
        {
            System.out.println("\t" + a.toString());
        }
    }

    public void vezerles_playerTurn(BufferedReader br)
    {
        System.out.println("playerturn:");
        String input = "ribancos kifli";
        boolean canMove=true;
        boolean canCast=true;
        boolean canMake=true;
        boolean canAttack=true;
        boolean canLoot=true;
        while (!input.equals("exit")) {
            String[] split = new String[1];//placeholder a new String
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            split = input.split(" ");
            switch(split[0]) {
                case ("moveto"):
                    if (canMove) {
                        this.move(game.vezerles_determineField(split[1]));
                    }
                    break;
                case ("loot"):
                    if (canLoot)
                    {
                        canLoot=!this.vezerles_loot(split);
                    }
                    break;
                case ("makeagent"):
                    if (canMake)
                        ;canMake=!this.vezerles_makeagent(split);
                    break;
                case("castagent"):
                    if(canCast)
                    {
                        ;canCast=!this.vezerles_castAgent(split);
                    }
                    break;
                case("slay"):
                    if(canAttack)
                    {
                        ;canAttack=!this.vezerles_attack(split);
                    }
                    break;
                case("drop"):
                    String[] finalSplit = split;
                    equipments.removeIf(eq -> eq.toString().equals(finalSplit[1]));
                    break;
                case("getstat"):
                    if(split[1].length()==2)
                    {
                        game.vezerles_determineField(split[2]).vezerles_getstat();
                    }
                    else
                    {
                        for(Player p:game.getAllPlayers())
                        {
                            if(p.getName().equals(split[1]))
                            {
                                p.vezerles_getstat();break;
                            }
                        }
                    }
                    break;
                case("endturn"):
                    return;
                default:
                    System.out.println("invalid command");
                    break;
            }
        }
        this.tick();
    }
    //endregion

    public void tick() {
        testerClass.print();
        for (Agent agent : activeAgents) {
            agent.tick();
            if (agent.getTimeToLive() == 0) {
                agent.loseEffect(this);
            }
        }
        for (Agent agent : castableAgents) {
            agent.tick();
            if (agent.getTimeToLive() == 0) {
                agent.loseEffect(this);
            }
        }

    }

    //region lootolnak tole

    /**
     * A játékostól elvesznek egy védőfelszerelést, ezért törli mgaáról a hatását és kitörli az felszerelései közül.
     *
     * @param e A védőfelszerelést amit elvettek.
     * @return Az elvétel sikeressége.
     */
    public boolean takeLoot(Equipment e) {
        testerClass.print();
        e.loseEffect(this);
        equipments.remove(e);
        return true;
    }


    /**
     * A karaktertől lootolni akarnak. Meghívja a lootolás eszenvedéséért felelős osztályt.
     *
     * @param e A védőfelszerelést amit el akarnak venni.
     * @return Az elvétel sikeressége.
     */
    public boolean getLootTakenFrom(Equipment e) {
        testerClass.print();
        boolean succes = getLootTakenFrom.getEquipmentTakenFrom(e);
        return succes;
    }

    /**
     * A karakter lootolni akar. Meghívja a lootolásért felelős osztályt.
     */
    public void loot() {

        testerClass.print();
        //TODO ??
        //loot.loot(this);//?

    }

    /**
     * Eltávolít egy védőfelszerelést
     *
     * @param e Eltávolítandó védőfelszerelés
     * @return Sikeres volt-e
     */
    public boolean removeLoot(Equipment e) {
        equipments.remove(e);
        testerClass.print();
        return true;
    }

    /**
     * Elvesz valamennyi nukleotidot a karaktertől
     *
     * @param d1 - hányat akarunk elvenni
     * @return - hányat tudtunk elvenni
     */
    public int takeNukleotide(int d1) {
        testerClass.print();
        Warehouse wh = (Warehouse) location;
        int d2 = wh.getStored().takeNucleotide(d1);
        int d3 = inventory.addNucleotide(d2);
        return d3;

    }

    /**
     * Elveszünk amino acidot
     *
     * @param d1 ennyit akarunk elvenni
     * @return ennyit tudunk elvenni
     */
    public int takeAminoAcid(int d1) {
        testerClass.print();
        Warehouse wh = (Warehouse) location;
        int d2 = wh.getStored().takeAminoAcid(d1);
        int d3 = inventory.addAminoAcid(d2);
        testerClass.print();
        return d3;
    }

    /**
     * Megmutatja milyen equipmentjei vannak a playernek
     *
     * @return Védőfelszerelések listája
     */
    public LinkedList<Equipment> showLoot() {
        testerClass.print();
        return equipments;
    }
    //endregion

    /**
     * Hozzáadunk egy GeneticCode-ot
     *
     * @param gc GeneticCode
     */
    public void addGeneticCode(GeneticCode gc) {
        testerClass.print();
        knownGeneticCodes.add(gc);
    }


    /**
     * Elmozdítja a játékost a megadott mezőre
     *
     * @param field a megadott égtáj
     */
    public void move(Field field) {
        testerClass.print();
        getMovement().move(field);
    }

    //region adderek removerek

    /**
     * Hozzáadunk egy védőfelszerelést
     *
     * @param eq védőfelszerelés
     */
    public void addEquipment(Equipment eq) {
        testerClass.print();
        equipments.add(eq);
        eq.takeEffect(this);
    }

    /**
     * ActiveAgent hozzáadása
     *
     * @param agent új aktív agent
     */
    public void addActiveAgent(Agent agent) {
        activeAgents.add(agent);
    }

    /**
     * AkticeAgent eltávolítása
     *
     * @param agent eltávolítandó aktív agent
     */
    public void removeActiveAgent(Agent agent) {
        activeAgents.remove(agent);
    }

    /**
     * Minden genetikus kódot elfelejtett a játékossal
     */
    public void forgetAllGeneticCodes() {
        knownGeneticCodes = new LinkedList<GeneticCode>();
    }

    /**
     * Megadja, hogy melyik mezőn áll a játékos
     *
     * @return A mező
     */
    public Field getLocation() {
        testerClass.print();
        return location;
    }

    /**
     * Beállítja a játékosban, hogy melyik mezőn áll
     *
     * @param f A mező
     */
    public void setLocation(Field f) {
        testerClass.print();
        location = f;
    }

    /**
     * Megadja, hogy milyen védőfelszerelések vannak a karakternél.
     *
     * @return A védőfelszerlések listája.
     */
    public LinkedList<Equipment> getStored() {
        testerClass.print();
        return equipments;
    }

    /**
     * Beállítja a karakterhez tartozó inventoryt.
     *
     * @param i A karakterhez tartozó inventory.
     */
    public void setInventory(Inventory i) {
        testerClass.print();
        inventory = i;
    }

    /**
     * Megadja karakterhez tartozó inventoryt.
     *
     * @returni A karakterhez tartozó inventory.
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Megmutatja milyen kenhető ágenseink vannak
     *
     * @return kenhető ágensek listája
     */
    public LinkedList<Agent> getCastableAgents() {
        return castableAgents;
    }

    /**
     * Kenhető ágens hozzáadása
     *
     * @param castableAgent kenhető ágens
     */
    public void addCastableAgent(Agent castableAgent) {
        testerClass.print();
        castableAgents.add(castableAgent);
        //castableAgent.takeEffect(this);
    }

    /**
     * Kitörli az castolható ágensek közül a kapott ágenset
     * @param a az ágens, amit ki kell törölni
     */
    public void removeCastableAgent(Agent a){
        castableAgents.remove(a);
    }


    public void makeAgent(GeneticCode geneticCode) {
        geneticCode.makeAgent(this.inventory);
    }

    //endregion
}
