package es.np.ops;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import es.np.dto.ClientDTO;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;

import java.text.ParseException;
import java.util.*;

import static com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport;

public class GoogleSheetAccess {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    private static final String spreadsheetId = "1HMMAZtZRwFZVkvvDubdQVuSmyWPz3Cq4GDVABHmraCc";
    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    private static final HashMap<String,String> mappingMap= new HashMap<String,String>(){{
        put("clientId","A:A");
        put("Nombre","B:B");
    }};

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = GoogleSheetAccess.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }


    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     */
    private static int lookUpCellOffset(List<Map<String,String>> columnValues, String sheetName) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = newTrustedTransport();
        final String range = "Scripts!A1:A10";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange contentClients = new ValueRange();
        List<List<Object>> listValues =  new ArrayList<List<Object>> ();
        for(Map<String,String> iterVal: columnValues){
            String cols=mappingMap.get(iterVal.get("columnName"));
            listValues.add(
                    Collections.<Object>singletonList(
                            "=MATCH(" + iterVal.get("columnValue") + ", " + sheetName + "!"+cols+", 0)"));
        }
        contentClients.setValues(listValues);
        UpdateValuesResponse response = service.spreadsheets().values().update(spreadsheetId,range,contentClients)
                .setValueInputOption("USER_ENTERED").setIncludeValuesInResponse(true).execute();
        System.out.println(response);
        int offset=0;
        for (List<Object> iterResult: response.getUpdatedData().getValues()) {
            try {
                offset=Integer.parseInt((String) iterResult.get(0));
            }
            catch(NumberFormatException e){
                System.out.println("No se ha podido mapear el campo " + iterResult.get(0));
            }
            if (offset!=0) break;
        }

        return offset;
    }

    private static String calculateCol(Map<String, String> iterVal) {
        return null;
    }

    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     */
    public static void main(String... args) throws IOException, GeneralSecurityException {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientId(1234560);
        Map<String,String> map= new HashMap<String,String>();
        map.put("columnName","clientId");
        map.put("columnValue","123560");
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        list.add(map);
        map= new HashMap<String,String>();
        map.put("columnName","Nombre");
        map.put("columnValue","\"hasta\"");
        list.add(map);
        int offset= lookUpCellOffset(list,"Clientes");
        System.out.println(offset);

    }
}