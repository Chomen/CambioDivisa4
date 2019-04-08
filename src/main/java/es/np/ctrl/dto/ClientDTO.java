package es.np.ctrl.dto;


import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientDTO {
    long clientId =0;
    String name;
    String surname1;
    String surname2;
    Date birthDate=new Date();
    long phoneNumber;
    boolean spainResident;
    double lastAmount;
    double foreignAmount;
    String incomeBill;
    String curr;
    String nationality;
    List<DocumentDTO> listDocuments = new ArrayList<DocumentDTO>();
    private static final SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
    public ClientDTO(){

    }
    public ClientDTO(List<Object> resultRow) throws ParseException {
        System.out.println(resultRow);
        clientId=Long.parseLong((String)resultRow.get(0));
        name=(String)resultRow.get(1);
        surname1=(String)resultRow.get(2);
        surname2=(String)resultRow.get(3);
        birthDate=sdf.parse((String)resultRow.get(4));
        phoneNumber=Long.parseLong((String)resultRow.get(5));
        spainResident="SI".compareTo((String)resultRow.get(6))==0;
        incomeBill=(String)resultRow.get(7);
        lastAmount=Double.parseDouble((String)resultRow.get(8));
        foreignAmount=Double.parseDouble((String)resultRow.get(9));
        curr =(String)resultRow.get(10);
        nationality=(String)resultRow.get(11);
        for (int i=12;i<=14;i++) {
            if (StringUtils.isEmpty((String) resultRow.get(i))) {
                return;
            }
            listDocuments.add(new DocumentDTO(Long.parseLong((String)resultRow.get(i))));
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSpainResident() {
        return spainResident;
    }

    public void setSpainResident(boolean spainResident) {
        this.spainResident = spainResident;
    }

    public double getLastAmount() {
        return lastAmount;
    }

    public void setLastAmount(double lastAmount) {
        this.lastAmount = lastAmount;
    }

    public double getForeignAmount() {
        return foreignAmount;
    }

    public void setForeignAmount(double foreignAmount) {
        this.foreignAmount = foreignAmount;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        nationality = nationality;
    }

    public List<DocumentDTO> getListDocuments() {
        return listDocuments;
    }

    public void setListDocuments(List<DocumentDTO> listDocuments) {
        this.listDocuments = listDocuments;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getIncomeBill() {
        return incomeBill;
    }

    public void setIncomeBill(String incomeBill) {
        this.incomeBill = incomeBill;
    }
    public List<Object> getResultRow(){
        System.out.println(this);
        List<Object> resultRow= new ArrayList<Object>();

        resultRow.add(name);
        resultRow.add(surname1);
        resultRow.add(surname2);
        resultRow.add(sdf.format(birthDate));
        resultRow.add(phoneNumber);
        resultRow.add(spainResident?"SI":"NO");
        resultRow.add(incomeBill);
        resultRow.add(lastAmount);
        resultRow.add(foreignAmount);
        resultRow.add(curr);
        resultRow.add(nationality);
        for (DocumentDTO doc:listDocuments) {
            resultRow.add(doc);
        }
        return resultRow;

    }
}
