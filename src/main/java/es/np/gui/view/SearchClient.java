package es.np.gui.view;

import javax.swing.*;

public class SearchClient extends JFrame{
    private JTextField docIdField;
    private JTextField clientIdField;
    private JButton searchClientBut;
    private JPanel searchPanel;
    private JTextField phoneField;

    public JButton getSearchClientBut() {
        return searchClientBut;
    }

    public void setSearchClientBut(JButton searchClientBut) {
        this.searchClientBut = searchClientBut;
    }

    public SearchClient(){
        setSize(500,500);
        setContentPane(searchPanel);
        setLocationRelativeTo(null);
    }

    public JTextField getDocIdField() {
        return docIdField;
    }

    public void setDocIdField(JTextField docIdField) {
        this.docIdField = docIdField;
    }

    public JTextField getClientIdField() {
        return clientIdField;
    }

    public void setClientIdField(JTextField clientIdField) {
        this.clientIdField = clientIdField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public void setPhoneField(JTextField phoneField) {
        this.phoneField = phoneField;
    }
}
