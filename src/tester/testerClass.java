package tester;

import field.City;
import game.Game;
import game.Timer;

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

    public static void main(String[] args)
    {


    }
}
