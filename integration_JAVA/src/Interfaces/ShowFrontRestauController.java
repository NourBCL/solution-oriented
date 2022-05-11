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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author louay
 */
public class ShowFrontRestauController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    private static void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(BackRestaurantController.class.getResource(page + ".fxml"));

        HomePageController.hpc.getBp().setCenter(root);
    }

    public static void reload() {
        try {
            loadPage("ShowFrontRestau");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RestaurantService rs = new RestaurantService();

        int col = 0;
        int row = 0;

        try {
            for (Restaurant r : rs.display()) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("RestauFrontItem.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

                RestauFrontItemController itemController = fxmlLoader.getController();
                itemController.setData(r);

                if (col == 2) {
                    col = 0;
                    row++;
                }

                grid.add(anchorpane, col++, row);

                GridPane.setMargin(anchorpane, new Insets(10));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
