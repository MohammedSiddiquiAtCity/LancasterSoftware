package org.redsox.lancastersfx.DatabaseConnectivity;

import java.sql.*;
import java.util.Properties;

/**
 * The ConnectivityDBImpl class provides methods for connecting to a database.
 */
public class ConnectivityDBImpl {
    // Database connection details
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t14";
    private String usernameData = "in2033t14_d";
    private String passwordData = "9c__N7U7N8c";
    private Connection con;

    /**
     * Constructs a ConnectivityDBImpl object.
     */
    public ConnectivityDBImpl() {

    }

    /**
     * Establishes a connection to the database using the specified username and password.
     *
     * @param userName the username used to connect to the database
     * @param pwd the password used to connect to the database
     * @return the Connection object representing the database connection
     */
    public Connection getConnection(String userName, String pwd) {
        try {
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

    /**
     * Gets the URL of the database.
     *
     * @return the URL of the database
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL of the database.
     *
     * @param url the URL of the database
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the username used to connect to the database.
     *
     * @return the username used to connect to the database
     */
    public String getUsernameData() {
        return usernameData;
    }

    /**
     * Sets the username used to connect to the database.
     *
     * @param usernameData the username used to connect to the database
     */
    public void setUsernameData(String usernameData) {
        this.usernameData = usernameData;
    }

    /**
     * Gets the password used to connect to the database.
     *
     * @return the password used to connect to the database
     */
    public String getPasswordData() {
        return passwordData;
    }

    /**
     * Sets the password used to connect to the database.
     *
     * @param passwordData the password used to connect to the database
     */
    public void setPasswordData(String passwordData) {
        this.passwordData = passwordData;
    }

    /**
     * Gets the database connection.
     *
     * @return the database connection
     */
    public Connection getCon() {
        return con;
    }

    /**
     * Sets the database connection.
     *
     * @param con the database connection
     */
    public void setCon(Connection con) {
        this.con = con;
    }
}
