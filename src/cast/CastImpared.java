package cast;

import character.Player;
import tester.testerClass;

public class CastImpared implements Cast
{

    @Override
    public boolean cast(Player player) {
        testerClass.print();
        return false;
    }
}
