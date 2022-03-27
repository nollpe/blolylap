package getCastOn;
import agents.Agent;
import tester.testerClass;
import character.Player;

public class GetCastOnGloves implements GetCastOn
{
    @Override
    public void getCastOn(Agent a, Player player, Player attacker)
    {
        testerClass.print();
        player.setGetCastOn(new GetCastOnNormal());
        attacker.getCastOn(a, player);
    }
}
