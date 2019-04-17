package es.np.ctrl.dto;

import java.util.Date;

public class CurrencyExchangeDTO {
    Date lastModifDate;
    String originCurrency;
    String finalCurrency;
    double exchangeRate;

    @Override
    public String toString() {
        return "CurrencyExchangeDTO{" +
                "lastModifDate=" + lastModifDate +
                ", originCurrency='" + originCurrency + '\'' +
                ", finalCurrency='" + finalCurrency + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}

