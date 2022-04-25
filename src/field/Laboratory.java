package field;

import agents.GeneticCode;
import equipment.Equipment;
import tester.testerClass;

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
        testerClass.print();
        System.out.println(readableGeneticCode.getAgentType());
    }

    /**
     * Időben lépteti a labort
     */
    public void tick() {
        super.tick();
        testerClass.print();

    }

    /**
     * Loot elvétele a laboratóriumból
     */
    public void takeLoot() {
        testerClass.print();
    }

    /**
     * A genetikus kód megtanulása
     *
     * @return labor genetikus kódjának klónja
     */
    public GeneticCode readGeneticCode() {
        testerClass.print();
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
        testerClass.print();
    }

    @Override
    public void vezerles_getstat() {
        super.vezerles_getstat();
        System.out.println("Loot:");
        System.out.println(readableGeneticCode.getAgentType());
    }
}
