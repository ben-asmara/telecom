/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.*;
/**
 *
 * @author ylong
 */
public class MysqlConnection {
  
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/billing"; // Replace 'mydatabase' with your actual database name
        String username = "root"; // Replace 'your_username' with your MySQL username
        String password = "glory309"; // Replace 'your_password' with your MySQL password

        try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Create the SQL statement
            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(sql);

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                 String Firstname = resultSet.getString("Firstname");
                  String Lastname = resultSet.getString("Lastname");
                   String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("Phone_number");
                String Username = resultSet.getString("Username");
                String Userpassword = resultSet.getString("Userpassword");
               

                // Perform desired operations with the retrieved data
                System.out.println("User ID: " + id);
                System.out.println("Firstname: " + Firstname);
                 System.out.println("Lastname: " + Lastname);
                 System.out.println("Address: " + address);
                  System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                
                System.out.println("---------------------------");
            }

            // Close the connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

