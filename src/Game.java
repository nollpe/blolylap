public class Game
{
    private Timer timer;
    private City city;

    //privát konstruktor
    private Game()
    {

    }

    //ebben tároljuk az egyedet
    private static Game singleInstance=null;

    //ezzel tudjuk lekérni az egyedet
    public static Game getInstance()
    {
        //ha még nem létezik létrehozzuk
        if (singleInstance == null)
            singleInstance = new Game();

        return singleInstance;
    }

}
/**
 Azért, hogy singleton legyen:
 privát a konstruktora,
 egy statickus változóban tároljuk az egyetlen egyedet és azt udjuk lekérdezni egy szintén statikus függvénnyel
 így nem tudunk létrhozni egyedet, hanem csak a class tud ami csak egyet fog
 a getInstance függvénnyel lehet elérni

 */
