package agents;

import agents.Agent;
import character.Player;
import tester.testerClass;

import java.util.LinkedList;

public class Forget extends Agent
{
    //LinkedList<GeneticCode> forgotten;
    public void takeEffect(Player player)
    {
        testerClass.print();
        player.forgetAllGeneticCodes();
    }

    public void loseEffect(Player player)
    {
        testerClass.print();
    }
}
