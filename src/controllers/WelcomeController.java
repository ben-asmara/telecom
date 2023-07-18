/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asmara
 */
public class WelcomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    void OnSignIn(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/SignIn.fxml"));
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
    void OnSignUp(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/SignUp.fxml"));
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
    void onAdmin(ActionEvent event) throws Exception{
    
        Parent root = FXMLLoader.load(getClass().getResource("/views/AdminHome.fxml"));
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
    void onExit(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
