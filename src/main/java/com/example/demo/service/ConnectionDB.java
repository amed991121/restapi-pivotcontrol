package com.example.demo.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionDB {

    public Connection openDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=alarmcomposedb;"
                    + "user=sa;"
                    + "password=12345678;"
                    + "trustServerCertificate=true";
            Connection con = DriverManager.getConnection(connectionUrl);
            return con;
        } catch (SQLException e) {
            System.out.println("Error de conexión");
        }
        catch (ClassNotFoundException cnfex) {
            System.out.println("Base de Datos no encontrda");
        }
        return null;
    }
}
