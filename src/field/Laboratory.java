package field;

import agents.GeneticCode;

import equipment.Equipment;
import graphics.fields.LaboratoryView;
import tester.testerClass;


import java.awt.*;

public class Laboratory extends Field {
    /**
     * A labor által tartalmazott genetikus kód
     * Ezt tudják megtanulni a playerek
     * Ennek a klónját adja át a tanuláshoz
     */
    private GeneticCode readableGeneticCode;

    /**
     * Konstruktor
     */
    public Laboratory() {
        super();

        Rectangle r=new Rectangle(0,0,60,60);
        view=new LaboratoryView(r,"kepek/laboratory.png",this);
        testerClass.print();

    }

    public Laboratory(String n) {
        this();
        Name = n;
    }

    /**
     * Megmutatja a laborban található lootot
     */
    public void showLoot() {

        System.out.println(readableGeneticCode.getAgentType());
    }

    /**
     * Időben lépteti a labort
     */
    public void tick() {
        super.tick();


    }

    /**
     * Loot elvétele a laboratóriumból
     */
    public void takeLoot() {

    }

    /**
     * A genetikus kód megtanulása
     *
     * @return labor genetikus kódjának klónja
     */
    public GeneticCode readGeneticCode() {

        GeneticCode gc = readableGeneticCode.clone();
        return readableGeneticCode;
    }

    /**
     * A labor inicializálása
     * megadja a genetikus kódot amit tartalmaz
     *
     * @param gc a laborhoz tartozó genetikus kód
     */
    public void init(GeneticCode gc) {
        readableGeneticCode = gc;

    }

    @Override
    public void vezerles_getstat() {
        super.vezerles_getstat();
        System.out.println("Loot:");
        System.out.println(readableGeneticCode.getAgentType());
    }
}
