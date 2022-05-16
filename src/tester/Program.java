package tester;

import game.Game;

public class Program {

    public Program() {

    }

    /**
     * Main függvény
     * Innen vezéreljük a konzolon kersztüli tesztelést
     *
     * @param args bemeneti argumentumok (nem használt)
     */
    public static void main(String[] args) {
        Game C = Game.getInstance();
        C.startGame();
    }
}