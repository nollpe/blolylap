package graphics.Equipments;

import equipment.Equipment;
import field.Field;
import graphics.IView;

import javax.swing.*;
import java.awt.*;

public class EquipmentView implements IView
{
    EquipmentControll control;
    Equipment equipment;

    public EquipmentView(Rectangle r, String ImageName, Equipment e)
    {

        label.setBounds(r);
        equipment=e;

        Image image = Toolkit.getDefaultToolkit().getImage(ImageName);
        image = image.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }

    public void Update()
    {

    }

    public void Event()
    {

    }


}
