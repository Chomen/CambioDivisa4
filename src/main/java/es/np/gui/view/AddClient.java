package es.np.gui.view;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class AddClient extends JFrame{
    private JTextField personName;
    private JLabel labelPersonName;
    private JTextField surname1;
    private JTextField surname2;

    private JTextField birthDateStr;
    private JButton altaButton;
    private JPanel addClientPanel;
    private JFormattedTextField formattedPhoneNumber;
    private JTextField nationality;
    private JComboBox ResidentComboBox;



    public AddClient() {
        setSize(500,500);
        setContentPane(addClientPanel);
        setLocationRelativeTo(null);
    }




    private void createUIComponents() {
        formattedPhoneNumber= new JFormattedTextField();

        formattedPhoneNumber.setFormatterFactory(
                new DefaultFormatterFactory(
                        new NumberFormatter(NumberFormat.getIntegerInstance())));

    }
    public JButton getAltaButton() {
        return altaButton;
    }

    public void setAltaButton(JButton altaButton) {
        this.altaButton = altaButton;
    }

    public JTextField getPersonName() {
        return personName;
    }

    public void setPersonName(JTextField personName) {
        this.personName = personName;
    }

    public JTextField getSurname1() {
        return surname1;
    }

    public void setSurname1(JTextField surname1) {
        this.surname1 = surname1;
    }

    public JTextField getSurname2() {
        return surname2;
    }

    public void setSurname2(JTextField surname2) {
        this.surname2 = surname2;
    }

}
