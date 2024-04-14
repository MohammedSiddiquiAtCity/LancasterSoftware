package src.DatabaseConnectivity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ChefDBConnectivity extends ConnectivityDBImpl{

    public ChefDBConnectivity() {
    }

    public boolean isHeadChef(){
        return true;
    }

    public boolean isSousChef(){
        return true;
    }


}
