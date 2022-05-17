package graphics.agents;

import field.Field;

import javax.swing.*;
import java.awt.*;

public class ForgetView extends AgentView {
    public ForgetView()
    {
        super();
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/Forget.png");
        image = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }

}
