package agents;

import character.Player;
import tester.testerClass;

/**
 * Ágens amit a játékosok egymásra kenhetnek
 */

public class Agent
{
    int timeToLive;
    public Agent()
    {
        testerClass.print();
    }

    public int getTimeToLive()
    {
        return timeToLive;
    }

    public void setTimeToLive(int i)
    {
        timeToLive=i;
    }

    /**
     * Az ágens fel lett kenve valakire elkezdi kifejeteni hatását
     * @param player A játékos akinek a karakterére rákenték az ágenst
     */
    public void takeEffect(Player player)
    {
        testerClass.print();
    }

    /**
     * Az ágens hatása lejár
     * @param player A játékos akinek a karakterén van az ágens
     */
    public void loseEffect(Player player)
    {
        testerClass.print();
    }

    public void tick()
    {
        testerClass.print();
        timeToLive--;
    }



}