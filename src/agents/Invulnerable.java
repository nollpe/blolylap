package agents;

import agents.Agent;
import character.Player;
import getCastOn.GetCastOnInvulnerable;
import getCastOn.GetCastOnNormal;
import tester.testerClass;

public class Invulnerable extends Agent
{
    public void takeEffect(Player player)
    {
        player.setGetCastOn(new GetCastOnInvulnerable());
        testerClass.print();
    }

    public void loseEffect(Player player)
    {
        player.setGetCastOn(new GetCastOnNormal());
        testerClass.print();
    }
}
