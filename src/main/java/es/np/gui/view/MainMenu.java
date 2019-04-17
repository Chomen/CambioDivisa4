package es.np.gui.view;

import javax.swing.*;

public class MainMenu extends JFrame{
    private JPanel mainPanel;
    private JButton addClientBut;
    private JButton searchClientBut;
    private JButton createOperationBut;
    private JPanel prueba;


    public MainMenu() {
        setSize(500,500);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
    }


    public JButton getAddClientBut() {
        return addClientBut;
    }

    public void setAddClientBut(JButton addClientBut) {
        this.addClientBut = addClientBut;
    }

    public JButton getSearchClientBut() {
        return searchClientBut;
    }

    public void setSearchClientBut(JButton searchClientBut) {
        this.searchClientBut = searchClientBut;
    }

    public JButton getCreateOperationBut() {
        return createOperationBut;
    }

    public void setCreateOperationBut(JButton createOperationBut) {
        this.createOperationBut = createOperationBut;
    }
}
