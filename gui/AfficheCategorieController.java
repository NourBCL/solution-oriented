/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.categorie;
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
import service.CategorieService;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AfficheCategorieController implements Initializable {
     @FXML
    private VBox vItem = null;


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
                loader.setLocation(getClass().getResource("Item.fxml"));
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
        Parent root = FXMLLoader.load(getClass().getResource("ajouterCategorie.fxml"));
        vItem.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        }
        @FXML
    private void openEvenements(ActionEvent event) {
                  try {
        Parent root = FXMLLoader.load(getClass().getResource("afficheEvenement.fxml"));
        vItem.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
