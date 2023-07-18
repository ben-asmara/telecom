/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import models.User;
import java.sql.*;
/**
 * FXML Controller class
 *
 * @author ylong
 */
public class SignInController implements Initializable {
    /**
     * Initializes the controller class.
     */
   @FXML
    private JFXTextField UserName;

    @FXML
    private JFXPasswordField Password;
    /**
     * Initializes the controller class.
     */
      @FXML
 
    void OnExit(ActionEvent event) {
 Node source = (Node) event.getSource();
        Stage sc = (Stage) source.getScene().getWindow();
        sc.close();
    }

    @FXML
    void OnRemember(ActionEvent event) {
      
    }
      @FXML
    void onReturn(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("/views/Welcome.fxml"));
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
    void onContinue(ActionEvent event) throws IOException {
        String jdbcURL = "jdbc:mysql://localhost:3306/billing"; 
        String username = "root"; 
        String password = "glory309"; 
        String enteredUsername = UserName.getText();
        String enteredPassword = Password.getText();
         try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Create the SQL statement
            String sql = "SELECT * FROM users WHERE Username = ? AND Userpassword = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, enteredUsername);
            statement.setString(2, enteredPassword);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the username and password match
            if (resultSet.next()) {
                System.out.println("User is allowed to enter the application.");
                 String usname = UserName.getText();
               
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/UserMenu.fxml"));
            Parent root = loader.load();
            UserMenuController userMenuController = loader.getController();
           userMenuController.setWelcomeUsername(usname);

          Scene scene = new Scene(root);
        Stage st = new Stage();
        st.setScene(scene);
        st.setResizable(false);
        st.show();
         Node source = (Node) event.getSource();
        Stage sc = (Stage) source.getScene().getWindow();
        sc.close();
               // Perform actions for successful login
            } else {
                System.out.println("Invalid username or password.");
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Invalid credentials");
                alert.setContentText("Invalid Username or password: Please try again.");
                alert.showAndWait();
                // Perform actions for failed login
            }

            // Close the connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IOException ex) {
                   Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
               }
         
    }     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
