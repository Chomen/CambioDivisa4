package es.np.gui.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDocument extends JFrame {
    private JTextField docNumberField;
    private JComboBox docTypeBox;
    private JTextField expirDateField;
    private JButton addscanField;
    private JButton addDocButton;
    private JTextField countryField;
    private JPanel addDocPanel;
    private long clientId;
    public AddDocument(){
        setSize(500,500);
        setContentPane(addDocPanel);
        setLocationRelativeTo(null);
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public JButton getAddDocButton() {
        return addDocButton;
    }

    public void setAddDocButton(JButton addDocButton) {
        this.addDocButton = addDocButton;
    }

    public JTextField getDocNumberField() {
        return docNumberField;
    }

    public void setDocNumberField(JTextField docNumberField) {
        this.docNumberField = docNumberField;
    }

    public JTextField getExpirDateField() {
        return expirDateField;
    }

    public void setExpirDateField(JTextField expirDateField) {
        this.expirDateField = expirDateField;
    }

    public JTextField getCountryField() {
        return countryField;
    }

    public void setCountryField(JTextField countryField) {
        this.countryField = countryField;
    }

    public JComboBox getDocTypeBox() {
        return docTypeBox;
    }

    public void setDocTypeBox(JComboBox docTypeBox) {
        this.docTypeBox = docTypeBox;
    }
}
