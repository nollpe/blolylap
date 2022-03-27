package agents;

import agents.Agent;
import cast.CastImpared;
import cast.CastNormal;
import character.Player;
import loot.LootImpared;
import loot.LootNormal;
import movement.MovementChorea;
import movement.MovementNormal;
import tester.testerClass;

public class Chorea extends Agent
{
    public Chorea()
    {
        super();
        testerClass.print();
    }

    public void takeEffect(Player player)
    {
       testerClass.print();
        player.setCast(new CastImpared());
        player.setMovement(new MovementChorea());
        player.setLoot(new LootImpared());
        player.addActiveAgent(this);
    }

    public void loseEffect(Player player)
    {
        testerClass.print();
        player.setCast(new CastNormal());
        player.setMovement(new MovementNormal());
        player.setLoot(new LootNormal());
        player.removeActiveAgent(this);

    }
}
