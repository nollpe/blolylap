package graphics.loot;

import graphics.IView;

import javax.swing.*;

public interface LootView extends IView {
    @Override
    JLabel getLabel();

    @Override
    void Update();

    @Override
    void Event();
}
