/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author asmara
 */
public class UpdateUserController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
        
    
  @FXML
    private JFXTextField Username;

    @FXML
    private JFXTextField Firstname;

    @FXML
    private JFXTextField Lastname;

    @FXML
    private JFXTextField Adress;

    @FXML
    private JFXTextField Phonenumber;

    @FXML
    void onClose(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("/views/AdminMenu.fxml"));
        Scene scene = new Scene(root);
        Stage st = new Stage();
        st.setScene(scene);
        st.setResizable(false);
        st.show();
         Node source = (Node) event.getSource();
        Stage sc = (Stage) source.getScene().getWindow();
        sc.close();
    }

    @FXML
    void onReset(ActionEvent event) {
 Username.setText("");
       Firstname.setText("");
         Lastname.setText("");
          Adress.setText("");
          Phonenumber.setText("");
    }

      @FXML
    void onDelete(ActionEvent event)  {
        
String jdbcURL = "jdbc:mysql://localhost:3306/billing"; 
        String username = "root"; 
        String password = "glory309";
         String enteredUsername = Username.getText();
         try{
          Connection connection = DriverManager.getConnection(jdbcURL, username, password);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete User");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete this user?");

                // Handle the user's response
                ButtonType confirmButton = new ButtonType("Delete", ButtonBar.ButtonData.OK_DONE);
                ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(confirmButton, cancelButton);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == confirmButton) {
                    // User confirmed the deletion, proceed with deletion

                    // Create the SQL statement to delete the user
                    String deleteSQL = "DELETE FROM users WHERE Username = ?";
                    PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL);
                    deleteStatement.setString(1, enteredUsername);

                    // Execute the delete statement
                    int rowsDeleted = deleteStatement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("User deleted successfully!");
                         Alert alrt = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Success");
                alert.setContentText("User deleted successfully!");
                 ButtonType confirmBut = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                 alert.getButtonTypes().setAll(confirmBut);
                alert.showAndWait();
                        // Perform further actions after successful deletion
                    } else {
                        System.out.println("Failed to delete user.");
                         Alert alrt = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Failure");
                alert.setContentText("Failed to delete user.");
                alert.showAndWait();
                        // Perform actions for failed deletion
                    }

                    deleteStatement.close();
                }
             else {
                System.out.println("User not found in the database.");
                // Perform actions for user not found
            }

            // Close the connections
           
            connection.close();
} catch (SQLException e) {
            e.printStackTrace();
        }}
    
    @FXML
    void onSearch(ActionEvent event) {
String jdbcURL = "jdbc:mysql://localhost:3306/billing"; 
        String username = "root"; 
        String password = "glory309";
         String enteredUsername = Username.getText();
         try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Create the SQL statement
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, enteredUsername);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the user exists and retrieve their information
            if (resultSet.next()) {
                String phoneNumber = resultSet.getString("Phone_number");
                String address = resultSet.getString("Address");
                String fstname = resultSet.getString("Firstname");
                String lstnme = resultSet.getString("Lastname");

                // Display the retrieved information in the respective text fields
                Firstname.setText(fstname);
                Lastname.setText(lstnme);
                Phonenumber.setText(phoneNumber);
                Adress.setText(address);

                System.out.println("User information retrieved successfully!");
                // Perform further actions after successful retrieval
            } else {
                System.out.println("User not found in the database.");
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("User not found");
                alert.setContentText("That user does not exist: Please try again.");
                alert.showAndWait();
                // Perform actions for user not found
            }

            // Close the connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void onSave(ActionEvent event) {

   
       String jdbcURL = "jdbc:mysql://localhost:3306/billing"; 
        String username = "root"; 
        String password = "glory309";  

        String enteredUsername = Username.getText();
        String newPhoneNumber = Phonenumber.getText();
        String newAddress =  Adress.getText();
        String newFirstname =  Firstname.getText();
        String newLastname =  Lastname.getText();

        try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Create the SQL statement
            String sql = "UPDATE users SET Firstname = ?, Lastname = ?, Phone_number = ?, Address = ? WHERE Username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newFirstname);
            statement.setString(2, newLastname);
            statement.setString(3, newPhoneNumber);
            statement.setString(4, newAddress);
            statement.setString(5, enteredUsername);

            // Execute the query
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User information updated successfully!");
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Success");
                alert.setContentText("User information updated successfully!");
                alert.showAndWait();
                // Perform further actions after successful update
            } else {
                System.out.println("Failed to update user information.");
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Failure");
                alert.setContentText("Failed to update user information.");
                alert.showAndWait();
                // Perform actions for failed update
            }

            // Close the connections
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
