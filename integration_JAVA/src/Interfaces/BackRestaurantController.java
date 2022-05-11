/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Services.RegionService;
import Services.RestaurantService;
import Entities.Region;
import Entities.Restaurant;
import java.io.File;
import static java.lang.Integer.parseInt;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class BackRestaurantController implements Initializable {

    private ListData1 listdata = new ListData1();
    @FXML
    private TextField inputNom1;
    @FXML
    private Button btnAjouter1;
    @FXML
    private Button modfiier1;
    @FXML
    private TextField inputNum;
    @FXML
    private DatePicker inputeOuv;
    @FXML
    private DatePicker inputFer;
    @FXML
    private ComboBox<Region> region;
    @FXML
    private ImageView img_view1;
    private TableView<Restaurant> tabResto;
    private TableColumn<Restaurant, String> colonne_nom1;
    private TableColumn<Restaurant, String> colonne_ouverture;
    private TableColumn<Restaurant, String> colonne_fermeture;
    private TableColumn<Restaurant, String> colonne_region;
    int id;
    String image = "";
    
    public static Restaurant restaurant = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RegionService rss = new RegionService();
        ObservableList<Region> regions = FXCollections.observableList(rss.display());
        
        if (restaurant != null) {
            
            region.setItems(FXCollections.observableArrayList());
        
        for (Region reg : regions) {
            if (restaurant.getNom_reg().getNomregion().equals(reg.getNomregion()))
                    region.setValue(reg);
        }
        
        }      
        region.getItems().addAll(regions);
    }
    
    

    private void refresh() {
        RestaurantService res = new RestaurantService();
        ObservableList<Restaurant> restos = res.afficher();
        listdata = new ListData1();
        tabResto.setItems(listdata.getRestos());
        colonne_nom1.setCellValueFactory(cell -> cell.getValue().getNom1());
        colonne_ouverture.setCellValueFactory(cell -> cell.getValue().getHorraire_ouverture1());
        colonne_fermeture.setCellValueFactory(cell -> cell.getValue().getHorraire_fermeture1());
        colonne_region.setCellValueFactory(cell -> cell.getValue().getregion());
    }

    @FXML
    private void AddResto(ActionEvent event) throws Exception {
        String nom = inputNom1.getText();
        java.sql.Date getDatepickerDateouv = java.sql.Date.valueOf(inputeOuv.getValue());
        java.sql.Date getDatepickerDateferm = java.sql.Date.valueOf(inputFer.getValue());
        int num = parseInt(inputNum.getText());
        if((Integer.toString(num).length()!=8)||(nom.length()==0)||(inputeOuv.getValue().toString().length()==0)||(inputFer.getValue().toString().length()==0)){
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Verifiez vos données");

        alert.show();
        }else{
        Restaurant re = new Restaurant(nom, num, getDatepickerDateouv, getDatepickerDateferm, image, region.getValue());
        RestaurantService res = new RestaurantService();
        res.ajouterOrganisateur(re);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Restaurant ajouté");

        alert.show();}
    }

    @FXML
    private void modifierResto(ActionEvent event) {
        java.sql.Date getDatepickerDateouv = java.sql.Date.valueOf(inputeOuv.getValue());
        java.sql.Date getDatepickerDateferm = java.sql.Date.valueOf(inputFer.getValue());

        String nom = inputNom1.getText();
        String reg = region.getAccessibleText();
        int num = parseInt(inputNum.getText());
        Restaurant re = new Restaurant(nom, num, getDatepickerDateouv, getDatepickerDateferm, image, region.getValue());
        RestaurantService res = new RestaurantService();
       // res.ModifierRestaurant(id, re);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Restaurant ajouté");

        alert.show();
    }

    @FXML
    private void importerImg(ActionEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        Window primaryStage = null;
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        image = selectedFile.toURI().toURL().toString();
        img_view1.setImage(new Image(image));

    }

    private void suppResto(ActionEvent event) {
        RestaurantService res = new RestaurantService();

        int ref = tabResto.getSelectionModel().getSelectedItem().getId();
        res.supprimerRestaurant(ref);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Resto supprimé");

        alert.show();
        refresh();
    }


}
