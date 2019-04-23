package es.np.gui.controller;

import es.np.ctrl.dto.ClientDTO;
import es.np.ctrl.dto.OperationDTO;
import es.np.ctrl.ops.ClientAccess;
import es.np.ctrl.ops.DocAccess;
import es.np.ctrl.ops.OperationAccess;
import es.np.gui.model.DTOModel;
import es.np.gui.view.MainMenu;
import es.np.gui.view.NewOperation;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.Date;

public class NewOperationController {
    private NewOperation newOperation;
    private JButton newOpBut;

    private JFrame parentMenu;
    public NewOperationController(JFrame parentMenu){
        this.parentMenu=parentMenu;
        initComponents();
        initListeners();
    }


    private void initComponents() {
        newOperation = new NewOperation();
        newOpBut= newOperation.getNewOpBut();
    }

    private void initListeners() {

        newOpBut.addActionListener(new NewOperationButListener());

    }

    public void showFrame() {
        newOperation.setVisible(true);
    }



    private class NewOperationButListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            OperationDTO oDTO= new OperationDTO();





            try {

                oDTO.setOperationType(newOperation.getComboBoxOpType().getSelectedItem().toString());
                oDTO.setInputCurrency(newOperation.getInCurr().getText());
                oDTO.setOutputCurrency(newOperation.getOutCurr().getText());
                oDTO.setClientDTO(DTOModel.clientDTO);
                oDTO.setCurrencyExchange(newOperation.getCurrencyExchange().getText());
                oDTO.setOperationDate(new Date());
                oDTO= OperationAccess.addOperation(oDTO);

            } catch (GeneralSecurityException | IOException | ParseException e1) {
                JOptionPane.showMessageDialog(null,"Ha habido un error dando de alta el cliente: " + e1.getLocalizedMessage());
            }
            newOperation.dispose();
            parentMenu.setVisible(true);
            parentMenu.setEnabled(true);
            DTOModel.operationDTO=oDTO;
            System.out.println(DTOModel.operationDTO);

        }
    }
}
