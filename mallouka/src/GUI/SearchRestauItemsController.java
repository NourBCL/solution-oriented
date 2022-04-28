/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
public class SearchRestauItemsController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

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
            for (Restaurant r : rs.search(ShowRestauController.searchtext)) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("RestauItem.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

                RestauItemController itemController = fxmlLoader.getController();
                itemController.setData(r);

                if (col == 2) {
                    col = 0;
                    row++;
                }

                grid.add(anchorpane, col++, row);

                GridPane.setMargin(anchorpane, new Insets(10));
            }

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("RestauItem.fxml"));

            AnchorPane anchorpane = fxmlLoader.load();

            RestauItemController itemController = fxmlLoader.getController();
            itemController.setData();

            if (col == 2) {
                col = 0;
                row++;
            }

            grid.add(anchorpane, col++, row);

            GridPane.setMargin(anchorpane, new Insets(40, 10, 10, 10));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(BackRestaurantController.class.getResource(page + ".fxml"));

        HomePageController.hpc.getBp().setCenter(root);
    }

    public static void reload() {
        try {
            loadPage("ShowRestau");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
