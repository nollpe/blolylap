package graphics.agents;

import javax.swing.*;
import java.awt.*;

public class ChoreaView extends AgentView {
    public ChoreaView() {
        super();
        Image image = Toolkit.getDefaultToolkit().getImage("kepek/Chorea.png");
        image = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }
}
