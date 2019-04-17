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

public class NewOperationController {
    private NewOperation newOperation;
    private JButton newOpBut;

    public NewOperationController(){
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
                //TODO cDTO.getListDocuments().add(new DocumentDTO(Long.parseLong(searchClient.getDocIdField().getText())));

                oDTO.setOperationId(Long.parseLong(OperationAccess.addOperation(oDTO)));
            } catch (GeneralSecurityException | IOException | ParseException e1) {
                JOptionPane.showMessageDialog(null,"Ha habido un error dando de alta el cliente: " + e1.getLocalizedMessage());
            }
            newOperation.dispose();
            DTOModel.operationDTO=oDTO;
            System.out.println(DTOModel.operationDTO);

        }
    }
}
