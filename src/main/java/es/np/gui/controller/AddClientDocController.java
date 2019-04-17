package es.np.gui.controller;

import es.np.ctrl.dto.ClientDTO;
import es.np.ctrl.dto.DocumentDTO;
import es.np.ctrl.ops.ClientAccess;
import es.np.ctrl.ops.DocAccess;
import es.np.gui.model.DTOModel;
import es.np.gui.view.AddClient;
import es.np.gui.view.AddDocument;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddClientDocController {
    private AddClient addClient;
    private AddDocument addDocument;
    private JButton addClientButton;
    private JButton addDocButton;


    public AddClientDocController(){
        initComponents();
        initListeners();
    }

    private void initComponents() {
        addClient = new AddClient();
        addDocument= new AddDocument();
        addClientButton = addClient.getAltaButton();
        addDocButton=addDocument.getAddDocButton();
    }
    private void initListeners() {

        addClientButton.addActionListener(new AltaButtonListener());
        addDocButton.addActionListener(new AddDocButtonListener());
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

            try {
                DTOModel.clientDTO=ClientAccess.addClient(cDTO);
            } catch (GeneralSecurityException | IOException | ParseException e1) {
                JOptionPane.showMessageDialog(null,"Ha habido un error dando de alta el cliente: " + e1.getLocalizedMessage());
            }
            addClient.setVisible(false);
            addDocument.setVisible(true);
        }
    }


    private class AddDocButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DocumentDTO dDTO = new DocumentDTO();
            dDTO.setClientId(DTOModel.clientDTO.getClientId());
            dDTO.setCountry(addDocument.getCountryField().getText());
            dDTO.setDocNumber(addDocument.getDocNumberField().getText());
            dDTO.setDocType((String)addDocument.getDocTypeBox().getSelectedItem());

            try {
                dDTO.transformStrExpirationDateToDate(addDocument.getExpirDateField().getText());

                DTOModel.clientDTO.getListDocuments().add(DocAccess.addDocument(dDTO));
            } catch (GeneralSecurityException | IOException | ParseException e1) {
                JOptionPane.showMessageDialog(null,"Ha habido un error dando de alta el documento: " + e1.getLocalizedMessage());
            }

            addDocument.setVisible(false);
            addClient.setVisible(true);
        }
    }
}
