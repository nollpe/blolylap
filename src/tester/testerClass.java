package tester;

import game.City;

public class testerClass {

    public testerClass()
    {

    }

    public static void print()
    {
        String className=new Exception().getStackTrace()[1].getClassName();
        String methodName1=new Exception().getStackTrace()[1].getMethodName();
        int depth1=new Exception().getStackTrace().length;
        String filler="\t".repeat(depth1-2);

        System.out.println(filler + className + " " + methodName1);
    }

    public void wiewCity() {

        print();

        City c= new City();
        c.showCity();
    }

    public static void main(String[] args)
    {
        testerClass ts= new testerClass();
        ts.wiewCity();
    }
}
