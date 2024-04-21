package com.cafemanager.cafe;
import java.sql.*;

public class sqlConnector {


    public static void main(String[] args) throws Exception {

        // Create a connection to the database.
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");

        // Create a statement.
        Statement statement = connection.createStatement();

        try {
        // Execute a query. (selects all from table 'user')
        ResultSet rs = statement.executeQuery("SELECT * FROM user");

        // Process the results.
            while (rs.next()) {
                // Get the data from the current row.

                String email = rs.getString("email");


                //                int cafe_balance = rs.getInt("cafeteria_balance");
                int rsFetchSize = rs.getFetchSize();

                // Do something with the data.
                System.out.println("email:" + email);
                System.out.println("rsFetchSize = " + rsFetchSize);

            // Close the connection.
            connection.close();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}


