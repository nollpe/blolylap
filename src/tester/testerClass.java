package tester;

import agents.Agent;
import agents.Chorea;
import agents.Forget;
import agents.Invulnerable;
import character.Player;
import equipment.Bag;
import equipment.Gloves;
import equipment.Labcoat;
import field.City;
import field.Field;
import game.Game;
import game.Timer;
import getLootTakenFrom.LootTakenStunned;
import loot.LootImpared;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class testerClass {

    public testerClass()
    {

    }

    public static void print()
    {
        String className=new Exception().getStackTrace()[1].getClassName();
        String methodName1=new Exception().getStackTrace()[1].getMethodName();
        int depth1=new Exception().getStackTrace().length;
        String filler="\t".repeat(depth1-3);

        System.out.println(filler + className + " " + methodName1);
    }

    public void wiewCity()
    {
        City c= new City();
        c.showCity();
    }

    public void startGame()
    {
        Game game= Game.getInstance();
    }

    public void end_turn()
    {
        Timer timer= Timer.getInstance();
        timer.tick();
    }


    public void agentExpires()
    {
        Player ribanc=new Player();
        Agent agent=null;
        System.out.println("melyik agens?\n1:Invulnerable\n2:Chorea\n3:Paralyzing\n4:Forget\n0:kilép");
        int chosen=0;


        while(agent==null)
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                chosen=Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //mAgAS sZInTű nYElv
            //chosen=getchar();
            switch(chosen)
            {
                case(1):
                    agent=new Invulnerable();
                    break;
                case(2):
                    agent=new Invulnerable();
                    break;
                case(3):
                    agent=new Chorea();
                    break;
                case(4):
                    agent=new Forget();
                    break;
                case(0):
                    return;
                default:
                    break;
            }
        }

        agent.takeEffect(ribanc);
        System.out.println("lose effect:");
        agent.loseEffect(ribanc);

    }

    /**
     * Karakterek a teszteléshez
     */
    static Player character1;
    static Player character2;
    static Player character3;

    /**
     * A másik játékostól való ágens lootolásának a tesztjei
     */
    private void InteractWithOtherVirologist(){
        /**
         * Megkérdezi a felhasználót, hogy melyik esetet szeretné tesztelni.
         * Addig kéri a bemenetet újra, amíg értelmes választ nem kap.
         */
        int n = 0;
        boolean valid = false;
        while(!valid){
            System.out.println("Kérlek válassz egy : \n1-Védőfelszerelést ellopása karaktertől\n2-idk");
            Scanner input = new Scanner(System.in);
            n = Integer.parseInt(input.nextLine());
            /**
             * Ellenőrzi, hogy értelmes választ adott-e a felhasználó
             */
            if(n>0 && n <3) valid = true;
        }

        /**
         * A felhasználó által választott tesztet futtatja.
         */
        switch (n){
            case 1:
                TestInit1();
                LootEquipmentFromCharacterTest();
                break;
            case 2:
                TestInit1();
                Test2();
                break;
            default:
                System.out.println("Ilyen  teszteset nincs");
        }
    }

    /**
     * Equipment lootoláshoz tartozó tesztekhez.
     * Létrehozza és inicializálja a teszteléshez szükséges példányokat.
     */
    private void TestInit1() {
        /**
         * létrehozása a játékot és a várost  illetve összekapcsolja őket.
         */
        Game game = Game.getInstance();
        City city = new City();
        game.setCity(city);
        city.generateMap();

        /**
         * A karaktereket létrehozza és egy mezőre helyezi őket, hogy tudjanak interaktálni.
         * Azért van 3 karakter, hogy mind a sikeres, mind a sikertelen lootolási kísérleteket tesztelni tudjuk.
         */
        character1 = new Player();
        character2 = new Player();
        character3 = new Player();
        Field field = new Field();
        field.enter(character1);
        field.enter(character2);
        field.enter(character3);
        character1.setLocation(field);
        character2.setLocation(field);
        character3.setLocation(field);

        /**
         * Létrehozza a védőfelszereléseket és a karakterekhez rendeleli
         * Két karakterhez is hozzáadja őket, hogy a lebénult és a nem lebénult eseteket is telsztelni lehessen.
         */
        Gloves gloves = new Gloves();
        Bag bag = new Bag();
        Labcoat labcoat = new Labcoat();
        character2.addEquipment(gloves);
        character2.addEquipment(labcoat);
        character2.addEquipment(bag);
        character3.addEquipment(gloves);
        character3.addEquipment(labcoat);
        character3.addEquipment(bag);

        /**
         * A második karaktert megbénítja
         * Ehhez a lottolás és a lootolás elszenvedésének strategy patternjét is beállítja.
         */
        LootTakenStunned lts = new LootTakenStunned();
        character2.setGetLootTakenFrom(lts);
        LootImpared li = new LootImpared();
        character2.setLoot(li);
    }

    /**
     * A karaktertől való lootolás tesztje
     */
    private void LootEquipmentFromCharacterTest(){
        /**
         * Megkérdezi a felhasználótol, hogy lebénult vagy nem lebénult karakterrel szeretne tesztelni.
         * A lebénult karatker tud lootolni, a nem lebénult nem.
         * Addig kéri a bemenetet újra, amíg értelmes választ nem kap.
         */
        int n = 0;
        boolean valid = false;
        while(!valid){
            System.out.println("Milyen karakterrel szeretnél lootolni?: \n1-Nem lebénult\n2-Lebénult");
            Scanner input = new Scanner(System.in);
            n = Integer.parseInt(input.nextLine());
            if(n>0 && n <3) valid = true;
        }
        /**
         * A felhasználó által választott tesztet futtatja.
         * Első: nem lebénult.
         * Második: lebénult.
         */
        switch (n){
            case 1:
                character1.loot();
                break;
            case 2:
                character2.loot();
                break;
            default:
                System.out.println("Ilyen nincsen. ");
        }
    }

    private void Test2(){

    }

    public static void main(String[] args)
    {
        testerClass ts=new testerClass();
        ts.agentExpires();
        ts.InteractWithOtherVirologist();
    }
}
