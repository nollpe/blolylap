package agents;

import agents.Agent;
import cast.CastImpared;
import cast.CastNormal;
import character.Player;
import getCastOn.GetCastOnNormal;
import getLootTakenFrom.LootTakenNormal;
import getLootTakenFrom.LootTakenStunned;
import loot.LootImpared;
import loot.LootNormal;
import movement.MovementNormal;
import movement.MovementParalyzed;
import tester.testerClass;

public class Paralyzing extends Agent
{
    public Paralyzing()
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
        player.setLoot(new LootImpared());
        player.setMovement(new MovementParalyzed());
        player.setCast(new CastImpared());
        player.setGetLootTakenFrom(new LootTakenStunned());
    }

    /**
     * Az ágens hatása lejár
     * @param player A játékos akinek a karakterén van az ágens
     */
    public void loseEffect(Player player)
    {
        testerClass.print();
        player.setLoot(new LootNormal());
        player.setMovement(new MovementNormal());
        player.setCast(new CastNormal());
        player.setGetLootTakenFrom(new LootTakenNormal());
        player.removeActiveAgent(this);
    }
}
