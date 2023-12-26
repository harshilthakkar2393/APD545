/**********************************************
 Workshop 6
 Course:APD545 - Fall 2023
 Last Name:Thakkar
 First Name:Harshil
 ID:160431219
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic
 Policy.
 harshil
 Date:Nov 30, 2023
 **********************************************/
package com.example.workshop6;

import java.util.ArrayList;

public class CurrencyConverter {
    private ArrayList<Currency> currencies;

    public CurrencyConverter(ArrayList<Currency> currencies) {
        this.setCurrencies(currencies);
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }

    public ArrayList<String> getCurrencyNames() {
        ArrayList<String> currencyList = new ArrayList<>();
        for (var curr : this.currencies
        ) {
            currencyList.add(curr.getName());
        }
        return currencyList;
    }

    public double getValueFromName(String name) {
        double value = 0;
        for (var curr : currencies
        ) {
            if (curr.getName().equals(name)) {
                value = curr.getValue();
            }
        }
        return value;
    }

    public double convert(String to, String from, double amount) {
        double result = 0;
        double toValue = getValueFromName(to);
        double fromValue = getValueFromName(from);
        result = (fromValue / toValue) * amount;
        return result;
    }

}
