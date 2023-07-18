/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
 * @author ylong
 */
public class UpdateCamtelController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField Bname;

    @FXML
    private JFXTextField validity;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField Bdsc;

    @FXML
    private JFXTextField ussdcode;

    @FXML
    void onClose(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("/views/UpdateProduct.fxml"));
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
    void onDelete(ActionEvent event) {
String jdbcURL = "jdbc:mysql://localhost:3306/billing"; 
        String username = "root"; 
        String password = "glory309";
         String enteredBundlename = Bname.getText();
         try{
          Connection connection = DriverManager.getConnection(jdbcURL, username, password);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete product");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete this product?");

                // Handle the user's response
                ButtonType confirmButton = new ButtonType("Delete", ButtonBar.ButtonData.OK_DONE);
                ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(confirmButton, cancelButton);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == confirmButton) {
                    // User confirmed the deletion, proceed with deletion

                    // Create the SQL statement to delete the user
                    String deleteSQL = "DELETE FROM Camtelbundles WHERE BName = ?";
                    PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL);
                    deleteStatement.setString(1, enteredBundlename);

                    // Execute the delete statement
                    int rowsDeleted = deleteStatement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Product deleted successfully!");
                         Alert alrt = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Success");
                alert.setContentText("Product deleted successfully!");
                alert.showAndWait();
                        // Perform further actions after successful deletion
                    } else {
                        System.out.println("Failed to delete user.");
                         Alert alrt = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Failure");
                alert.setContentText("Failed to delete Product.");
                alert.showAndWait();
                        // Perform actions for failed deletion
                    }

                    deleteStatement.close();
                }
             else {
                System.out.println("Product not found in the database.");
                // Perform actions for user not found
            }

            // Close the connections
           
            connection.close();
} catch (SQLException e) {
            e.printStackTrace();
        }}
    

    @FXML
    void onReset(ActionEvent event) {
Bname.setText("");
       validity.setText("");
         price.setText("");
          Bdsc.setText("");
         ussdcode.setText("");
    }

    @FXML
    void onSave(ActionEvent event) {
String jdbcURL = "jdbc:mysql://localhost:3306/billing"; 
        String username = "root"; 
        String password = "glory309";  

        String enteredBName = Bname.getText();
        String newValidity = validity.getText();
        String newPrice =  price.getText();
        String newBdsc = Bdsc.getText();
        String newUssdCode =  ussdcode.getText();

        try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Create the SQL statement
            String sql = "UPDATE Camtelbundles SET validity = ?, price = ?, Bdescription = ?, ussdCode = ? WHERE BName = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newValidity);
            statement.setString(2, newPrice);
            statement.setString(3, newBdsc);
            statement.setString(4, newUssdCode);
            statement.setString(5, enteredBName);

            // Execute the query
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Product information updated successfully!");
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Success");
                alert.setContentText("Product information updated successfully!");
                alert.showAndWait();
                // Perform further actions after successful update
            } else {
                System.out.println("Failed to update Product information.");
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Failure");
                alert.setContentText("Failed to update Product information.");
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

    @FXML
    void onSearch(ActionEvent event) {
String jdbcURL = "jdbc:mysql://localhost:3306/billing"; 
        String username = "root"; 
        String password = "glory309";
         String enteredBundlename = Bname.getText();
         try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Create the SQL statement
            String sql = "SELECT * FROM Camtelbundles WHERE BName = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, enteredBundlename);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the user exists and retrieve their information
            if (resultSet.next()) {
                String Vald = resultSet.getString("validity");
                String Price = resultSet.getString("price");
                String Brdsc = resultSet.getString("Bdescription");
                String Uscode = resultSet.getString("ussdCode");

                // Display the retrieved information in the respective text fields
                validity.setText(Vald);
                price.setText(Price);
               Bdsc.setText( Brdsc);
                ussdcode.setText(Uscode);

                System.out.println("Product information retrieved successfully!");
                // Perform further actions after successful retrieval
            } else {
                System.out.println("Product not found in the database.");
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Product not found");
                alert.setContentText("That Product does not exist: Please try again.");
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       
}
