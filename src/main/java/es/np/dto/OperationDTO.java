package es.np.dto;

import java.util.Date;

public class OperationDTO {
    long operationId;
    String operationType;
    String inputCurrency;
    String outputCurrency;
    String currencyExchange;
    Date operationDate;
    double profit;
}
