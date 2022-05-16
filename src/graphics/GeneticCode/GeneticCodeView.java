package graphics.GeneticCode;

import agents.GeneticCode;
import character.Player;
import graphics.IView;

import java.util.LinkedList;

public class GeneticCodeView implements IView {
    GeneticCodeControll control;
    Player ownerPlayer;
    GeneticCode owner;

    public GeneticCodeView(GeneticCode o, Player p) {
        owner = o;
        ownerPlayer = p;
    }

    public LinkedList<GeneticCode> getGeneticCodes() {
        return ownerPlayer.getGeneticCodes();
    }

    @Override
    public void Update() {

    }

    @Override
    public void Event() {

    }
}
