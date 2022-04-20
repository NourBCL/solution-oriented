/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.categorie;
import entities.evenement;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import service.CategorieService;
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AjouterEvenementController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private ImageView imageaff;
    private String path;
    File selectedFile;
    @FXML
    private DatePicker date_deb;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TextField prix;
      @FXML
    private ComboBox<?> categorie;
//      CategorieService pexp = new CategorieService();
//    private ObservableList<String> stationsList = FXCollections.observableArrayList();
//    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//         ObservableList CATList = FXCollections.observableList(pexp.recupererID());
//        categorie.setItems(CATList);
    }    
    
     @FXML
    private void ajouterEvenement(ActionEvent event) {
         evenement e = new evenement();
        e.setNom(nom.getText());
        e.setDescription(description.getText());
        e.setDateDeb(Date.valueOf(date_deb.getValue()));
        e.setDateFin(Date.valueOf(date_fin.getValue()));
        e.setImage(path);
        //e.setPrix(prix.getfloat());
        EvenementService cs = new EvenementService();
        cs.ajouter(e);
          try {
        Parent root = FXMLLoader.load(getClass().getResource("ajouterEvenement.fxml"));
        nom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @FXML
    private void upload(ActionEvent event) throws MalformedURLException{
         FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") ));
        fc.setTitle("Veuillez choisir l'image");
        fc.getExtensionFilters().addAll(
                //new FileChooser.ExtensionFilter("Image", ".jpg", ".png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            path = selectedFile.getName();
//    
           // Image.setText(path);
            Image imagea = new Image(selectedFile.toURI().toString());
           imageaff.setImage(imagea) ;
    }
    }
}
