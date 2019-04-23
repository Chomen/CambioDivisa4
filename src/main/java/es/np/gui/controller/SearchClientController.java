package es.np.gui.controller;

import es.np.ctrl.dto.ClientDTO;
import es.np.ctrl.dto.DocumentDTO;
import es.np.ctrl.ops.ClientAccess;
import es.np.gui.model.DTOModel;
import es.np.gui.view.MainMenu;
import es.np.gui.view.SearchClient;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;

public class SearchClientController {
    private SearchClient searchClient;
    private JButton searchClientBut;
    private JFrame parentMenu;
    public SearchClientController(JFrame parentMenu){
        this.parentMenu=parentMenu;
        initComponents();
        initListeners();
    }


    private void initComponents() {

        searchClient= new SearchClient();
        searchClient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchClientBut = searchClient.getSearchClientBut();

    }

    private void initListeners() {

        searchClientBut.addActionListener(new SearchClientListener());


    }

    public void showFrame() {
        searchClient.setVisible(true);
    }

    private class SearchClientListener implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {
            ClientDTO cDTO = new ClientDTO();




            try {
                if (!StringUtils.isEmpty(searchClient.getClientIdField().getText())) {
                    cDTO.setClientId(Long.parseLong(searchClient.getClientIdField().getText()));
                }
                //TODO cDTO.getListDocuments().add(new DocumentDTO(Long.parseLong(searchClient.getDocIdField().getText())));
                if (!StringUtils.isEmpty(searchClient.getPhoneField().getText())) {
                    cDTO.setPhoneNumber(Long.parseLong(searchClient.getPhoneField().getText()));
                }
                DTOModel.clientDTO= ClientAccess.lookupClient(cDTO);
            } catch (GeneralSecurityException | IOException | ParseException e1) {
                JOptionPane.showMessageDialog(null,"Ha habido un error dando de alta el cliente: " + e1.getLocalizedMessage());
            }
            searchClient.dispose();
            parentMenu.setVisible(true);
            parentMenu.setEnabled(true);
            JOptionPane.showMessageDialog(null,"Cliente encontrado: " + DTOModel.clientDTO + "proceda a realizar el alta de la operación");
            System.out.println(DTOModel.clientDTO);
            //TODO mostrar el cliente

        }
    }
}
