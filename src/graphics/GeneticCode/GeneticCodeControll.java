package graphics.GeneticCode;

import agents.GeneticCode;
import character.Player;
import graphics.IControl;

import java.awt.event.MouseEvent;

/**
 * A genetikai kod kontroll oszatlay, kezeli az esemenyeket
 */
public class GeneticCodeControll implements IControl {
    GeneticCode owner;
    Player ownerPlayer;
    GeneticCodeView view;

    /**
     * Esemeny kezelo
     * @param e az esemeny
     */
    @Override
    public void handleEvent(MouseEvent e) {

    }
}
