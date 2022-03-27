package getCastOn;
import agents.Agent;
import character.Player;
import tester.testerClass;

public class GetCastOnNormal implements GetCastOn
{
    @Override
    public void getCastOn(Agent a, Player player, Player attacker)
    {
        testerClass.print();
        a.takeEffect(player);
    }
}
