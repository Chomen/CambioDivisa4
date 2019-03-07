package es.np.dto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientDTO {
    long clientId =0;
    String name;
    String surname1;
    String surname2;
    Date birthDate;
    long phoneNumber;
    boolean spainResident;
    double lastAmount;
    double foreignAmount;
    String incomeBill;
    String curr;
    String Nationality;
    List<DocumentDTO> listDocuments = new ArrayList<DocumentDTO>();

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
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
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
}
