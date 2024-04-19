package com.cafemanager.cafe;
import java.sql.*;

public class sqlConnector {


    public static void main(String[] args) throws Exception {

        System.out.println("Yo mama's so ugly...");
//        Statement blah = null;
//        blah.executeQuery("select * from your_mom");
        // Create a connection to the database.
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");

        // Create a statement.
        Statement stmt = conn.createStatement();

        try {
        // Execute a query.
        ResultSet rs = stmt.executeQuery("SELECT * FROM user");

        // Process the results.
            while (rs.next()) {
                // Get the data from the current row.
                String email = rs.getString("email");

//                String firstname = rs.getString("student_name_first");
//                String lastname = rs.getString("student_name_last");

                //                int cafe_balance = rs.getInt("cafeteria_balance");
                int rsFetchSize = rs.getFetchSize();

                // Do something with the data.
                System.out.println("email:" + email);
                System.out.println("rsFetchSize = " + rsFetchSize);

            // Close the connection.
            conn.close();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}


