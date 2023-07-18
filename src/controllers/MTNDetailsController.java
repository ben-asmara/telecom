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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Product;

/**
 * FXML Controller class
 *
 * @author ylong
 */
public class MTNDetailsController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
            String sql = "SELECT * FROM MTNbundles";
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
