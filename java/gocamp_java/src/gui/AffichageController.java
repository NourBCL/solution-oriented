/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.categorie;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.CategorieService;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AffichageController implements Initializable {

    @FXML
    private TableView<categorie> tableview;
    @FXML
    private TableColumn<categorie, String> nom;
    @FXML
    private TableColumn<categorie, String> description;
    @FXML
    private TableColumn<categorie, String> image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CategorieService cs = new CategorieService(); 
        List<categorie> categorie = cs.recuperer(); 
        ObservableList list = FXCollections.observableArrayList(categorie);
        tableview.setItems(list);
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));


    }    

    @FXML
    private void details(ActionEvent event) {
        try {
        categorie c = tableview.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("details.fxml"));
            Parent root = loader.load();
            DetailsController dc = loader.getController();
            dc.setCategorie(c);
            tableview.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
}
