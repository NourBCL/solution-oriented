/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class AcceuilUserController {
   
    private BorderPane Bpadmin;
    private Label l;
    @FXML
    private Pane acpane;
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private JFXButton accueil;

    
  
    @FXML
    void changeUser(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/Interfaces/profilUser.fxml"));
        acpane.getChildren().add(p);

    }

public BorderPane getborder(){
    return Bpadmin;
}

public void setLabel(String s){
     l.setText(s);
}

 private void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/Interfaces/"+page+".fxml"));

        bp.setCenter(root);
    }



@FXML
    private void gotoRestau(MouseEvent event) throws IOException {
        loadPage("ShowFrontRestau");
    }

    @FXML
    private void accueilfront(ActionEvent event) throws IOException {
        
          Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/AcceuilUser.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.setTitle("Liste des transport");
        stage.setScene(scene);
        stage.show();
    }

  

  
   
}
