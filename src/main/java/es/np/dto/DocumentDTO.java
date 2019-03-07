package es.np.dto;

import java.util.Date;

public class DocumentDTO {
    long clientId=0;
    long docId=0;
    String documentType;
    String docNumber;
    String country;
    Date expirationDate;
    String scanId;

    public DocumentDTO(long docId) {
        this.docId=docId;
    }
}
