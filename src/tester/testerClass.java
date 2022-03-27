package tester;

import agents.Agent;
import agents.Chorea;
import agents.Forget;
import agents.Invulnerable;
import character.Player;
import field.City;
import game.Game;
import game.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void main(String[] args)
    {
        testerClass ts=new testerClass();
        ts.agentExpires();

    }
}
