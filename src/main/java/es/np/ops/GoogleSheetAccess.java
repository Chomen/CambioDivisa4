package es.np.ops;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import es.np.dto.ClientDTO;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public static int lookUpCellOffset(ClientDTO cdto) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = newTrustedTransport();
        final String range = "Scripts!A1";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange contentClients = new ValueRange().setValues(
                Collections.<List<Object>>singletonList(
                        Collections.<Object>singletonList(
                                "\"=MATCH(\""+cdto.getClientId()+"\", MySheet1!A:A, 0)\"\n")));
        //content.setMajorDimension("COLUMNS");
        //ValueRange contentDocuments = new ValueRange().setValues(Arrays.asList(Arrays.asList("probando","un","doc3")));

        AppendValuesResponse response = service.spreadsheets().values().append(spreadsheetId,range,contentClients).setValueInputOption("RAW").execute();
        System.out.println(response);
//comment
        return (int)response.getUpdates().getUpdatedData().getValues().get(0).get(0);
    }
    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     */
    public static void main(String... args) throws IOException, GeneralSecurityException {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientId(1234560);
        int offset= lookUpCellOffset(clientDTO);
        // Build a new authorized API client service.
//        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//        final String spreadsheetId = "1HMMAZtZRwFZVkvvDubdQVuSmyWPz3Cq4GDVABHmraCc";
//        final String range = "Class Data!A2:E";
//        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//        ValueRange contentClients = new ValueRange().setValues(Arrays.<List<Object>>asList(Arrays.<Object>asList("cliente1","dato2","dato3")));
//        //content.setMajorDimension("COLUMNS");
//        //ValueRange contentDocuments = new ValueRange().setValues(Arrays.asList(Arrays.asList("probando","un","doc3")));
//
//
//        AppendValuesResponse response = service.spreadsheets().values().append(spreadsheetId,"Clientes!A2",contentClients).setValueInputOption("RAW").execute();

    }
}