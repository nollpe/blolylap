package graphics.agents;

import agents.Agent;
import character.Player;
import graphics.IControl;

import java.awt.event.MouseEvent;

public class AgentControl implements IControl {
    Player ownerPlayer;
    Agent owner;
    AgentView view;

    @Override
    public void handleEvent(MouseEvent e) {

    }
}
