/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Region;
import Entities.Restaurant;
import static GUI.Modifier_ajouter_RegionControllerController.region;
import Services.RegionService;
import Services.RestaurantService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class Modifier_ajouter_RestauController implements Initializable {

    @FXML
    private JFXTextField input_nom;
    @FXML
    private ImageView image;
    @FXML
    private Label nomimage;
    @FXML
    private JFXTextField num;
    @FXML
    private JFXComboBox<Region> region;
    @FXML
    private JFXDatePicker dateopen;
    @FXML
    private JFXDatePicker dateclose;

    String imagelink = "";

    public static Restaurant restaurant = null;

    private Region selectedregion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        RegionService rss = new RegionService();
        ObservableList<Region> regions = FXCollections.observableList(rss.display());

        if (restaurant != null) {
            imagelink = restaurant.getImage();
            input_nom.setText(restaurant.getNom());
            num.setText(String.valueOf(restaurant.getNum()));
            Image imr = new Image(getClass().getResource("images/" + restaurant.getImage()).toString());
            image.setImage(imr);
            region.setItems(FXCollections.observableArrayList());

            dateclose.setValue(restaurant.getHorraire_fermeture().toLocalDate());
            dateopen.setValue(restaurant.getHorraire_ouverture().toLocalDate());
            
            for (Region r : regions) {
                    System.out.println(r.getNomregion());
                if (restaurant.getNom_reg().getNomregion().equals(r.getNomregion())) {
                    region.setValue(r);
                    selectedregion = r;
                }
            }
        }
        region.getItems().addAll(regions);

    }

    @FXML
    private void onValiderClicked(MouseEvent event) throws Exception {
        
        Restaurant r = new Restaurant();
        r.setNom(input_nom.getText());
        r.setImage(imagelink);
        r.setNum(Integer.parseInt(num.getText()));
        r.setHorraire_ouverture(Date.valueOf(dateopen.getValue()));
        r.setHorraire_fermeture(Date.valueOf(dateclose.getValue()));
        r.setNom_reg(region.getValue());
                
if((Integer.toString(r.getNum()).length()!=8)||(r.getNom().length()==0)||(r.getHorraire_fermeture().toString().length()==0)||(r.getHorraire_ouverture().compareTo(Date.valueOf(LocalDate.now()))<0)||(r.getHorraire_ouverture().compareTo(r.getHorraire_fermeture())>0)){
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Verifiez vos données");

        alert.show();
        }else{ 
        RestaurantService irestau = new RestaurantService();
        if (restaurant == null) {
            irestau.ajouterOrganisateur(r);
        } else {
            
            r.setId(restaurant.getId());
            irestau.ModifierRestaurant(r);
            region = null;
        }

        input_nom.clear();
        num.clear();}
    }

    @FXML
    private void onclickonaddimage(ActionEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        Window primaryStage = null;
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        imagelink = selectedFile.toURI().toURL().toString().substring(selectedFile.toURI().toURL().toString().lastIndexOf("/") + 1);
        Image imr = new Image(getClass().getResource("images/" + imagelink).toString());
        image.setImage(imr);
    }
    


}
