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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ylong
 */
public class AddMTNBController implements Initializable {

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
    void onAdd(ActionEvent event) {
String name = Bname.getText();
        String priceText = price.getText();
        String description = Bdsc.getText();
        String val = validity.getText();
        String ucde = ussdcode.getText();

        // Validate the input if required

        // Call the method to add the product to the database
        addProductToDatabase(name, priceText, description, val, ucde  );

        // Clear the input fields after adding the product
        clearInputFields();
    }

    private void addProductToDatabase(String name, String priceText, String description,  String val, String ucde) {
        // Your existing code to add the product to the "product" table
        // Make sure to replace the JDBC URL, username, and password with your own values
        // Adjust the SQL query and connection logic as per your requirements
        // Ensure proper exception handling and resource cleanup

       String jdbcURL = "jdbc:mysql://localhost:3306/billing"; 
        String username = "root"; 
        String password = "glory309";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            double price = Double.parseDouble(priceText);

            String sql = "INSERT INTO MTNbundles (validity, BName, price, Bdescription, ussdCode) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, val);
            statement.setString(2, name);
            statement.setDouble(3, price);
            statement.setString(4, description);
                statement.setString(5, ucde);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product added successfully.");
            } else {
                System.out.println("Failed to add product.");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format.");
        }
    }

    private void clearInputFields() {
        Bname.clear();
        validity.clear();
        price.clear();
        Bdsc.clear();
        ussdcode.clear();
    }


    

    @FXML
    void onClose(ActionEvent event) throws IOException {
 Parent root = FXMLLoader.load(getClass().getResource("/views/NewProduct.fxml"));
        Scene scene = new Scene(root);
        Stage st = new Stage();
        st.setScene(scene);
        st.setResizable(false);
        st.show();
         Node source = (Node) event.getSource();
        Stage sc = (Stage) source.getScene().getWindow();
        sc.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
