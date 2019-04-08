package es.np.gui.view;

import es.np.ctrl.dto.ClientDTO;
import es.np.ctrl.ops.ClientAccess;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.NumberFormat;
import java.text.ParseException;

public class CardTest {
    private JPanel masterPanel;
    private JPanel addClientPanel;
    private JLabel labelPersonName;
    private JTextField personName;
    private JTextField surname1;
    private JTextField surname2;
    private JTextField birthDateStr;
    private JButton altaButton;
    private JFormattedTextField formattedPhoneNumber;
    private JTextField nationality;
    private JComboBox ResidentComboBox;
    private JPanel addDocumentPanel;

    private void changeLayout() {
        CardLayout layout = (CardLayout)masterPanel.getLayout();
        layout.show(masterPanel,"Add Document Panel");
    }

    public void setContainer(Container pane) {
        masterPanel=new JPanel(new CardLayout());
        masterPanel.add(addClientPanel,"Add Client Panel");
        masterPanel.add(addDocumentPanel,"Add Document Panel");
        pane.add(masterPanel);
        altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientDTO cDTO = new ClientDTO();
                cDTO.setName(personName.getText());
                cDTO.setSurname1(surname1.getText());
                cDTO.setSurname2(surname2.getText());
                Long clientId=0L;
                try {
//                    clientId= Long.parseLong(ClientAccess.addClient(cDTO));
                    ClientAccess.addClient(cDTO);
                } catch (GeneralSecurityException | IOException | ParseException e1) {
                    JOptionPane.showMessageDialog(null,"Ha habido un error dando de alta el cliente: " + e1.getLocalizedMessage());

                }
                CardLayout layout = (CardLayout)masterPanel.getLayout();
                //addDocumentPanel.setClientId(clientId);
                layout.show(masterPanel,"Add Document Panel");

            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("App");
        CardTest cdt= new CardTest();
        cdt.setContainer(frame.getContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        formattedPhoneNumber= new JFormattedTextField();

        formattedPhoneNumber.setFormatterFactory(
                new DefaultFormatterFactory(
                        new NumberFormatter(NumberFormat.getIntegerInstance())));

    }
}
