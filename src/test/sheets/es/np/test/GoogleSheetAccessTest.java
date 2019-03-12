package es.np.test;

import es.np.dto.ClientDTO;
import es.np.dto.DocumentDTO;
import es.np.ops.ClientAccess;
import es.np.ops.DocAccess;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;


public class GoogleSheetAccessTest {
    @Test
    public void clientTest(){
        ClientDTO clientDTO=new ClientDTO();
        clientDTO.setClientId(1234560);
        clientDTO.setPhoneNumber(634347592);
        int offset= 0;
        try {
            clientDTO= ClientAccess.lookupClient(clientDTO);
        } catch (IOException|GeneralSecurityException | ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void documentTest(){
        DocumentDTO docDTO=new DocumentDTO();
        docDTO.setClientId(1234560);
        int offset=0;
        try {
            docDTO= DocAccess.lookupDocument(docDTO);

        } catch (IOException|GeneralSecurityException | ParseException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void appendRow() {
    }

    @Test
    public void updateRow() {
    }
}