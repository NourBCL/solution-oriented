/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Commande;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import service.CommandeService;
import java.sql.Date;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author omaro
 */
public class ModComController implements Initializable {

    @FXML
    private DatePicker ct;
    @FXML
    private TextField od;
    @FXML
    private TextField ad;
    @FXML
    private Button update;
         CommandeService sv = new CommandeService();
Commande c;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
public void setCommande(Commande p){
    od.setText(String.valueOf(p.getId()));
    ad.setText(p.getAdresse_destination());
ct.setValue(LocalDate.now()); 
c = p ;
}
    
    @FXML
     public void update(ActionEvent event) {
     if (od.getText().isEmpty() || ad.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!");
            alert.setHeaderText(null);
            alert.setContentText(" Champ vide!"
                    + "zid 7wija l rabi ");
            alert.show();} else {
                  c.setId(Integer.valueOf(od.getText()));
               c.setAdresse_destination(ad.getText());
        
        c.setDate_commande(java.sql.Date.valueOf(ct.getValue()));
  
        sv.modifier(c);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succesful");
            alert.setHeaderText(null);
            alert.setContentText(" Commande modifié avec succéez!"
                    + "3ak3ek 7ala m3ak");
            alert.show();
        ((Stage) update.getScene().getWindow()).close();
    }
    }
    
}
