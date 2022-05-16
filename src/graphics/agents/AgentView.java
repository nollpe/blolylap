package graphics.agents;

import graphics.IView;

import javax.swing.*;
import java.awt.*;

public class AgentView implements IView
{
    AgentControll control;

    public AgentView(AgentControll c){
        control = c;
        label.setBounds(0,0,60,60);
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/agent.png");
        image = image.getScaledInstance(60,60,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }

    public void Update()
    {

    }

    public void Event()
    {

    }


}
