package com.example.jmd_osmn.Models;

import com.example.jmd_osmn.Views.AccountType;
import com.example.jmd_osmn.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDrivers databaseDrivers;
    private AccountType loginAccountType = AccountType.CLIENT;
    //Client Data Section
    private final Client client;
    private boolean clientLoginSuccessFlag;

    //Admin Data Section

    public Model(){
        this.viewFactory = new ViewFactory();
        this.databaseDrivers = new DatabaseDrivers();
        //Client Data Section
        this.clientLoginSuccessFlag=false;
        this.client =new Client("","","",null,null,null);
        //Admin Data Section

    }

    public static synchronized Model getInstance(){
        if (model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    public DatabaseDrivers getDatabaseDrivers(){
        return databaseDrivers;
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }
    // Client Method Section


    public boolean getClientLoginSuccessFlag() {
        return clientLoginSuccessFlag;
    }

    public void setClientLoginSuccessFlag(boolean clientLoginSuccessFlag) {
        this.clientLoginSuccessFlag = clientLoginSuccessFlag;
    }

    public Client getClient() {
        return client;
    }
    public void evaluateClientCred(String pAddress, String password){
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        ResultSet resultSet = databaseDrivers.getClientData(pAddress,password);
        try {
            if (resultSet.isBeforeFirst()){
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.payeeAddressProperty().set(resultSet.getString("PayeeAddress"));
                String[] dateparts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateparts[0]),Integer.parseInt(dateparts[1]),Integer.parseInt(dateparts[2]));
                this.client.dateProperty().set(date);
                this.clientLoginSuccessFlag=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

