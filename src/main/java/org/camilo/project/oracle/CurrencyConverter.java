package org.camilo.project.oracle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CurrencyConverter {
    private final List<ConversionRate> conversionRates;

    public CurrencyConverter() {
        conversionRates = new ArrayList<>();

        // Agregar tasas de conversión predefinidas
        conversionRates.add(new ConversionRate("USD", "COP",4056.72));
        conversionRates.add(new ConversionRate("USD", "EUR", 0.89));
        conversionRates.add(new ConversionRate("EUR", "USD", 1.18));
        conversionRates.add(new ConversionRate("USD", "GBP", 0.72));
        conversionRates.add(new ConversionRate("GBP", "USD", 1.39));
        // Agregar más tasas de conversión según sea necesario
    }

    public List<String> getCurrencies() {
        List<String> currencies = new ArrayList<>();
        for (ConversionRate rate : conversionRates) {
            if (!currencies.contains(rate.getFromCurrency())) {
                currencies.add(rate.getFromCurrency());
            }
            if (!currencies.contains(rate.getToCurrency())) {
                currencies.add(rate.getToCurrency());
            }
        }
        return currencies;
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        for (ConversionRate rate : conversionRates) {
            if (!rate.getFromCurrency().equals(fromCurrency) || !rate.getToCurrency().equals(toCurrency)) {
                continue;
            }
            return amount * rate.getRate();
        }
        return -1; // Retornar -1 si no se encuentra una tasa de conversión válida
    }
}
