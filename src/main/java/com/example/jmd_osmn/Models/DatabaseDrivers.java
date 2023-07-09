package com.example.jmd_osmn.Models;

import java.sql.*;

public class DatabaseDrivers {
    private Connection conn;
    public DatabaseDrivers() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:mazebank.db");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    // Client Section
    public ResultSet getClientData(String pAddress,String password){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"' AND PASSWORD='"+password+"';");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return resultSet;

    }

    //Admin Section

    //Utility Methods

}
