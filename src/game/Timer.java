package game;

/**
 * A játékban körökért felelős osztály
 */
public class Timer {
    private Game game;

    public void tick() {

        game.Tick();
    }

    private Timer() {

        game = Game.getInstance();
    }

    public void setGame() {
        game = Game.getInstance();
    }

    private static Timer singleInstance = null;

    /**
     * visszaadja az egyetlen timer egyedet a programban, ha nem létezik létrehozza
     *
     * @return az egyetlen Timer egyed
     */
    public static Timer getInstance() {
        if (singleInstance == null) {
            singleInstance = new Timer();
        }
        return singleInstance;
    }

}
