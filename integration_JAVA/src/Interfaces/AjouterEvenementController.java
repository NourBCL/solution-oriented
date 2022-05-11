/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.categorie;
import Entities.evenement;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.controlsfx.control.Notifications;
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
public class AjouterEvenementController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private ImageView imageaff;
    private String path;
    File selectedFile;
    @FXML
    private DatePicker date_deb;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TextField prix;
    @FXML
    private ComboBox<String> category;
    List<categorie> listcat;

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
//         ObservableList CATList = FXCollections.observableList(pexp.recupererID());
//        categorie.setItems(CATList);
    }    
    
     @FXML
    private void ajouterEvenement(ActionEvent event) {
        if(date_deb.getValue() == null)
        {
            //System.out.println("please selected date deb");
            Notifications notificationBuilder = Notifications.create().title("Vérfier votre date début")
                     //.text("Votre evenement est ajouté à la liste des événements")
                     .graphic(null).hideAfter(Duration.seconds(8))
                     .position(Pos.CENTER)
                     .onAction(new EventHandler<ActionEvent>(){
                
                public void handle(ActionEvent event){
                    System.out.println("Clicked on notification");}});
            notificationBuilder.showError();
            return;
        }
         if(Date.valueOf(date_deb.getValue()).before(Date.from(LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC))))
        {
            //System.out.println("should be more than today");
            Notifications notificationBuilder = Notifications.create().title("Vérifier votre date début")
                     .text("La date début ne peut pas être la date d'aujourd'hui")
                     .graphic(null).hideAfter(Duration.seconds(8))
                     .position(Pos.CENTER)
                     .onAction(new EventHandler<ActionEvent>(){
                
                public void handle(ActionEvent event){
                    System.out.println("Clicked on notification");}});
            notificationBuilder.showError();
            return;
        }
        if(date_fin.getValue() == null)
        {
            //System.out.println("please selected date fin");
            Notifications notificationBuilder = Notifications.create().title("Vérifier votre date fin")
                     //.text("Votre evenement est ajouté à la liste des événements")
                     .graphic(null).hideAfter(Duration.seconds(8))
                     .position(Pos.CENTER)
                     .onAction(new EventHandler<ActionEvent>(){
                
                public void handle(ActionEvent event){
                    System.out.println("Clicked on notification");}});
            notificationBuilder.showError();
            return;
        }
       
       if(Date.valueOf(date_deb.getValue()).after(Date.valueOf(date_fin.getValue())))
       {
           //System.out.println("end date need to be > datedeb");
           //erreur
           Notifications notificationBuilder = Notifications.create().title("Vérifier votre date fin")
                     .text("La date fin doit être superieure à la date début")
                     .graphic(null).hideAfter(Duration.seconds(8))
                     .position(Pos.CENTER)
                     .onAction(new EventHandler<ActionEvent>(){
                
                public void handle(ActionEvent event){
                    System.out.println("Clicked on notification");}});
            notificationBuilder.showError();
           return;
       }
       if(category.getSelectionModel().getSelectedIndex() == -1)
       {
           //System.out.println("please select a category");
           Notifications notificationBuilder = Notifications.create().title("Selectionnez une categorie")
                     //.text("Votre evenement est ajouté à la liste des événements")
                     .graphic(null).hideAfter(Duration.seconds(8))
                     .position(Pos.CENTER)
                     .onAction(new EventHandler<ActionEvent>(){
                
                public void handle(ActionEvent event){
                    System.out.println("Clicked on notification");}});
            notificationBuilder.showError();
           return;
       }
       if(selectedFile == null)
       {
           //System.out.println("select iamge");
            Notifications notificationBuilder = Notifications.create().title("Selectionnez une image")
                     //.text("Votre evenement est ajouté à la liste des événements")
                     .graphic(null).hideAfter(Duration.seconds(8))
                     .position(Pos.CENTER)
                     .onAction(new EventHandler<ActionEvent>(){
                
                public void handle(ActionEvent event){
                    System.out.println("Clicked on notification");}});
            notificationBuilder.showError();
          
           return;
       }
       String fileName = "";
        try {
            fileName = System.currentTimeMillis() + "." + FilenameUtils.getExtension(selectedFile.getName());
            File destFile = new File(imgUploadDir + "/" + fileName);
            FileUtils.copyFile(selectedFile, destFile);
            //Image img = new Image("/tick.png");
             Notifications notificationBuilder = Notifications.create().title("Evenement ajouté")
                     .text("Votre evenement est ajouté à la liste des événements")
                     //.graphic(new ImageView(img)).hideAfter(Duration.seconds(8))
                     .position(Pos.TOP_RIGHT)
                     .onAction(new EventHandler<ActionEvent>(){
                
                public void handle(ActionEvent event){
                    System.out.println("Clicked on notification");}});
            notificationBuilder.showConfirm();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
               System.out.println("selected category is " + listcat.get(category.getSelectionModel().getSelectedIndex()));

         evenement e = new evenement();
        e.setNom(nom.getText());
        e.setDescription(description.getText());
        e.setDateDeb(Date.valueOf(date_deb.getValue()));
        e.setDateFin(Date.valueOf(date_fin.getValue()));
        e.setPrix(Float.parseFloat(prix.getText()));
        e.setCategoryId(listcat.get(category.getSelectionModel().getSelectedIndex()).getId_cat());
        e.setImage(fileName);

        //e.setPrix(prix.getfloat());
        EvenementService cs = new EvenementService();
        cs.ajouter(e);
        openEvenements(null);
        
//          try {
//        Parent root = FXMLLoader.load(getClass().getResource("ajouterEvenement.fxml"));
//        nom.getScene().setRoot(root);
//        } catch (IOException ex) {
//            System.err.println(ex.getMessage());
//        }
    }
    @FXML
    private void upload(ActionEvent event) throws MalformedURLException{
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
    private void changeUser(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/Interfaces/ListeUtilisateurBack.fxml"));
       // acpane.getChildren().add(p);
        
        
    }

     private void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/Interfaces/"+page+".fxml"));

      //  bp.setCenter(root);
    }
    @FXML
    private void goRegion(MouseEvent event) throws IOException {
        loadPage("ShowRegions");
    }

     @FXML
    private void gotoRestau(MouseEvent event) throws IOException {
        loadPage("ShowRestau");
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
