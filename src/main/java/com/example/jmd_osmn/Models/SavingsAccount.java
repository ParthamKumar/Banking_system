package com.example.jmd_osmn.Models;

import javafx.beans.property.DoubleProperty;

import javafx.beans.property.SimpleDoubleProperty;


public class SavingsAccount extends Account{

    private final DoubleProperty withDrawallimit;

    public SavingsAccount(String owner, String accountNumber, double balance,double withdrawallimit) {
        super(owner, accountNumber, balance);
        this.withDrawallimit = new SimpleDoubleProperty(this,"Transaction Limit",withdrawallimit);
    }
    public DoubleProperty withdrawallimitProperty(){return withDrawallimit;}
}
