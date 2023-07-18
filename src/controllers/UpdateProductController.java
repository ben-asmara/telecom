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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ylong
 */
public class UpdateProductController implements Initializable {

    /**
     * Initializes the controller class.
     */
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
    void onCambund(ActionEvent event) throws IOException {
 Parent root = FXMLLoader.load(getClass().getResource("/views/UpdateCamtel.fxml"));
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
    void onMTNbund(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("/views/UpdateMTN.fxml"));
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
    void onOrbund(ActionEvent event) throws IOException{
Parent root = FXMLLoader.load(getClass().getResource("/views/UpdateOran.fxml"));
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
