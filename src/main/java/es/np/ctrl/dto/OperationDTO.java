package es.np.ctrl.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationDTO {
    ClientDTO clientDTO;
    long operationId;
    String operationType;
    String inputCurrency;
    String outputCurrency;
    String currencyExchange;
    Date operationDate;
    double profit;
    private static final SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
    public OperationDTO(){

    }
    public OperationDTO(List<Object> resultRow){
        System.out.println(resultRow);
        clientDTO=new ClientDTO();
        clientDTO.setClientId(Long.parseLong((String) resultRow.get(0)));
        operationId=Long.parseLong((String) resultRow.get(1));
        operationType= (String) resultRow.get(2);
        inputCurrency= (String) resultRow.get(3);
        outputCurrency= (String) resultRow.get(4);
        currencyExchange= (String) resultRow.get(5);
        operationDate= (Date) resultRow.get(6);
        profit=Long.parseLong((String) resultRow.get(7));
        System.out.println(this);

    }
    public long getOperationId() {
        return operationId;
    }

    public void setOperationId(long operationId) {
        this.operationId = operationId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getInputCurrency() {
        return inputCurrency;
    }

    public void setInputCurrency(String inputCurrency) {
        this.inputCurrency = inputCurrency;
    }

    public String getOutputCurrency() {
        return outputCurrency;
    }

    public void setOutputCurrency(String outputCurrency) {
        this.outputCurrency = outputCurrency;
    }

    public String getCurrencyExchange() {
        return currencyExchange;
    }

    public void setCurrencyExchange(String currencyExchange) {
        this.currencyExchange = currencyExchange;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }
    public List<Object> getResultRow(){
        System.out.println(this);
        List<Object> resultRow= new ArrayList<Object>();
        resultRow.add(clientDTO.getClientId());
        resultRow.add(operationId);
        resultRow.add(operationType);
        resultRow.add(inputCurrency);
        resultRow.add(outputCurrency);
        resultRow.add(currencyExchange);
        resultRow.add(sdf.format(operationDate));
        resultRow.add(profit);
        System.out.println(resultRow);
        return resultRow;
    }

    @Override
    public String toString() {
        return "OperationDTO{" +
                "clientDTO=" + clientDTO +
                ", operationId=" + operationId +
                ", operationType='" + operationType + '\'' +
                ", inputCurrency='" + inputCurrency + '\'' +
                ", outputCurrency='" + outputCurrency + '\'' +
                ", currencyExchange='" + currencyExchange + '\'' +
                ", operationDate=" + operationDate +
                ", profit=" + profit +
                '}';
    }
}
