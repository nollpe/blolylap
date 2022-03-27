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

    /**
     * Az ágens fel lett kenve valakire elkezdi kifejeteni hatását
     * @param player A játékos akinek a karakterére rákenték az ágenst
     */
    public void takeEffect(Player player)
    {
       testerClass.print();
        player.setCast(new CastImpared());
        player.setMovement(new MovementChorea());
        player.setLoot(new LootImpared());
        player.addActiveAgent(this);
    }

    /**
     * Az ágens hatása lejár
     * @param player A játékos akinek a karakterén van az ágens
     */
    public void loseEffect(Player player)
    {
        testerClass.print();
        player.setCast(new CastNormal());
        player.setMovement(new MovementNormal());
        player.setLoot(new LootNormal());
        player.removeActiveAgent(this);

    }
}
