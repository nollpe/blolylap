package graphics.Equipments;

import character.Inventory;
import equipment.Bag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A zsak control osztalya
 */
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

    /**
     * Esemeny kezelo
     * @param e az esemeny
     */
    @Override
    public void handleEvent(MouseEvent e) {
    }

    /**
     * A szak inicializalasa, kepek, inventory, mouselistenerek hozzaadasa
     * @param bag A zsak
     * @param playerInventory Az inventory amihez a zsak tartozik
     */
    public BagControl(Bag bag, Inventory playerInventory) {
        Image playerAminoImage = Toolkit.getDefaultToolkit().getImage("kepek/amino_acid.png");
        playerAminoImage = playerAminoImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon playerAminoIcon = new ImageIcon(playerAminoImage);
        playerAminoAcid.setIcon(playerAminoIcon);

        Image bagAminoImage = Toolkit.getDefaultToolkit().getImage("kepek/amino_acid.png");
        bagAminoImage = bagAminoImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon bagAminoIcon = new ImageIcon(bagAminoImage);
        bagAminoAcid.setIcon(bagAminoIcon);

        Image playerNucleotideImage = Toolkit.getDefaultToolkit().getImage("kepek/nucleotide.png");
        playerNucleotideImage = playerNucleotideImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon playerNucleotideIcon = new ImageIcon(playerNucleotideImage);
        playerNucleotide.setIcon(playerNucleotideIcon);

        Image bagNucleotideImage = Toolkit.getDefaultToolkit().getImage("kepek/nucleotide.png");
        bagNucleotideImage = bagNucleotideImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon bagNucleotideIcon = new ImageIcon(bagNucleotideImage);
        bagNucleotide.setIcon(bagNucleotideIcon);

        Image aminoIncreaseImage = Toolkit.getDefaultToolkit().getImage("kepek/player0.png");
        aminoIncreaseImage = aminoIncreaseImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon aminoIncreaseIcon = new ImageIcon(aminoIncreaseImage);
        aminoIncrease.setIcon(aminoIncreaseIcon);

        Image nucleotideIncreaseImage = Toolkit.getDefaultToolkit().getImage("kepek/player0.png");
        nucleotideIncreaseImage = nucleotideIncreaseImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon nucleotideIncreaseIcon = new ImageIcon(nucleotideIncreaseImage);
        nucleotideIncrease.setIcon(nucleotideIncreaseIcon);

        Image aminoDecreaseImage = Toolkit.getDefaultToolkit().getImage("kepek/player0.png");
        aminoDecreaseImage = aminoDecreaseImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon aminoDecreaseIcon = new ImageIcon(aminoDecreaseImage);
        aminoDecrease.setIcon(aminoDecreaseIcon);

        Image nucleotideDecreaseImage = Toolkit.getDefaultToolkit().getImage("kepek/player0.png");
        nucleotideDecreaseImage = nucleotideDecreaseImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon nucleotideDecreaseIcon = new ImageIcon(nucleotideDecreaseImage);
        nucleotideDecrease.setIcon(nucleotideDecreaseIcon);
        this.bag = bag;
        this.bagInventory = bag.getInventory();
        this.playerInventory = playerInventory;
        frame.setSize(300, 320);


        bagNucleotideLabel.setBounds(102, 28, 50, 50);
        bagAminoAcidLabel.setBounds(232, 28, 50, 50);

        playerNucleotideLabel.setBounds(102, 238, 50, 50);
        playerAminoAcidLabel.setBounds(232, 238, 50, 50);

        bagNucleotide.setBounds(60, 10, 50, 50);
        bagAminoAcid.setBounds(190, 10, 50, 50);

        nucleotideIncrease.setBounds(60, 80, 50, 50);
        aminoIncrease.setBounds(190, 80, 50, 50);

        nucleotideDecrease.setBounds(60, 150, 50, 50);
        aminoDecrease.setBounds(190, 150, 50, 50);

        playerNucleotide.setBounds(60, 220, 50, 50);
        playerAminoAcid.setBounds(190, 220, 50, 50);

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


        frame.setLayout(null);
        frame.add(bagNucleotideLabel);
        frame.add(playerNucleotideLabel);
        frame.add(bagAminoAcidLabel);
        frame.add(playerAminoAcidLabel);
        frame.add(bagNucleotide);
        frame.add(playerNucleotide);
        frame.add(bagAminoAcid);
        frame.add(playerAminoAcid);
        frame.add(aminoIncrease);
        frame.add(aminoDecrease);
        frame.add(nucleotideIncrease);
        frame.add(nucleotideDecrease);

        frame.setVisible(true);
    }

    /**
     * Adatok frissitese es kirajzolasa
     */
    public void Update() {
        bagAminoAcidLabel.setText(String.valueOf(bagInventory.getAminoAcid()));
        bagNucleotideLabel.setText(String.valueOf(bagInventory.getNucleotide()));
        playerAminoAcidLabel.setText(String.valueOf(playerInventory.getAminoAcid()));
        playerNucleotideLabel.setText(String.valueOf(playerInventory.getNucleotide()));
    }
}

