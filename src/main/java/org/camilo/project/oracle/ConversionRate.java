package org.camilo.project.oracle;

import lombok.Getter;
import lombok.Setter;

public class ConversionRate {
    @Getter @Setter
    private String fromCurrency;
    @Getter @Setter
    private String toCurrency;
    @Getter @Setter
    private double rate;

    public ConversionRate(String fromCurrency, String toCurrency, double rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
    }

}
