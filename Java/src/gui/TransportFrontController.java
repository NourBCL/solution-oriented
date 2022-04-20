/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Transport;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.TransportService;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class TransportFrontController implements Initializable {
public static Transport connectedTransport;
    @FXML
    private Button supp1;
    @FXML
    private TableView<Transport> tableview;
    @FXML
    private TableColumn<?, ?> categorie_t_id;
    @FXML
    private TableColumn<?, ?> lieu_depart;
    @FXML
    private TableColumn<?, ?> lieu_arrivee;
    @FXML
    private TableColumn<?, ?> date_dep;
    @FXML
    private TableColumn<?, ?> date_arrivee;
    @FXML
    private TableColumn<?, ?> heure_arrivee;
    @FXML
    private TableColumn<?, ?> heure_depart;
    @FXML
    private TableColumn<?, ?> date_retour;
    @FXML
    private TableColumn<?, ?> heure_retour;
    @FXML
    private TableColumn<?, ?> nb_place;
    @FXML
    private TableColumn<?, ?> nb_bagage;
    @FXML
    private TableColumn<?, ?> prix_t;
 public ObservableList<Transport> list;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      TransportService pss = new TransportService();
        ArrayList<Transport> c = new ArrayList<>();
        try {
            c = (ArrayList<Transport>) pss.AfficherAllTransport();
        } catch (SQLException ex) {
            System.out.println("erreurrrrrrrrrrrrr");
        }
        
        ObservableList<Transport> obs2 = FXCollections.observableArrayList(c);
        tableview.setItems(obs2);
        
        
 categorie_t_id.setCellValueFactory(new PropertyValueFactory<>("categorie_t_id"));
        lieu_depart.setCellValueFactory(new PropertyValueFactory<>("lieu_depart"));
        lieu_arrivee.setCellValueFactory(new PropertyValueFactory<>("lieu_arrivee"));
        date_dep.setCellValueFactory(new PropertyValueFactory<>("date_dep"));
                date_arrivee.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
                   heure_arrivee.setCellValueFactory(new PropertyValueFactory<>("heure_arrivee"));
                      heure_depart.setCellValueFactory(new PropertyValueFactory<>("heure_depart"));
                    date_retour.setCellValueFactory(new PropertyValueFactory<>("date_retour"));
                heure_retour.setCellValueFactory(new PropertyValueFactory<>("heure_retour"));
                   nb_place.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
                      
                   nb_bagage.setCellValueFactory(new PropertyValueFactory<>("nb_bagage"));      
                   prix_t.setCellValueFactory(new PropertyValueFactory<>("prix_t"));      
            try {
            list = FXCollections.observableArrayList(
                    pss.AfficherAllTransport()
            );        
           } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }    

    @FXML
    private void Modif(ActionEvent event) throws IOException {
           TransportService ps = new TransportService();
        Transport c = new Transport(tableview.getSelectionModel().getSelectedItem().getId(),
                
                tableview.getSelectionModel().getSelectedItem().getId_cat(),
                
                tableview.getSelectionModel().getSelectedItem().getLieu_depart(),
                 tableview.getSelectionModel().getSelectedItem().getLieu_arrivee(),
                tableview.getSelectionModel().getSelectedItem().getDate_dep(),
                tableview.getSelectionModel().getSelectedItem().getDate_arrivee(),
                        tableview.getSelectionModel().getSelectedItem().getHeure_arrivee(),
                                tableview.getSelectionModel().getSelectedItem().getHeure_depart(),
                                            tableview.getSelectionModel().getSelectedItem().getDate_retour(),
                
                     tableview.getSelectionModel().getSelectedItem().getHeure_retour(),
                      tableview.getSelectionModel().getSelectedItem().getNb_place(),
                   tableview.getSelectionModel().getSelectedItem().getNb_bagage(),
                              tableview.getSelectionModel().getSelectedItem().getPrix_t(),
                                         tableview.getSelectionModel().getSelectedItem().getDisp()
                );
        TransportFrontController.connectedTransport = c;
        
             Parent page1 = FXMLLoader.load(getClass().getResource("AfficherDetailTransport.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
        
        
        
    }
    
}
