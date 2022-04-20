///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package gui;
//
//import entities.categorie;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.control.Alert;
//import javafx.scene.control.TextField;
//import service.CategorieService;
//
//
///**
// * FXML Controller class
// *
// * @author User
// */
//public class FormulaireController implements Initializable {
//
//    @FXML
//    private TextField nom;
//    @FXML
//    private TextField description;
//    @FXML
//    private TextField image;
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
//
//    @FXML
//    private void ajouterCategorie(ActionEvent event) {
//        categorie c = new categorie();
//        c.setNom(nom.getText());
//        c.setDesciption(description.getText());
//        c.setImage(image.getText());
//        CategorieService cs = new CategorieService();
//        cs.ajouter(c);
//        
//            //alert
////        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
////        alert.setTitle("success");
////        alert.setContentText("Categorie ajoutée");
////        alert.show();
//        try {
//        Parent root = FXMLLoader.load(getClass().getResource("Affichage.fxml"));
//        nom.getScene().setRoot(root);
//        } catch (IOException ex) {
//            System.err.println(ex.getMessage());
//        }
//
//       
//    }
//    
//}
