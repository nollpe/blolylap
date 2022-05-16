package graphics.Equipments;

import character.Inventory;
import equipment.Bag;

import javax.swing.*;

public class BagControl extends EquipmentControl {

    private JFrame frame = new JFrame();
    private Bag bag;
    private Inventory playerInventory;
    private Inventory bagInventory;
    private JPanel bagAminoAcid = new JPanel();
    private JPanel bagNucleotide = new JPanel();
    private JPanel playerAminoAcid = new JPanel();
    private JPanel playerNucleotide = new JPanel();
    private JPanel aminoIncrease = new JPanel();
    private JPanel aminoDecrease = new JPanel();
    private JPanel nucleotideIncrease = new JPanel();
    private JPanel nucleotideDecrease = new JPanel();
    private JLabel bagAminoAcidLabel = new JLabel();
    private JLabel bagNucleotideLabel = new JLabel();
    private JLabel playerAminoAcidLabel = new JLabel();
    private JLabel playerNucleotideLabel = new JLabel();

    @Override
    public void handleEvent() {
    }

    public BagControl(Bag bag, Inventory playerInventory) {
        this.bag = bag;
        this.bagInventory = bag.getInventory();
        this.playerInventory = playerInventory;
        frame.setSize(300, 280);
        bagNucleotide.setBounds(10, 10, 50, 50);
        bagAminoAcid.setBounds(240, 10, 50, 50);

        nucleotideIncrease.setBounds(10, 80, 50, 50);
        aminoIncrease.setBounds(240, 80, 50, 50);

        nucleotideDecrease.setBounds(10, 150, 50, 50);
        aminoDecrease.setBounds(240, 150, 50, 50);

        playerNucleotide.setBounds(10, 220, 50, 50);
        playerAminoAcid.setBounds(240, 220, 50, 50);

        Update();

        frame.setVisible(true);
    }

    public void Update() {

        bagAminoAcidLabel.setText(String.valueOf(bagInventory.getAminoAcid()));
        bagNucleotideLabel.setText(String.valueOf(bagInventory.getNucleotide()));
        playerAminoAcidLabel.setText(String.valueOf(playerInventory.getAminoAcid()));
        playerNucleotideLabel.setText(String.valueOf(playerInventory.getNucleotide()));
    }

}
