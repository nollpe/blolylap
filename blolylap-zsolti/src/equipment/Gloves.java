package equipment;

import character.Player;
import getCastOn.GetCastOnGloves;
import getCastOn.GetCastOnNormal;
import tester.testerClass;

public class Gloves extends Equipment {
    public void takeEffect(Player c) {
        System.out.println("gloves");
        testerClass.print();
        GetCastOnGloves gcog = new GetCastOnGloves();
        c.setGetCastOn(gcog);
    }

    public void loseEffect(Player c) {
        testerClass.print();
        GetCastOnNormal gcon = new GetCastOnNormal();
        c.setGetCastOn(gcon);
    }
}
