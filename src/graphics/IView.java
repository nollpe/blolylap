package graphics;

import javax.swing.*;

/**
 * A view osztalyok inteface
 */
public interface IView {
    /**
     * Visszaadja az inventoryhoz tartozo labelt
     * @return  a label
     */
    JLabel getLabel();

    /**
     * Adatok frissitese es kirajzolasa
     */
    void Update();

    /**
     * Esemeny kezeles
     */
    void Event();
}
