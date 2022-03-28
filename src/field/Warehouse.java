package field;
import character.Inventory;
import tester.testerClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Warehouse extends Field
{
    private Inventory stored;

    public Warehouse()
    {
        super();
        stored=new Inventory(50);   //igazából mindegy mekkora
        testerClass.print();             //csajse
    }

    public void showLoot()
    {
        testerClass.print();
        int AminoAcids = stored.getAminoAcid();
        int Nukleotides = stored.getNukleotide();
    }


    public void tick()
    {
        testerClass.print();
        super.tick();

        System.out.println("mennyi amino acid és nucleotide termelődjön(1-5)?: \n<int>\n<int>");

        int nuc=0;
        int ami=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            nuc=Integer.parseInt(br.readLine());
            ami=Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //chosen=getchar();
        stored.addAminoAcid(ami);
        stored.addNucleotide(nuc);


    }

    public void takeLoot()
    {
        testerClass.print();
    }

    public Inventory getStored() {
        return stored;
    }

    public int takeNucleotide(int taken)
    {

        testerClass.print();
        return taken;
    }

    public int takeAminoAcid(int taken)
    {
        testerClass.print();
        return taken;
    }

    public void setStored(Inventory stored) {
        this.stored = stored;
    }

}

