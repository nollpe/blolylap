package field;

import character.Inventory;
import tester.testerClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Warehouse extends Field {
    private Inventory stored;

    public Warehouse() {
        super();
        stored = new Inventory(50);   //igazából mindegy mekkora
        testerClass.print();             //csajse
    }
    public Warehouse(String n)
    {
        this();
        Name=n;
    }

    /**
     * Megmutatja melyik alapanyagból mennyi található itt
     */
    public void showLoot() {
        testerClass.print();
        System.out.println("aminosav :" + stored.getAminoAcid() + "\nnukleotid: " + stored.getNukleotide());
    }


    /**
     * minden körben van esély, hogy "termelődik" új aminosav és nukleotid
     */
    public void tick() {
        testerClass.print();
        super.tick();

        //TODO ezt am basszuk már ki innen és generáljon random eséllyel ha nincs benne semmi
        System.out.println("mennyi amino acid és nucleotide termelődjön(1-5)?: \n<int>\n<int>");

        int nuc = 0;
        int ami = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            nuc = Integer.parseInt(br.readLine());
            ami = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stored.addAminoAcid(ami);
        stored.addNucleotide(nuc);


    }

    public void takeLoot() {
        testerClass.print();
    }

    public Inventory getStored() {
        return stored;
    }

    /**
     * @param taken ennyi nukleotidot akarunk kivenni
     * @return ennyi nukleotidot sikerült kivenni
     */
    public int takeNucleotide(int taken) {
        testerClass.print();
        return stored.takeNucleotide(taken);
    }

    /**
     * @param taken ennyi amiosavat akarunk kivenni
     * @return ennyi aminosavat sikerült kivenni
     */
    public int takeAminoAcid(int taken) {
        testerClass.print();
        return stored.takeAminoAcid(taken);
    }

    public void setStored(Inventory stored) {
        this.stored = stored;
    }

    @Override
    public void vezerles_getstat() {
        super.vezerles_getstat();
        System.out.println("Loot:");
        System.out.println("nucleotide: " + stored.getNukleotide() + " aminoacid: " + stored.getAminoAcid());
    }
}

