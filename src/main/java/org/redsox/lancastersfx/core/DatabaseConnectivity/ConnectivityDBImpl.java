package org.redsox.lancastersfx.core.DatabaseConnectivity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ConnectivityDBImpl {
    // Database connection details
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t14";
    private String usernameData = "in2033t14_d";
    private String passwordData = "9c__N7U7N8c";
    private Connection con;

    // Constructor to initialize the database connection
    public ConnectivityDBImpl() {

    }

    /**
     * @param userName
     * The username that is going to connect to the database.
     * @param pwd
     * The password used to connect to the database.
     * @return Connection
     * returns a connection to the database to use.
     * */
    public Connection getConnection(String userName, String pwd) {
        try {
            /*Class.forName("com.mysql.jdbc.Driver");*/
            Properties connectionProps = new Properties();
            connectionProps.put("user", userName);
            connectionProps.put("password", pwd);
            setCon(DriverManager.getConnection(getUrl(), connectionProps));
        } catch (SQLException sqle) {
            System.err.println("Error connecting to the database:");
            sqle.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error:");
            e.printStackTrace();
        }
        return getCon();
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsernameData() {
        return usernameData;
    }

    public void setUsernameData(String usernameData) {
        this.usernameData = usernameData;
    }

    public String getPasswordData() {
        return passwordData;
    }

    public void setPasswordData(String passwordData) {
        this.passwordData = passwordData;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}