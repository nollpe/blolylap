package graphics.agents;

import agents.Agent;
import character.Player;
import graphics.IControl;

import java.awt.event.MouseEvent;

/**
 * Agensek kozos kontroll osztalya, kezeli az esemenyeket
 */
public class AgentControl implements IControl {
    Player ownerPlayer;
    Agent owner;
    AgentView view;

    /**
     * Esemenykezelo
     * @param e az esemeny
     */
    @Override
    public void handleEvent(MouseEvent e) {

    }
}
