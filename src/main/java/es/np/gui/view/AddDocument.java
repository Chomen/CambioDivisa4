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
}
