/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.categorie;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import Services.CategorieService;
import com.jfoenix.controls.JFXButton;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AfficheCategorieController implements Initializable {
     @FXML
    private VBox vItem = null;
    @FXML
    private JFXButton transport;
    @FXML
    private JFXButton acceuil;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refreshList();
            
    }    
    public void refreshList()
    {
        CategorieService catser = new CategorieService();
        List<categorie> categorie = catser.recuperer();
        System.out.println(categorie);
        ObservableList list = FXCollections.observableArrayList(categorie);
        
        List<Node> nodes = new ArrayList<>();
        vItem.getChildren().clear();
        for(categorie c : categorie){
            try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Interfaces/Item.fxml"));
                Parent root =loader.load();
                nodes.add( root);
                vItem.getChildren().add(root);
                ItemController itemController = new ItemController();
                itemController = loader.getController();
                itemController.setCategorie(c);
                itemController.setController(this);
            }catch (IOException e){
                    e.printStackTrace();
            }
        }
    }
     @FXML
        public void addCategories(ActionEvent event) {
         try {
        Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/ajouterCategorie.fxml"));
        vItem.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        }
        @FXML
    private void openEvenements(ActionEvent event) {
                  try {
        Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/afficheEvenement.fxml"));
        vItem.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

   
    @FXML
    void changeUser(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/Interfaces/ListeUtilisateurBack.fxml"));
     //   acpane.getChildren().add(p);

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
    
      private void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/Interfaces/"+page+".fxml"));

      //  bp.setCenter(root);
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
    
    
    

    @FXML
    private void acceuilback(ActionEvent event) throws IOException {
         
          Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/AcceuilAdmin.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.setTitle("Liste des transport");
        stage.setScene(scene);
        stage.show();
    }

}
