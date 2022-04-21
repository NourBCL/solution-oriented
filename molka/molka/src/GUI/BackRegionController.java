/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.RegionService;
import Services.RestaurantService;
import Entities.Region;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author SHS TECH
 */
public class BackRegionController implements Initializable {

    @FXML
    private Button openFile;
    @FXML
    private TextField inputNom;
    @FXML
    private Button btnAjouter;
    private String image="";
    @FXML
    private Label lab;
    @FXML
    private ImageView img_view;
    @FXML
    private TableView<Region> tabRegion;
    @FXML
    private TableColumn<Region, String> colonne_nom;
    @FXML
    private TableColumn<Region, String> colonne_image;
private ListData listdata = new ListData();
    @FXML
    private Button supp;
    int id;
    @FXML
    private Button rec;
    @FXML
    private TabPane tabPane;
    @FXML
    private Button modfiier;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

          refresh();
        
    
    }    

    @FXML
    private void selectfile(ActionEvent event) throws IOException {
         FileChooser fileChooser = new FileChooser();
        Window primaryStage = null;
         File selectedFile = fileChooser.showOpenDialog(primaryStage);
       
         image = selectedFile.toURI().toURL().toString();
          img_view.setImage(new Image(image));
    }
 private void refresh( ) {
          RegionService res= new RegionService();
      ObservableList<Region> regions= res.afficher();
            listdata=new ListData();
       tabRegion.setItems(listdata.getRegions());
       colonne_nom.setCellValueFactory(cell -> cell.getValue().getNomregion1());
       colonne_image.setCellValueFactory(cell -> cell.getValue().getImage1());
    }
    @FXML
    private void AddRegion(ActionEvent event) {
        String nom=inputNom.getText();
         Region reg=new Region(nom,image);
       
RegionService res=new RegionService();
res.ajouterRegion(reg);
 Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Information");
         alert.setHeaderText(null);
         alert.setContentText("Region ajouté");
         
         alert.show();
         refresh();
    }

    @FXML
    private void suppRegion(ActionEvent event) {
RegionService res=new RegionService();
         
     int ref=tabRegion.getSelectionModel().getSelectedItem().getId();
     res.supprimerRegion(ref);
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Information");
         alert.setHeaderText(null);
         alert.setContentText("Region supprimé");
         
         alert.show();
         refresh();
    }

    @FXML
    private void recupererRegion(ActionEvent event) {
          id=tabRegion.getSelectionModel().getSelectedItem().getId();
        tabPane.getSelectionModel().select(0);
       RegionService res=new RegionService();
         Region re=res.RecupererRegion(id);
         inputNom.setText(re.getNomregion());
  img_view.setImage(new Image(re.getImage()));
    }

    @FXML
    private void modifierRegion(ActionEvent event) {
           String nom=inputNom.getText();
         Region reg=new Region(nom,image);
       
RegionService res=new RegionService();
res.ModifierRegion(reg);
 Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Information");
         alert.setHeaderText(null);
         alert.setContentText("Region modifié");
         
         alert.show();
         refresh(); 
    }
    
}
