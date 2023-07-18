/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Product;

/**
 * FXML Controller class
 *
 * @author ylong
 */
public class ProdDetUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TableView<Product> productdetails;

    @FXML
    private TableColumn<Product, String> Vald;

    @FXML
    private TableColumn<Product, String> Bname;

    @FXML
    private TableColumn<Product, Double> price;

    @FXML
    private TableColumn<Product, String> Bdesc;

    @FXML
    private TableColumn<Product, String> code;
     @FXML
    void onBuy(ActionEvent event) {
 Product selectedBundle = productdetails.getSelectionModel().getSelectedItem();

        if (selectedBundle == null) {
            showAlert("Error", "No bundle selected.", "Please select a bundle before clicking Buy.");
            return;
        }
        

        // Store the transaction information in the transactions table
        boolean transactionSaved = saveTransaction(selectedBundle);

        if (transactionSaved) {
            showAlert("Success", "Purchase Successful", "You have successfully purchased the bundle: " + selectedBundle.getBundleName());
            // Reset the selected bundle and clear the bundle details display
            productdetails.getSelectionModel().clearSelection();
            // Clear the text fields or labels displaying the bundle details
        } else {
            showAlert("Error", "Transaction Failed", "An error occurred while saving the transaction.");
        }
    }

    private boolean saveTransaction(Product bundle) {
        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "glory309");

            // Prepare the SQL statement
            String sql = "INSERT INTO transactions (transaction_date, username, receiver_phone, payer_phone, amount, bundle_name) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values for the prepared statement
            statement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            statement.setString(2, "username"); // Replace with the actual username
            statement.setString(3, "receiverP"); // Replace with the actual receiver phone number
            statement.setString(4, "payerPh"); // Replace with the actual payer phone number
            statement.setDouble(5, bundle.getPrice());
            statement.setString(6, bundle.getBundleName());
         

            // Execute the statement
            int rowsAffected = statement.executeUpdate();

            // Close the statement and connection
            statement.close();
            connection.close();

            return rowsAffected > 0; // Return true if at least one row was affected (i.e., the transaction was saved successfully)
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an exception occurred while saving the transaction
        }
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         // Configure the table columns
        Vald.setCellValueFactory(new PropertyValueFactory<>("validity"));
        Bname.setCellValueFactory(new PropertyValueFactory<>("bundleName"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        Bdesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        code.setCellValueFactory(new PropertyValueFactory<>("ussdCode"));

        // Populate the table with product details from the database
        populateProductDetails();
    }

    private void populateProductDetails() {
        String jdbcURL = "jdbc:mysql://localhost:3306/billing";
        String username = "root";
        String password = "glory309";
        ObservableList<Product> products = FXCollections.observableArrayList();

        try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Create the SQL statement
            String sql = "SELECT * FROM OrangeBundles";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Clear the existing data in the products list
            products.clear();

            // Populate the products list with product details from the result set
            while (resultSet.next()) {
                String validity = resultSet.getString("validity");
                String bundleName = resultSet.getString("BName");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("Bdescription");
                String ussdCode = resultSet.getString("ussdCode");

                Product product = new Product(validity, bundleName, price, description, ussdCode);
                products.add(product);
            }

            // Populate the table view with the products list
            productdetails.setItems(products);

            // Close the connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }    
    

