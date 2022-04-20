/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class AfficherDetailTransportController implements Initializable {

    @FXML
    private Label lieu_depart;
    @FXML
    private Label lieu_arrivee;
    @FXML
    private Label date_dep;
    @FXML
    private Label date_arrivee;
    @FXML
    private Label heure_arrivee;
    @FXML
    private Label heure_depart;
    @FXML
    private Label date_retour;
    @FXML
    private Label heure_retour;
    @FXML
    private Label nb_bagage;
    @FXML
    private Label nb_place;
    @FXML
    private Label prix_t;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              nb_place.setText(Integer.toString(TransportFrontController.connectedTransport.getNb_place()));
         
          nb_bagage.setText(Integer.toString( TransportFrontController.connectedTransport.getNb_bagage()));
                      
            lieu_depart.setText( TransportFrontController.connectedTransport.getLieu_depart());
             lieu_arrivee.setText( TransportFrontController.connectedTransport.getLieu_arrivee());
              
                            heure_retour.setText( TransportFrontController.connectedTransport.getHeure_retour());

        heure_depart.setText( TransportFrontController.connectedTransport.getHeure_depart());
         heure_arrivee.setText( TransportFrontController.connectedTransport.getHeure_arrivee());
         
         prix_t.setText( Integer.toString(TransportFrontController.connectedTransport.getPrix_t()));
 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           String strDate = dateFormat.format(TransportFrontController.connectedTransport.getDate_dep());  
           String strDate2 = dateFormat.format(TransportFrontController.connectedTransport.getDate_retour());    
             String strDate3 = dateFormat.format(TransportFrontController.connectedTransport.getDate_arrivee());  
            date_dep.setText(strDate);
            
            date_retour.setText(strDate);
            
             date_arrivee.setText(strDate);
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
      Parent page1 = FXMLLoader.load(getClass().getResource("TransportGestion.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des transport");
        stage.setScene(scene);
        stage.show();
        
    }
    
}
