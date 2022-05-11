/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.evenement;
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
import Services.CategorieService;
import Services.EvenementService;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ItemEvController implements Initializable {


    @FXML
    private Label nom;
     evenement currentEvenement;
    AfficheEvenementController controller;
    @FXML
    private HBox Hbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     public void setEvenement(evenement ev){
        currentEvenement = ev;
        nom.setText(ev.getNom());  
    }
     public void setController(AfficheEvenementController e)
    {
        controller = e;
    }
    @FXML
    private void edit(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaces/editEvenement.fxml"));
            Parent root = loader.load();
            EditEvenementController edite = loader.getController();
            edite.setUp(currentEvenement);
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
                new EvenementService().supprimer(currentEvenement.getId());
                controller.refreshList();
            }

    }

    @FXML
    private void details(ActionEvent event) {
           try{
            evenement e = currentEvenement;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaces/singleEvent.fxml"));
            Parent root = loader.load();
            SingleEventController dc = loader.getController();
            dc.setEvenement(e);
            Hbox.getScene().setRoot(root);
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
