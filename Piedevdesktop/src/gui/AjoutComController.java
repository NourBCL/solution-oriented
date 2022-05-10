/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import entite.Commande;
import entite.Transport;
import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.CommandeService;

/**
 * FXML Controller class
 *
 * @author omaro
 */
public class AjoutComController implements Initializable {

    @FXML
    private TextField a;
    @FXML
    private ComboBox<Transport> c;
    @FXML
    private ComboBox<?> d;
    @FXML
    private DatePicker b;
    @FXML
    private JFXButton ajout;
    CommandeService sv = new CommandeService();
    Commande e;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setCommande(Commande p) {

        a.setText(p.getAdresse_destination());
        b.setValue(LocalDate.now());
        e = p;
    }

    @FXML
    private void add(ActionEvent event) {
        if (a.getText().isEmpty() || b.getValue().isLeapYear()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!");
            alert.setHeaderText(null);
            alert.setContentText(" Champ vide!"
                    + "zid 7wija l rabi ");
            alert.show();
        } else {
//            e.setAdresse_destination(a.getText());
//            e.setDate_commande(java.sql.Date.valueOf(b.getValue()));
//            e.setCommande_e_c_id(1);
//            e.setCommande_m_c_id(1);
//            e.setCommmande_t_c_id(1);
 
               Commande e = new Commande(a.getText(),java.sql.Date.valueOf(b.getValue()),1,1,1); 
sv.ajouter(e);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succesful");
            alert.setHeaderText(null);
            alert.setContentText(" Commande ajouter avec succéez!"
                    + "3ak3ek 7ala m3ak");
            alert.show();
            ((Stage) ajout.getScene().getWindow()).close();

        }
    }

}
