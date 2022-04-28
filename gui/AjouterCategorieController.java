/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.categorie;
import static gui.AjouterEvenementController.imgUploadDir;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.controlsfx.control.Notifications;
import service.CategorieService;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AjouterCategorieController implements Initializable {
     @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private ImageView imageaff;
    private String path;
    File selectedFile;

   
    public static String imgUploadDir = "C:\\xampp\\htdocs\\solution-oriented-main\\solution-oriented-main\\symfonyProject\\public\\uploads\\category_event_pictures";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void ajouterCategorie(ActionEvent event) {
        categorie c = new categorie();
        c.setNom(nom.getText());
        c.setDesciption(description.getText());
        String fileName = "";
        try {
            fileName = System.currentTimeMillis() + "." + FilenameUtils.getExtension(selectedFile.getName());
            File destFile = new File(imgUploadDir + "/" + fileName);
            FileUtils.copyFile(selectedFile, destFile);
            Notifications notificationBuilder = Notifications.create().title("categorie ajoutée")
                     .text("Votre categorie est ajoutée à la liste des categories")
                     //.graphic(new ImageView(img)).hideAfter(Duration.seconds(8))
                     .position(Pos.TOP_RIGHT)
                     .onAction(new EventHandler<ActionEvent>(){
                
                public void handle(ActionEvent event){
                    System.out.println("Clicked on notification");}});
            notificationBuilder.showConfirm();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        c.setImage(fileName);
        CategorieService cs = new CategorieService();
        cs.ajouter(c);
          try {
        Parent root = FXMLLoader.load(getClass().getResource("AfficheCategorie.fxml"));
        nom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

       
    }
    @FXML
    private void upload(ActionEvent event) {
         FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") ));
        fc.setTitle("Veuillez choisir l'image");
        fc.getExtensionFilters().addAll(
                //new FileChooser.ExtensionFilter("Image", ".jpg", ".png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            path = selectedFile.getName();
//    
            //Image.setText(path);
            Image imagea = new Image(selectedFile.toURI().toString());
           imageaff.setImage(imagea) ;

        }
    }

    @FXML
    private void openCategories(ActionEvent event) {
        System.out.println("test");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("afficheCategorie.fxml"));
            nom.getScene().setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    @FXML
    private void openEvenements(ActionEvent event) {
                  try {
        Parent root = FXMLLoader.load(getClass().getResource("afficheEvenement.fxml"));
        nom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

 
     
   
}
