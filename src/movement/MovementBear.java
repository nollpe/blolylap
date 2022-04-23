package movement;

import agents.Bear;
import character.Player;
import field.Field;

public class MovementBear extends MovementChorea {
    /**
     * Alap konstruktor
     *
     * @param p a játékos, aki stratégiája ez
     */
    public MovementBear(Player p) {
        super(p);
    }

    /**
     * A mozgást végző függvény, egy véletlenszerű irányba mozgatja a játékost, utána megfertőzi a szomszédos
     * játékosokat, majd elpusztítja az összes alapanyogot a helyről
     *
     * @param field a mező, ahova mozgatni akarjuk
     */
    @Override
    public void move(Field field) {
        super.move(field);
        Field location = owner.getLocation();
        for (Player p : location.getInhabitants()) {
            p.getCastOn(new Bear(p), owner);
        }
        // jelenleg nincs implementálva a takeNukleotide és a takeAminoacid fv. minden fieldre
        // location.takeNukleotide(n);
        // location.takeAminoacid(n);
    }
}
