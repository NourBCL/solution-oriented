/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import entite.Commande;
import entite.CommandeE;
import entite.CommandeT;
import entite.Transport;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.CommandeEService;
import service.CommandeService;
import service.CommandeTService;
import service.TransportService;

/**
 * FXML Controller class
 *
 * @author omaro
 */
public class AjoutComController implements Initializable {

    @FXML
    private TextField a;
    @FXML
    private DatePicker b;
    @FXML
    private JFXButton ajout;
    CommandeService sv = new CommandeService();
    Commande e;
    CommandeTService ts = new CommandeTService();
    TransportService cts = new TransportService();
    CommandeEService rs = new CommandeEService();
    CommandeT t;
    CommandeE r;
    @FXML
    private ComboBox<Integer> combcat;
    ObservableList<CommandeT> list;
      ObservableList<Integer> catNames;
    @FXML
       private ComboBox<Integer> combcatt;
    ObservableList<CommandeE> listt;
      ObservableList<Integer> catNamest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        catNames = FXCollections
                .observableArrayList(
                        ts.recuperer().stream().map(c -> c.getId()).collect(Collectors.toList())
                );

//        System.out.println(catNames);

        combcat.setItems(catNames);
        catNamest = FXCollections
                .observableArrayList(
                        rs.recuperer().stream().map(c -> c.getId()).collect(Collectors.toList())
                );

//        System.out.println(catNames);

        combcatt.setItems(catNamest);
    }

    public void setCommande(Commande p) {

        a.setText(p.getAdresse_destination());
        b.setValue(LocalDate.now());

        e = p;
    }

    @FXML
    private void add(ActionEvent event) throws IOException {
        if (a.getText().isEmpty() || b.getValue().isLeapYear()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!");
            alert.setHeaderText(null);
            alert.setContentText(" Champ vide!"
                    + "zid 7wija l rabi ");
            alert.show();
        } else {
//            Integer idCategory = ts.GetById(combcat.getValue());
//            e.setAdresse_destination(a.getText());
//            e.setDate_commande(java.sql.Date.valueOf(b.getValue()));
//            e.setCommande_e_c_id(1);
//            e.setCommande_m_c_id(1);
//            e.setCommmande_t_c_id(1);
            
            Commande e = new Commande(a.getText(), java.sql.Date.valueOf(b.getValue()), combcatt.getValue(), 1, combcat.getValue());
            sv.ajouter(e);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succesful");
            alert.setHeaderText(null);
            alert.setContentText(" Commande ajouter avec succéez!"
                    + "3ak3ek 7ala m3ak");
            alert.show();
            ((Stage) ajout.getScene().getWindow()).close();

        }
        Parent page1 = FXMLLoader.load(getClass().getResource("FrontCommande Controller.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Ajouter une Commande");
        stage.setScene(scene);
        stage.show(); 
    }

}
