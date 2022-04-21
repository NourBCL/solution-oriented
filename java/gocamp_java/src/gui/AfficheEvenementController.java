/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entities.evenement;
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
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AfficheEvenementController implements Initializable {

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
        EvenementService catser = new EvenementService();
        List<evenement> evenement = catser.recuperer();
        System.out.println(evenement);
        ObservableList list = FXCollections.observableArrayList(evenement);
        
        List<Node> nodes = new ArrayList<>();
        vItem.getChildren().clear();
        for(evenement e : evenement){
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("ItemEv.fxml"));
           Parent root;
            try {
                root = loader.load();
             
           nodes.add( root);
           vItem.getChildren().add(root);
           ItemEvController itemEvController = new ItemEvController();
           itemEvController = loader.getController();
           itemEvController.setEvenement(e);
           itemEvController.setController(this);
            }catch (IOException ex) {
                 ex.printStackTrace();
            }
        }
    }
      @FXML
    private void addEvenements(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ajouterEvenement.fxml"));
            vItem.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void openCategories(ActionEvent event) {
        System.out.println("test");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("afficheCategorie.fxml"));
            vItem.getScene().setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
}
