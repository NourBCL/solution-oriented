/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Services.RegionService;
import Entities.Region;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
 * @author SBS
 */
public class ShowRegionsController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    
    private List<Region> regions = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        RegionService rs = new RegionService();

        int col = 0;
        int row = 0;
        

        try {
            for (Region r : rs.display()) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("RegionItem.fxml"));
               

                AnchorPane anchorpane = fxmlLoader.load();


                RegionItemController itemController = fxmlLoader.getController();
                itemController.setData(r);

                if (col == 2) {
                    col = 0;
                    row++;
                }

                grid.add(anchorpane, col++, row);

                GridPane.setMargin(anchorpane, new Insets(10));
            }
            
            
            FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("RegionItem.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

                RegionItemController itemController = fxmlLoader.getController();
                itemController.setData();

                if (col == 2) {
                    col = 0;
                    row++;
                }

                grid.add(anchorpane, col++, row);

                GridPane.setMargin(anchorpane, new Insets(10));
        
                
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }    
    
    
        private static void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(BackRestaurantController.class.getResource("/Interfaces/"+page + ".fxml"));

        HomePageController.hpc.getBp().setCenter(root);
    }
        
    public static void reload() {
        try {
            loadPage("ShowRegions");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
