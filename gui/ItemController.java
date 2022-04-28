/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.categorie;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import service.CategorieService;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ItemController implements Initializable {

 
    @FXML
    private Label nom;
    categorie currentCategorie;
    AfficheCategorieController controller;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }  
    public void setCategorie(categorie cat){
        currentCategorie = cat;
        nom.setText(cat.getNom());  
    }
    public void setController(AfficheCategorieController c)
    {
        controller = c;
    }
    
      @FXML
    private void edit(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("editCategorie.fxml"));
            Parent root = loader.load();
            EditCategorieController editc = loader.getController();
            editc.setUp(currentCategorie);
           nom.getScene().setRoot(root);
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void delete(ActionEvent event) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you Sure ?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                new CategorieService().supprimer(currentCategorie.getId_cat());
                controller.refreshList();
            }

    }
    
}
