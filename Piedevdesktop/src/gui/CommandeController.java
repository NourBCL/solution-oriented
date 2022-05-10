/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Commande;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author omaro
 */
public class CommandeController implements Initializable {

    @FXML
    private Label od;
    @FXML
    private Label ad;
    @FXML
    private Label dt;
    @FXML
    private Button sh;
    @FXML
    private Button ed;
    @FXML
    private Button de;
    
    private Commande c;
public void SetData(Commande commande){
    od.setText(String.valueOf (commande.getId()));
    ad.setText(commande.getAdresse_destination());
    dt.setText(String.valueOf (commande.getDate_commande()));
    c = commande;
    
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void modifier(ActionEvent event) {      Stage primaryStage = new Stage();
        
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ModCom.fxml"));
            Parent root = loader.load();
          ModComController cont = loader.getController();
            cont.setCommande(c);
            Scene scene = new Scene(root);
            primaryStage.setTitle("Commande");
            primaryStage.setScene(scene);
            primaryStage.show();
            
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @FXML
    private void afficher(ActionEvent event) {
                Stage primaryStage = new Stage();
        
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AfficheCommande.fxml"));
            Parent root = loader.load();
            AfficheCommandeController cont = loader.getController();
            cont.setCommande(c);
            Scene scene = new Scene(root);
            primaryStage.setTitle("Commande");
            primaryStage.setScene(scene);
            primaryStage.show();
            
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}

//    @FXML
//    private void afficher(MouseEvent event) {      Stage primaryStage = new Stage();
//        
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("AfficheCommande.fxml"));
//            
//            Scene scene = new Scene(root);
//            primaryStage.setTitle("Commande");
//            primaryStage.setScene(scene);
//            primaryStage.show();
//            
//           
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
    
}
