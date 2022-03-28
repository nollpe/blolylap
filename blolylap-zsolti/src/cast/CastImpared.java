package cast;

import tester.testerClass;

public class CastImpared implements Cast {

    @Override
    public boolean cast() {
        testerClass.print();
        return false;
    }
}
