package graphics.agents;

import javax.swing.*;
import java.awt.*;

public class InvulnerableView extends AgentView {
    public InvulnerableView() {
        super();
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/Invulnerable.png");
        image = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }
}
