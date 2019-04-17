package es.np.gui.view;

import javax.swing.*;

public class NewOperation extends  JFrame{
    private JPanel newOperationPanel;
    private JButton newOpBut;
    private JComboBox comboBoxOpType;
    private JTextField inCurr;
    private JTextField outCurr;
    private JTextField currencyExchange;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JButton getNewOpBut() {
        return newOpBut;
    }

    public void setNewOpBut(JButton newOpBut) {
        this.newOpBut = newOpBut;
    }

    public JComboBox getComboBoxOpType() {
        return comboBoxOpType;
    }

    public void setComboBoxOpType(JComboBox comboBoxOpType) {
        this.comboBoxOpType = comboBoxOpType;
    }

    public JTextField getInCurr() {
        return inCurr;
    }

    public void setInCurr(JTextField inCurr) {
        this.inCurr = inCurr;
    }

    public JTextField getOutCurr() {
        return outCurr;
    }

    public void setOutCurr(JTextField outCurr) {
        this.outCurr = outCurr;
    }

    public JTextField getCurrencyExchange() {
        return currencyExchange;
    }

    public void setCurrencyExchange(JTextField currencyExchange) {
        this.currencyExchange = currencyExchange;
    }
}
