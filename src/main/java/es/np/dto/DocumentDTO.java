package es.np.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentDTO {
    private long clientId=0;
    private long docId=0;
    private String docType;
    private String docNumber;
    private String country;
    private Date expirationDate;
    private Long scanId;
    private static final SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
    public DocumentDTO() {

    }
    public DocumentDTO(long docId) {
        this.docId=docId;
    }

    public DocumentDTO(List<Object> resultRow) throws ParseException {
        System.out.println(resultRow);

        clientId = Long.parseLong((String) resultRow.get(0));
        docId = Long.parseLong((String) resultRow.get(1));
        docType = (String) resultRow.get(2);
        docNumber = (String) resultRow.get(3);
        country = (String) resultRow.get(4);
        expirationDate = sdf.parse((String) resultRow.get(5));
        scanId = Long.parseLong((String) resultRow.get(6));
        System.out.println(this);
    }
    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getScanId() {
        return scanId;
    }

    public void setScanId(Long scanId) {
        this.scanId = scanId;
    }
    public List<Object> getResultRow(){
        System.out.println(this);
        List<Object> resultRow= new ArrayList<Object>();
        resultRow.set(0,clientId);
        resultRow.set(1,docId);
        resultRow.set(2,docType);
        resultRow.set(3,docNumber);
        resultRow.set(4,country);
        resultRow.set(5,sdf.format(expirationDate));
        resultRow.set(6,scanId);
        System.out.println(resultRow);
        return resultRow;
    }
}
