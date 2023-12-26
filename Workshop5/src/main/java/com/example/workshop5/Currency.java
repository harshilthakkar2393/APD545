/**********************************************
 Workshop 4
 Course:APD545 - Fall 2023
 Last Name:Thakkar
 First Name:Harshil
 ID:160431219
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic
 Policy.
 harshil
 Date:Oct 18, 2023
 **********************************************/
package com.example.workshop5;

public class Currency {
    private String name;

//    value of 1 usd in that currency
    private double value;

    public Currency(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
