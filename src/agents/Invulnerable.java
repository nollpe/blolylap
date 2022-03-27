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
    public Invulnerable()
    {
        super();
        testerClass.print();
    }

    public void loseEffect(Player player)
    {
        testerClass.print();
        player.setGetCastOn(new GetCastOnNormal());
        player.removeActiveAgent(this);
    }
}
