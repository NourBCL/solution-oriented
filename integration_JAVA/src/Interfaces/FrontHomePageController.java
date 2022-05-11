/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author louay
 */
public class FrontHomePageController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    static FrontHomePageController hpc;
    @FXML
    private JFXButton accueil;

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
        root = FXMLLoader.load(FrontHomePageController.class.getResource(page + ".fxml"));

        hpc.bp.setCenter(root);
    }

    @FXML
    private void gotoRestau(MouseEvent event) throws IOException {
        loadPage("ShowFrontRestau");
    }

    public BorderPane getBp() {
        return bp;
    }
    @FXML
void changeUser(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/Interfaces/profilUser.fxml"));
       // acpane.getChildren().add(p);

    }
    private void acceuilback(ActionEvent event) throws IOException {
        
          Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/AcceuilAdmin.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.setTitle("Liste des transport");
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void accueilfront(ActionEvent event) throws IOException {
        
          Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/AcceuilUser.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.setTitle("Liste des transport");
        stage.setScene(scene);
        stage.show();
        
    }
}
