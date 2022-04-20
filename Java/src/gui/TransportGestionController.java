/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Transport;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.TransportService;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class TransportGestionController implements Initializable {
TransportService cs = new TransportService();
    @FXML
    private TextField inputRech;
    @FXML
    private Button supp;
    @FXML
    private Button supp1;
    @FXML
    private Button Ajouter;
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
    public static Transport connectedTransport;
    public ObservableList<Transport> list;
    @FXML
    private Hyperlink cat;
    @FXML
    private Hyperlink Front;
    
    
    
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
        
        
   FilteredList<Transport> filteredData = new FilteredList<>(list, e -> true);
            inputRech.setOnKeyReleased(e -> {
                inputRech.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super Transport>) Transports -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        if (Transports.getLieu_depart().toLowerCase().contains(lower)) {
                            return true;
                        }

                        return false;
                    });
                });
                SortedList<Transport> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
     public void resetTableData() throws SQLDataException, SQLException {

        List<Transport> Transports = new ArrayList<>();
        Transports = cs.AfficherAllTransport();
        ObservableList<Transport> data = FXCollections.observableArrayList(Transports);
        tableview.setItems(data);
    }    
    @FXML
    private void supp(ActionEvent event) throws SQLException {
             if (event.getSource() == supp) {
            Transport e = new Transport();
            e.setId(tableview.getSelectionModel().getSelectedItem().getId());  
            TransportService cs = new TransportService();
            cs.SupprimerTransport(e);
            resetTableData();  
        
        
    } }

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
        TransportGestionController.connectedTransport = c;
        
             Parent page1 = FXMLLoader.load(getClass().getResource("TransportModifier.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
        
        
        
        
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
           Parent page1 = FXMLLoader.load(getClass().getResource("TransportAjout.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Ajouter un transport");
        stage.setScene(scene);
        stage.show(); 
        
        
    }

    @FXML
    private void cat(ActionEvent event) throws IOException {
           Parent page1 = FXMLLoader.load(getClass().getResource("CategorieGestion.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Ajouter un transport");
        stage.setScene(scene);
        stage.show(); 
        
        
    }

    @FXML
    private void Front(ActionEvent event) throws IOException {
                    Parent page1 = FXMLLoader.load(getClass().getResource("TransportFront.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Transports");
        stage.setScene(scene);
        stage.show(); 
        
        
    }
        
        
    }
    

