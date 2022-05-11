/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Restaurant;
import Services.RestaurantService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author louay
 */
public class RestauFrontItemController implements Initializable {

    @FXML
    private ImageView imgJeu;
    @FXML
    private ImageView whiteimage;
    @FXML
    private ImageView add_jeu_image;
    @FXML
    private Label restauname;
   // public BorderPane bp;
    private Restaurant restaurant;
    @FXML
    private Rating rate;
    RestaurantService rs = new RestaurantService();

    @FXML
    private void handleButtonAction(ActionEvent event) {
        int i = (int) rate.getRating();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     //   bp = FrontHomePageController.hpc.getBp();
        rate.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number old, Number newT) {
                int value = (int) rate.getRating();
                rs.addRating(value, restaurant.getId());
            }
        });
    }

    void setData(Restaurant restaurant) {
        this.restaurant = restaurant;
        String url = getClass().getResource("images/" + restaurant.getImage()).toString();
        if (restaurant.getRating() != 0) {
            rate.setRating((double) restaurant.getRating());
        }
        imgJeu.setImage(new Image(url, true));
        restauname.setText(restaurant.getNom());
    }

    private void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        //bp.setCenter(root);
    }

}
