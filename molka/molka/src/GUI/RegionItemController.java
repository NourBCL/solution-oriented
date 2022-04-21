/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Region;
import Services.RegionService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
public class RegionItemController implements Initializable {

    @FXML
    private ImageView imgJeu;
    
    
    private BorderPane bp = HomePageController.hpc.getBp();
    private Region region = null;
    @FXML
    private ImageView add_jeu_image;
    @FXML
    private ImageView edit_jeu;
    @FXML
    private ImageView remove_jeu;
    @FXML
    private Label regionnamer;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void setData(Region region) {
        this.region = region;
        String url = getClass().getResource("images/" + region.getImage()).toString();
        imgJeu.setImage(new Image(url, true));
        regionnamer.setText(region.getNomregion());
    }

    void setData() {
        String url = getClass().getResource("images/add.png").toString();
        imgJeu.setImage(new Image(url, true));
        imgJeu.setVisible(true);
        edit_jeu.setVisible(false);
        remove_jeu.setVisible(false);

    }
    
    private void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        bp.setCenter(root);
    }

    @FXML
    private void add_jeu_image_pressed(MouseEvent event) {
        Modifier_ajouter_RegionControllerController.region = null;
        try {
            loadPage("Modifier_ajouter_RegionController");
        } catch (IOException ex) {
            Logger.getLogger(RegionItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void edit_jeu_pressed(MouseEvent event) throws IOException {
         Modifier_ajouter_RegionControllerController.region = this.region;
       loadPage("Modifier_ajouter_RegionController");
    }

    @FXML
    private void remove_jeu_pressed(MouseEvent event) {
        RegionService rs = new RegionService();
                rs.supprimerRegion(region.getId());
                ShowRegionsController.reload();
 
    }
    
}
