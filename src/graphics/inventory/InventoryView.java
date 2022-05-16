package graphics.inventory;

import graphics.IView;

import javax.swing.*;

public class InventoryView implements IView {
    InventoryControl control;
    JLabel label = new JLabel();

    public JLabel getLabel() {
        return label;
    }


    @Override
    public void Update() {

    }

    @Override
    public void Event() {

    }
}
