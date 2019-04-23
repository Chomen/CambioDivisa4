package es.np.gui.controller;

import es.np.gui.view.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {

    private MainMenu mainMenu;
    private JButton addClientBut;
    private JButton searchClientBut;
    private JButton createOperationBut;
    public MainMenuController(){
        initComponents();
        initListeners();
    }


    private void initComponents() {
        mainMenu=new MainMenu();
        addClientBut = mainMenu.getAddClientBut();
        searchClientBut=mainMenu.getSearchClientBut();
        createOperationBut =mainMenu.getCreateOperationBut();
    }

    private void initListeners() {

        addClientBut.addActionListener(new AddClientButListener());
        searchClientBut.addActionListener(new SearchClientButListener());
        createOperationBut.addActionListener(new CreateOperationButListener());

    }

    public void showFrame() {
        mainMenu.setVisible(true);
    }


    private class AddClientButListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddClientDocController addClientController= new AddClientDocController(mainMenu);
            mainMenu.setEnabled(false);
            addClientController.showFrame();
        }
    }

    private class SearchClientButListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SearchClientController controller= new SearchClientController(mainMenu);
            mainMenu.setEnabled(false);
            controller.showFrame();

        }
    }

    private class CreateOperationButListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            NewOperationController controller= new NewOperationController(mainMenu);
            mainMenu.setEnabled(false);
            controller.showFrame();
        }
    }
}
