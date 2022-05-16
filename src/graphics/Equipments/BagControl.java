package graphics.Equipments;

import character.Inventory;
import equipment.Bag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BagControl extends EquipmentControl {

    private JFrame frame = new JFrame();
    private Bag bag;
    private Inventory playerInventory;
    private Inventory bagInventory;
    private JLabel bagAminoAcid = new JLabel();
    private JLabel bagNucleotide = new JLabel();
    private JLabel playerAminoAcid = new JLabel();
    private JLabel playerNucleotide = new JLabel();
    private JLabel aminoIncrease = new JLabel();
    private JLabel aminoDecrease = new JLabel();
    private JLabel nucleotideIncrease = new JLabel();
    private JLabel nucleotideDecrease = new JLabel();
    private JLabel bagAminoAcidLabel = new JLabel();
    private JLabel bagNucleotideLabel = new JLabel();
    private JLabel playerAminoAcidLabel = new JLabel();
    private JLabel playerNucleotideLabel = new JLabel();

    @Override
    public void handleEvent() {
    }

    public BagControl(Bag bag, Inventory playerInventory) {

        Image playerAminoImage = Toolkit.getDefaultToolkit().getImage("kepek/amino_acid.png");
        playerAminoImage = playerAminoImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon playerAminoIcon = new ImageIcon(playerAminoImage);
        playerAminoAcid.setIcon(playerAminoIcon);

        Image bagAminoImage = Toolkit.getDefaultToolkit().getImage("kepek/amino_acid.png");
        bagAminoImage = bagAminoImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon bagAminoIcon = new ImageIcon(bagAminoImage);
        bagAminoAcid.setIcon(bagAminoIcon);

        Image playerNucleotideImage = Toolkit.getDefaultToolkit().getImage("kepek/nucleotide.png");
        playerNucleotideImage = playerNucleotideImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon playerNucleotideIcon = new ImageIcon(playerNucleotideImage);
        playerNucleotide.setIcon(playerNucleotideIcon);

        Image bagNucleotideImage = Toolkit.getDefaultToolkit().getImage("kepek/nucleotide.png");
        bagNucleotideImage = bagNucleotideImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon bagNucleotideIcon = new ImageIcon(bagNucleotideImage);
        bagNucleotide.setIcon(bagNucleotideIcon);

        Image aminoIncreaseImage = Toolkit.getDefaultToolkit().getImage("kepek/up.png");
        aminoIncreaseImage = aminoIncreaseImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon aminoIncreaseIcon = new ImageIcon(aminoIncreaseImage);
        aminoIncrease.setIcon(aminoIncreaseIcon);

        Image nucleotideIncreaseImage = Toolkit.getDefaultToolkit().getImage("kepek/up.png");
        nucleotideIncreaseImage = nucleotideIncreaseImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon nucleotideIncreaseIcon = new ImageIcon(nucleotideIncreaseImage);
        nucleotideIncrease.setIcon(nucleotideIncreaseIcon);

        Image aminoDecreaseImage = Toolkit.getDefaultToolkit().getImage("kepek/down.png");
        aminoDecreaseImage = aminoDecreaseImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon aminoDecreaseIcon = new ImageIcon(aminoDecreaseImage);
        aminoDecrease.setIcon(aminoDecreaseIcon);

        Image nucleotideDecreaseImage = Toolkit.getDefaultToolkit().getImage("kepek/down.png");
        nucleotideDecreaseImage = nucleotideDecreaseImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon nucleotideDecreaseIcon = new ImageIcon(nucleotideDecreaseImage);
        nucleotideDecrease.setIcon(nucleotideDecreaseIcon);

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

        bagNucleotideLabel.setBounds(45, 45, 5, 5);
        bagAminoAcidLabel.setBounds(45, 45, 5, 5);
        playerNucleotideLabel.setBounds(45, 45, 5, 5);
        playerAminoAcidLabel.setBounds(45, 45, 5, 5);

        Update();

        nucleotideIncrease.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int taken = playerInventory.takeNucleotide(1);
                bagInventory.addNucleotide(taken);
                Update();
            }
        });
        aminoIncrease.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int taken = playerInventory.takeAminoAcid(1);
                bagInventory.addAminoAcid(taken);
                Update();
            }
        });
        nucleotideDecrease.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int taken = bagInventory.takeNucleotide(1);
                playerInventory.addNucleotide(taken);
                Update();
            }
        });
        aminoDecrease.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int taken = bagInventory.takeAminoAcid(1);
                playerInventory.addAminoAcid(taken);
                Update();
            }
        });

        bagNucleotide.add(bagNucleotideLabel);
        playerNucleotide.add(playerNucleotideLabel);
        bagAminoAcid.add(bagAminoAcidLabel);
        playerAminoAcid.add(playerAminoAcidLabel);

        frame.setVisible(true);
    }

    public void Update() {
        bagAminoAcidLabel.setText(String.valueOf(bagInventory.getAminoAcid()));
        bagNucleotideLabel.setText(String.valueOf(bagInventory.getNucleotide()));
        playerAminoAcidLabel.setText(String.valueOf(playerInventory.getAminoAcid()));
        playerNucleotideLabel.setText(String.valueOf(playerInventory.getNucleotide()));
    }

}
