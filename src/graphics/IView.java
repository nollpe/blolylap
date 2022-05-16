package graphics;

import javax.swing.*;

public interface IView {
    public JLabel label = new JLabel();

    public static JLabel getLabel() {
        return label;
    }

    public void Update();

    public void Event();
}
