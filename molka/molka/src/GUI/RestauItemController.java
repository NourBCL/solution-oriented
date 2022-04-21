/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Restaurant;
import Services.RegionService;
import Services.RestaurantService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class RestauItemController implements Initializable {

    @FXML
    private ImageView imgJeu;
    @FXML
    private ImageView edit_jeu;
    @FXML
    private ImageView remove_jeu;
    @FXML
    private Label phonenumber;
    @FXML
    private Label regionname;
    @FXML
    private Label dateopen;
    @FXML
    private Label dateclose;
    
    public BorderPane bp;
    
    private Restaurant restaurant;
    @FXML
    private ImageView add_jeu_image;
    @FXML
    private ImageView whiteimage;
    @FXML
    private ImageView phonelogo;
    @FXML
    private ImageView regionlogo;
    @FXML
    private ImageView datedebutlogo;
    @FXML
    private ImageView datefinlogo;
    @FXML
    private Label restauname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       bp = HomePageController.hpc.getBp();
    }    
    
    void setData(Restaurant restaurant) {
        this.restaurant = restaurant;
        phonenumber.setText(String.valueOf(restaurant.getNum()));
        regionname.setText(restaurant.getNom_reg().getNomregion());
        dateopen.setText(restaurant.getHorraire_ouverture().toString());
        dateclose.setText(restaurant.getHorraire_fermeture().toString());
        String url = getClass().getResource("images/" + restaurant.getImage()).toString();
        imgJeu.setImage(new Image(url, true));
        restauname.setText(restaurant.getNom());
    }
    
        void setData() {
        String url = getClass().getResource("images/add.png").toString();
        imgJeu.setImage(new Image(url, true));
        imgJeu.setVisible(true);
        edit_jeu.setVisible(false);
        remove_jeu.setVisible(false);
        whiteimage.setVisible(false);
        phonelogo.setVisible(false);
         regionlogo.setVisible(false);
          datedebutlogo.setVisible(false);
          datefinlogo.setVisible(false);

    }
        
       private void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        bp.setCenter(root);
    }

    @FXML
    private void edit_jeu_pressed(MouseEvent event) throws IOException {
       Modifier_ajouter_RestauController.restaurant = this.restaurant;
       loadPage("Modifier_ajouter_Restau");
    }

    @FXML
    private void remove_jeu_pressed(MouseEvent event) {
        RestaurantService rs = new RestaurantService();
                rs.supprimerRestaurant(restaurant.getId());
                ShowRestauController.reload();
    }

    @FXML
    private void add_jeu_image_pressed(MouseEvent event) {
         Modifier_ajouter_RestauController.restaurant = null;
        try {
            loadPage("Modifier_ajouter_Restau");
        } catch (IOException ex) {
            Logger.getLogger(RegionItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
