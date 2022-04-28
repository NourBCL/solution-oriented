/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import entites.Transport;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.TransportService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import util.MyBD;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class TransportModifierController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private TextField lieu_depart;
    @FXML
    private Button A;
    @FXML
    private ComboBox<Integer> categorie;
    @FXML
    private Hyperlink prec;
    @FXML
    private Label imgpathttt;
    @FXML
    private TextField lieu_arrivee;
    @FXML
    private TextField heure_depart;
    @FXML
    private TextField heure_retour;
    @FXML
    private TextField heure_arrivee;
    @FXML
    private DatePicker date_dep;
    @FXML
    private DatePicker date_arrivee;
    @FXML
    private DatePicker date_retour;
    @FXML
    private TextField nb_place;
    @FXML
    private TextField nb_bagage;
    @FXML
    private TextField prix_t;
    @FXML
    private TextField disponibilite;
    @FXML
    private Label labelid;
Connection cnx;
    @FXML
    private JFXButton transport;

    public TransportModifierController() {
        cnx = MyBD.getInstance().getConnection();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            String req = "select * from categorie_t";
            Statement stm = cnx.createStatement();
            ResultSet rst = stm.executeQuery(req);
            
            while (rst.next()) {
             //   Users a = new Users(rst.getInt("id"));
                
                Integer xx = rst.getInt("id");
                categorie.getItems().add(xx);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
          
          java.sql.Date r;
        r = new java.sql.Date(TransportGestionController.connectedTransport.getDate_dep().getTime());
        LocalDate date = r.toLocalDate();
        
            java.sql.Date r2;
        r2 = new java.sql.Date(TransportGestionController.connectedTransport.getDate_arrivee().getTime());
        LocalDate date2 = r2.toLocalDate();
        
                 java.sql.Date r3;
        r2 = new java.sql.Date(TransportGestionController.connectedTransport.getDate_retour().getTime());
        LocalDate date3 = r2.toLocalDate();

        labelid.setText(Integer.toString(TransportGestionController.connectedTransport.getId()));
        categorie.setValue(TransportGestionController.connectedTransport.getId_cat());
         lieu_depart.setText(TransportGestionController.connectedTransport.getLieu_depart());
         
         
        lieu_arrivee.setText( TransportGestionController.connectedTransport.getLieu_arrivee());
             heure_arrivee.setText( TransportGestionController.connectedTransport.getHeure_arrivee());
             heure_depart.setText( TransportGestionController.connectedTransport.getHeure_depart());
             heure_retour.setText( TransportGestionController.connectedTransport.getHeure_retour());
             
           
nb_place.setText(Integer.toString( TransportGestionController.connectedTransport.getNb_place()));
nb_bagage.setText(Integer.toString( TransportGestionController.connectedTransport.getNb_bagage()));
prix_t.setText(Integer.toString( TransportGestionController.connectedTransport.getPrix_t()));
disponibilite.setText(Integer.toString( TransportGestionController.connectedTransport.getDisp()));

        date_dep.setValue( date  );
         date_arrivee.setValue( date2  ); 
             date_retour.setValue( date2  ); 
          
          
          
          
          
          
          
          
          
          
          
          
    }    

    @FXML
    private void insert(ActionEvent event) throws IOException, SQLException, NoSuchAlgorithmException {
          TransportService productService = new TransportService();
        
        if (lieu_depart.getText().equals("")
                || lieu_arrivee.getText().equals("")
                || heure_arrivee.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();
            
            
            
            
        }  
               
               
              else if (lieu_depart.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")
                || lieu_arrivee.getText().equals("")
                || heure_arrivee.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText(" doit pas contenir un symbole ");
            a.setHeaderText(null);
            a.showAndWait();
            
        
        }       
               
               
               
                 
           java.util.Date date2
                = java.util.Date.from(this.date_dep.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                 java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
                 
                   java.util.Date date3
                = java.util.Date.from(this.date_arrivee.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                 java.sql.Date sqlDate3 = new java.sql.Date(date2.getTime());
            
                  java.util.Date date4
                = java.util.Date.from(this.date_retour.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                 java.sql.Date sqlDate4 = new java.sql.Date(date2.getTime());
   
              
        Transport c = new Transport(Integer.parseInt(labelid.getText()),categorie.getValue(),lieu_depart.getText(),lieu_arrivee.getText(),
                sqlDate2,sqlDate3,heure_arrivee.getText(),heure_depart.getText(),sqlDate4,
                heure_retour.getText(),Integer.parseInt(nb_place.getText()),Integer.parseInt(nb_bagage.getText()),
                Integer.parseInt(prix_t.getText()),Integer.parseInt(disponibilite.getText()));
              
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Confirmer ");
            a.setHeaderText(null);
            a.showAndWait();
        
        productService.modifierTransport(c);
                      TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Transport Modifié avec succées");
            tray.setMessage("Transport Modifié avec succées");
            tray.setNotificationType(NotificationType.SUCCESS);//
            tray.showAndDismiss(Duration.millis(3000));
              
       
      Parent page1 = FXMLLoader.load(getClass().getResource("TransportGestion.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Transports");
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void prec(ActionEvent event) throws IOException {
        
        
            prec.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportGestion.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        
    
    
}

    @FXML
    private void transport(ActionEvent event) throws IOException {
         Parent page1 = FXMLLoader.load(getClass().getResource("TransportGestion.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des transport");
        stage.setScene(scene);
        stage.show();
    }
}
