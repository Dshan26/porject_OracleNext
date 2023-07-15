package org.camilo.project.oracle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class CurrencyConverterApp extends JFrame {
    private final CurrencyConverter currencyConverter;
    private final JComboBox<String> fromCurrencyComboBox = new JComboBox<>();
    private final JComboBox<String> toCurrencyComboBox;
    private final JTextField amountTextField;
    private final JLabel resultLabel;

    public CurrencyConverterApp() {
        currencyConverter = new CurrencyConverter();

        setTitle("Conversor de Moneda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        JLabel fromCurrencyLabel = new JLabel("De:");
        List<String> currencies = currencyConverter.getCurrencies();
        for (String currency : currencies) {fromCurrencyComboBox.addItem(currency);}

        JLabel toCurrencyLabel = new JLabel("A:");
        toCurrencyComboBox = new JComboBox<>();
        for (String currency : currencies) {toCurrencyComboBox.addItem(currency);}

        JLabel amountLabel = new JLabel("Cantidad:");
        amountTextField = new JTextField();

        JButton convertButton = new JButton("Convertir");
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountTextField.getText());
                String fromCurrency = Objects.requireNonNull(fromCurrencyComboBox.getSelectedItem()).toString();
                String toCurrency = Objects.requireNonNull(toCurrencyComboBox.getSelectedItem()).toString();

                double result = currencyConverter.convert(amount, fromCurrency, toCurrency);
                if (result == -1) {
                    resultLabel.setText("No se encontró una tasa de conversión válida.");
                } else {
                    resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency));
                }
            }
        });

        resultLabel = new JLabel("");

        add(fromCurrencyLabel);
        add(fromCurrencyComboBox);
        add(toCurrencyLabel);
        add(toCurrencyComboBox);
        add(amountLabel);
        add(amountTextField);
        add(convertButton);
        add(resultLabel);

        setVisible(true);
    }


}
