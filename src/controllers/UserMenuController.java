/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asmara
 */
public class UserMenuController implements Initializable {
    @FXML
    private TextField PPN;

    @FXML
    private TextField RPN;

    @FXML
    private TextField amount;
@FXML
    private Label WelcomeLabel;
   
             public void setWelcomeUsername(String username) {
        WelcomeLabel.setText("Welcome, " + username + "!");
    }
             public String getReceiverPhone() {
        return RPN.getText();
    }

    public String getPayerPhone() {
        return PPN.getText();
    }
      @FXML
    void onBundles(ActionEvent event) throws IOException {
 Parent root = FXMLLoader.load(getClass().getResource("/views/ProdDetUser.fxml"));
        Scene scene = new Scene(root);
        Stage st = new Stage();
        st.setScene(scene);
        st.setResizable(false);
        st.show();
    }

    @FXML
    void onBuy(ActionEvent event) {
  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Success");
                alert.setContentText("You have successfully purchased the bundle!");
                alert.showAndWait();
       PPN.setText("");
         RPN.setText("");
           amount.setText("");
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
