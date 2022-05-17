package graphics.agents;

import javax.swing.*;
import java.awt.*;

public class ParalyzingView extends AgentView {
    public ParalyzingView() {
        super();
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/Paralyzing.png");
        image = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }
}
