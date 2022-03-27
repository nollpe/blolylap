package equipment;

import character.Player;
import getCastOn.GetCastOnNormal;
import getCastOn.GetCastOnResistant;
import tester.testerClass;

public class Labcoat extends Equipment {
    public void takeEffect(Player c) {
        testerClass.print();
        GetCastOnResistant gcor = new GetCastOnResistant();
        c.setGetCastOn(gcor);
    }

    public void loseEffect(Player c) {
        testerClass.print();
        GetCastOnNormal gcon = new GetCastOnNormal();
        c.setGetCastOn(gcon);
    }
}
