package graphics.loot;

import graphics.IView;

import javax.swing.*;
/**
 * A kulonbozo mezok lootviewihoz tartozo interface
 */
public interface LootView extends IView {
    /**
     * Visszaadja a labelt, amire az adott grafikus elem krajzolasra kerul.
     * @return a label
     */
    @Override
    JLabel getLabel();

    /**
     * Friss adatok kirajzolasa.
     */
    @Override
    void Update();
    /**
     * Esemenykezelo
     */
    @Override
    void Event();
}
