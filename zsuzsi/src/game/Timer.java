package game;

import tester.testerClass;

public class Timer
{
    private Game game;

    public void tick()
    {
        testerClass.print();
        game.Tick();
    }

    private Timer()
    {
        testerClass.print();
        game=Game.getInstance();
    }

    private static Timer singleInstance =null;

    public static Timer getInstance()
    {
        if(singleInstance == null)
        {
            singleInstance = new Timer();
        }
        return singleInstance;
    }

}
