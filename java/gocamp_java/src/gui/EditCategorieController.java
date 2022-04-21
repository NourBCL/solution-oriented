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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import service.CategorieService;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EditCategorieController implements Initializable {
     @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private ImageView imageaff;
    private String path;
    File selectedFile;
    categorie currentCategorie;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setUp(categorie cat)
    {
        currentCategorie = cat;
        nom.setText(cat.getNom());
        description.setText(cat.getDesciption());
        //affichage image
        System.out.println(cat);
        File imgFile = new File(AjouterCategorieController.imgUploadDir + "/"+cat.getImage());
        System.out.println(imgFile);
        Image imagea = new Image(imgFile.toURI().toString());
        imageaff.setImage(imagea) ;

    }
    
    @FXML
    private void ajouterCategorie(ActionEvent event) {
        categorie c = currentCategorie;
        c.setNom(nom.getText());
        c.setDesciption(description.getText());
        String fileName = c.getImage();
        if(selectedFile != null)
        {
            try {
                fileName = System.currentTimeMillis() + "." + FilenameUtils.getExtension(selectedFile.getName());
                File destFile = new File(imgUploadDir + "/" + fileName);
                FileUtils.copyFile(selectedFile, destFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        c.setImage(fileName);
        CategorieService cs = new CategorieService();
        cs.modifier(c);
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

 
   
}
