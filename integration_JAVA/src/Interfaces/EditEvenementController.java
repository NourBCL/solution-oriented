/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.categorie;
import Entities.evenement;
import static Interfaces.AjouterEvenementController.imgUploadDir;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import Services.CategorieService;
import Services.EvenementService;
import com.jfoenix.controls.JFXButton;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EditEvenementController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private ImageView imageaff;
    @FXML
    private DatePicker date_deb;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TextField prix;
    @FXML
    private ComboBox<String> category;
     
    private String path;
    File selectedFile;
    List<categorie> listcat;
    evenement currentEvenement;
    public static String imgUploadDir = "C:\\xampp\\htdocs\\solution-oriented-main\\solution-oriented-main\\symfonyProject\\public\\uploads\\event_pictures";
    @FXML
    private JFXButton transport;
    @FXML
    private JFXButton acceuil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         listcat = new CategorieService().recuperer();
        for (categorie cat : listcat) {
            category.getItems().add(cat.getNom());
        }
    }  

    public void setUp(evenement ev)
    {
        currentEvenement = ev;
        nom.setText(ev.getNom());
        description.setText(ev.getDescription());
        date_deb.setValue(ev.getDateDeb().toLocalDate());
        date_fin.setValue(ev.getDateFin().toLocalDate());
        prix.setText(String.valueOf(0));
        //affichage image
        System.out.println(ev);
        File imgFile = new File(AjouterCategorieController.imgUploadDir + "/"+ev.getImage());
        System.out.println(imgFile);
        Image imagea = new Image(imgFile.toURI().toString());
        imageaff.setImage(imagea) ;

    }
    

    @FXML
    private void ajouterEvenement(ActionEvent event) {
       if(date_deb.getValue() == null)
        {
            System.out.println("please selected date deb");
            return;
        }
        if(date_fin.getValue() == null)
        {
            System.out.println("please selected date fin");
            return;
        }
        if(Date.valueOf(date_deb.getValue()).before(Date.from(LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC))))
        {
            System.out.println("should be more than today");
            return;
        }
       if(Date.valueOf(date_deb.getValue()).after(Date.valueOf(date_fin.getValue())))
       {
           System.out.println("end date need to be > datedeb");
           //erreur
           return;
       }
       if(category.getSelectionModel().getSelectedIndex() == -1)
       {
           System.out.println("please select a category");
           return;
       }
       if(selectedFile == null)
       {
           System.out.println("select iamge");
           return;
       }
       String fileName = "";
        try {
            fileName = System.currentTimeMillis() + "." + FilenameUtils.getExtension(selectedFile.getName());
            File destFile = new File(imgUploadDir + "/" + fileName);
            FileUtils.copyFile(selectedFile, destFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
               System.out.println("selected category is " + listcat.get(category.getSelectionModel().getSelectedIndex()));

         evenement e = new evenement();
        e.setNom(nom.getText());
        e.setDescription(description.getText());
        e.setDateDeb(Date.valueOf(date_deb.getValue()));
        e.setDateFin(Date.valueOf(date_fin.getValue()));
        e.setCategoryId(listcat.get(category.getSelectionModel().getSelectedIndex()).getId_cat());
        e.setImage(fileName);

        //e.setPrix(prix.getfloat());
        EvenementService cs = new EvenementService();
        cs.ajouter(e);
        openEvenements(null);
        /*
          try {
        Parent root = FXMLLoader.load(getClass().getResource("ajouterEvenement.fxml"));
        nom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }*/
    }
    
   
    @FXML
    private void upload(ActionEvent event)throws MalformedURLException {
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
           // Image.setText(path);
            Image imagea = new Image(selectedFile.toURI().toString());
           imageaff.setImage(imagea) ;
    }
    }
        @FXML
    private void openEvenements(ActionEvent event) {
                     try {
        Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/afficheEvenement.fxml"));
        nom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

  @FXML
    void changeUser(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/Interfaces/ListeUtilisateurBack.fxml"));
//
    }

    @FXML
    private void transport(ActionEvent event) throws IOException {

        Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/TransportGestion.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des transport");
        stage.setScene(scene);
        stage.show();

    }

    

    private void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/Interfaces/"+page+".fxml"));

      //  bp.setCenter(root);
    }

    /*public static void loadPages(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(HomePageController.class.getResource(page + ".fxml"));

        bp.setCenter(root);
    }*/

    @FXML
    private void goRegion(MouseEvent event) throws IOException {
        loadPage("ShowRegions");
    }

     @FXML
    private void gotoRestau(MouseEvent event) throws IOException {
        loadPage("ShowRestau");
    }


    
    @FXML
    private void acceuilback(ActionEvent event) throws IOException {
        
         Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/AcceuilAdmin.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.setTitle("Liste des transport");
        stage.setScene(scene);
        stage.show();
        
    }

}
