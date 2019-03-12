package com.ocho.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClient {
    private JTextField personName;
    private JLabel labelPersonName;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox IdentityTypeBox;
    private JButton altaButton;
    private JPanel addClientPanel;
    private JFormattedTextField formattedTextField;
    private JTextField textField5;
    private JButton button1;

    public AddClient() {
        altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new AddClient().addClientPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
