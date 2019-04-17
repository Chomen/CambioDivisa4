package es.np.ctrl.dto;

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
    public void transformStrExpirationDateToDate(String strDate) throws ParseException {
        this.expirationDate=sdf.parse(strDate);
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
        resultRow.add(clientId);
        resultRow.add("=ROW()");
        resultRow.add(docType);
        resultRow.add(docNumber);
        resultRow.add(country);
        resultRow.add(sdf.format(expirationDate));
        resultRow.add(scanId);
        System.out.println(resultRow);
        return resultRow;
    }

    @Override
    public String toString() {
        return "DocumentDTO{" +
                "clientId=" + clientId +
                ", docId=" + docId +
                ", docType='" + docType + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", country='" + country + '\'' +
                ", expirationDate=" + expirationDate +
                ", scanId=" + scanId +
                '}';
    }
}
