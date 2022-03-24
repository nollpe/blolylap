package game;

public class Timer
{
    private Game game;

    public void tick()
    {

    }

    private Timer()
    {

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
