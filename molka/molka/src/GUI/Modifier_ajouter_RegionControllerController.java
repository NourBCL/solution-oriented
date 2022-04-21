/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Region;
import Services.RegionService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class Modifier_ajouter_RegionControllerController implements Initializable {

    @FXML
    private JFXTextField input_nom;
    @FXML
    private ImageView image;

    public static Region region = null;
    
    String imagelink = "";
    @FXML
    private Label nomimage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (region != null) {
            imagelink = region.getImage();
            System.out.println(imagelink);
            input_nom.setText(region.getNomregion()); 
            nomimage.setText(region.getImage());
            Image imr = new Image(getClass().getResource("images/" + region.getImage()).toString());
            image.setImage(imr);
            
            
        }
    }    

    @FXML
    private void onValiderClicked(MouseEvent event) {
        
        Region r = new Region();
        r.setNomregion(input_nom.getText());
        r.setImage(imagelink);

        RegionService iregion = new RegionService();
        if (region == null) {
            iregion.ajouterRegion(r);
        } else {
            
            r.setId(region.getId());
            iregion.ModifierRegion(r);
            region = null;
        }

        input_nom.clear();
    }

    @FXML
    private void onclickonaddimage(ActionEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        Window primaryStage = null;
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        imagelink = selectedFile.toURI().toURL().toString().substring(selectedFile.toURI().toURL().toString().lastIndexOf("/") + 1);
        Image imr = new Image(getClass().getResource("images/" + imagelink).toString());
        image.setImage(imr);
    }
    
}
