/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class HomePageController implements Initializable {

    @FXML
    private BorderPane bp;

    static HomePageController hpc;
    @FXML
    private AnchorPane ap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bp.setCenter(ap);

        hpc = this;
    }

    private void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(page + ".fxml"));

        bp.setCenter(root);
    }

    public static void loadPages(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(HomePageController.class.getResource(page + ".fxml"));

        hpc.bp.setCenter(root);
    }

    @FXML
    private void goRegion(MouseEvent event) throws IOException {
        loadPage("ShowRegions");
    }

    @FXML
    private void gotoRestau(MouseEvent event) throws IOException {
        loadPage("ShowRestau");
    }

    public BorderPane getBp() {
        return bp;
    }

}
