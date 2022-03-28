package cast;

import tester.testerClass;

public class CastNormal implements Cast {
    @Override
    public boolean cast() {
        testerClass.print();
        return true;
    }
}
