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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Services.EvenementService;
import Entities.evenement;
import static Interfaces.Acceuil.primaryStage;
import Interfaces.HomePageController;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author hp
 */
public class AcceuilAdmincontroller implements Initializable {

    @FXML
    private Pane acpane;
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private JFXButton transport;
    @FXML
    private JFXButton acceuil;
    @FXML
    private JFXButton commande;

   // static HomePageController hpc;

    @FXML
    void changeUser(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/Interfaces/ListeUtilisateurBack.fxml"));
        acpane.getChildren().add(p);

    }

    @FXML
    private void transport(ActionEvent event) throws IOException {

        Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/TransportGestion.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des transport");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void openEvenements(ActionEvent event) throws IOException {

        Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/afficheEvenement.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des evenements");
        stage.setScene(scene);
        stage.show();
        /* try {
        Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/afficheEvenement.fxml"));
        nom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }*/

    }

    private void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/Interfaces/"+page+".fxml"));

        bp.setCenter(root);
    }

    /*public static void loadPages(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(HomePageController.class.getResource(page + ".fxml"));

        bp.setCenter(root);
    }*/

    @FXML
    private void goRegion(MouseEvent event) throws IOException {
        loadPage("ShowRegions");
    }

     @FXML
    private void gotoRestau(MouseEvent event) throws IOException {
        loadPage("ShowRestau");
    }
    
    
    
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        

    }
    
    
     public BorderPane getBp() {
        return bp;
    }

    @FXML
    private void acceuilback(ActionEvent event) throws IOException {
        
          Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/AcceuilAdmin.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.setTitle("Liste des transport");
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void commande(ActionEvent event) {try {
            Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/FrontCommande Controller.fxml"));
            Scene scene = new Scene(page1);
Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           // primaryStage.setTitle("ga3ga3");
            //primaryStage.setScene(scene);
            //primaryStage.show();
            stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }


}
