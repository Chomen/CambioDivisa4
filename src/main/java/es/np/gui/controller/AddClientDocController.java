package es.np.gui.controller;

import es.np.ctrl.dto.ClientDTO;
import es.np.ctrl.ops.ClientAccess;
import es.np.gui.model.DTOModel;
import es.np.gui.view.AddClient;
import es.np.gui.view.AddDocument;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;

public class AddClientDocController {
    private AddClient addClient;
    private AddDocument addDocument;
    private JButton altaButton;

    public AddClientDocController(){
        initComponent();
        initListeners();
    }

    private void initListeners() {
        altaButton.addActionListener(new AltaButtonListener());
    }

    private void initComponent() {
        addClient = new AddClient();
        addDocument= new AddDocument();
        altaButton = addClient.getAltaButton();
    }

    public void showFrame() {
        addClient.setVisible(true);
    }

    private class AltaButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ClientDTO cDTO = new ClientDTO();
            cDTO.setName(addClient.getPersonName().getText());
            cDTO.setSurname1(addClient.getSurname1().getText());
            cDTO.setSurname2(addClient.getSurname2().getText());
            DTOModel.clientDTO=cDTO;
            try {
                ClientAccess.addClient(cDTO);
            } catch (GeneralSecurityException | IOException | ParseException e1) {
                JOptionPane.showMessageDialog(null,"Ha habido un error dando de alta el cliente: " + e1.getLocalizedMessage());
            }
            addClient.setVisible(false);
            addDocument.setVisible(true);
        }
    }


}
