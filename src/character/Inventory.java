package character;

import tester.testerClass;

public class Inventory {
    private int aminoAcid;
    private int nucleotide;
    private int maxResource;

    /**
     * @param max a maximum tárolási kapacitás, összesen ennyi alapanyag fér bele
     */
    public Inventory(int max) {
        aminoAcid = 0;
        nucleotide = 0;
        maxResource = max;
    }

    /**
     * @param added ennyi nucleotidot akarunk belerakni
     * @return ennyi nukleotidot sikerült belerakni
     */
    public int addNucleotide(int added) {
        if (aminoAcid + nucleotide + added <= maxResource) {
            nucleotide += added;
            return added;
        } else {
            int actuallyAdded = maxResource - aminoAcid - nucleotide;
            nucleotide += actuallyAdded;
            return actuallyAdded;
        }
    }

    /**
     * @param added ennyi aminosavat akarunk belerakni
     * @return ennyi aminosavat sikerült belerakni
     */
    public int addAminoAcid(int added) {
        if (aminoAcid + nucleotide + added <= maxResource) {
            aminoAcid += added;
            return added;
        } else {
            int actuallyAdded = maxResource - aminoAcid - nucleotide;
            aminoAcid += actuallyAdded;
            return actuallyAdded;
        }
    }

    /**
     * @param take ennyi amiosavat akarunk kivenni
     * @return ennyi aminosavat sikerült kivenni
     */
    public int takeAminoAcid(int take) {
        if (take <= aminoAcid) {
            aminoAcid -= take;
            return take;
        } else {
            int temp = aminoAcid;
            aminoAcid = 0;
            return temp;
        }
    }

    /**
     * @param take ennyi nukleotidot akarunk kivenni
     * @return ennyi nukleotidot sikerült kivenni
     */
    public int takeNucleotide(int take) {
        if (take <= nucleotide) {
            nucleotide -= take;
            return take;
        } else {
            int temp = nucleotide;
            nucleotide = 0;
            return temp;
        }
    }

    /**
     * Megmondja hány nukleotid van az inventoryban
     *
     * @return Nukleotidok száma
     */
    public int getNucleotide() {
        return nucleotide;
    }


    /**
     * Megmondja hány aminó acid van az inventoryban
     *
     * @return Amino acidok száma
     */
    public int getAminoAcid() {
        return aminoAcid;
    }
}
