/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.SigninController.idu;
import Entities.Utilisateur;
import Services.ServiceUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class modifprofilcontroller implements Initializable {

    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_num;
    ServiceUtilisateur userser = new ServiceUtilisateur();
    @FXML
    private TextField passe;
    @FXML
    private TextField img;
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private Pane acpane;
    @FXML
    private Label id_lab;
    @FXML
    private Label lid;
    @FXML
 //   private TextField role;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
loaddata();    }    

    @FXML
    private void modifier(ActionEvent event) throws IOException {
         Utilisateur upuser = new Utilisateur(idu, txt_nom.getText(), txt_prenom.getText(), Integer.parseInt(txt_num.getText()), passe.getText(), txt_email.getText(),img.getText());
        userser.modifier(upuser);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("modification avec succés!");
        
        alert.show();
        
        
        Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/AcceuilUser.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Go Camp");
        stage.setScene(scene);
        stage.show();
    }
    
    private void loaddata(){ // recuperer les données à partir de la base de données 
                Connection cnx=DataSource.getInstance().getCnx();
        try {
            String req = "select * from utilisateur where id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, idu);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                txt_nom.setText(rs.getString("nom")); 
                 txt_prenom.setText(rs.getString("prenom"));
                  txt_email.setText(rs.getString("email"));
                   txt_num.setText(String.valueOf(rs.getInt("num_tel")));
                    //txt_genre.setText(rs.getString("date_naissance"));
                //  role.setText(rs.getString("role"));
                 passe.setText(rs.getString("password"));
                    img.setText(rs.getString("image"));
            /*    System.out.println(nom);
                Lnom.setText(nom);
                
                prenom=rs.getString("prenom");
                Lprenom.setText(prenom);
                
                 num=rs.getInt("num_tel");
                Lnum.setText(String.valueOf(num));
                
                email=rs.getString("adress_email");
                LAdress.setText(email);
                
                genre=rs.getString("genre");
                Lgenre.setText(genre);
                
                */
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void changeUser(ActionEvent event) throws IOException {
          Pane p = FXMLLoader.load(getClass().getResource("/Interfaces/profilUser.fxml"));
        acpane.getChildren().add(p);
    }
}
