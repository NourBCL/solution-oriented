/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.evenement;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author User
 */
public class SingleEventController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label description;
    @FXML
    private Label prix;
    evenement currentEvenement;
    AfficheEvenementController controller;
    @FXML
    private Label countdown;
    @FXML
    private ImageView image;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setEvenement(evenement ev) {
        currentEvenement = ev;
        nom.setText(ev.getNom());
        description.setText(ev.getDescription());
        prix.setText(String.valueOf(ev.getPrix()));
         
        File imageFile = new File(AjouterEvenementController.imgUploadDir + "/" + ev.getImage());
        Image imagea = new Image(imageFile.toURI().toString());
        image.setImage(imagea) ;
        
        startTimer(findDifferenceFromNow(ev) );
    }

    public void setController(AfficheEvenementController e) {
        controller = e;
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

    @FXML
    private void participer(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("QRCODE.fxml"));
            Scene scene = new Scene(root.load());
            Stage stage = new Stage();
            stage.setTitle("qrCode");
            stage.setScene(scene);
            stage.show();
            ((QRCODE)root.getController()).initQrCode("http://127.0.0.1:8000/evenement/show/"+ currentEvenement.getId());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
      public int findDifferenceFromNow(evenement promotion)
    {
        Date d1 = Date.valueOf(LocalDate.now());
        Date d2 = promotion.getDateDeb();
        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf
            = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");
  
  
            // parse method is used to parse
            // the text from a string to
            // produce the date
  
            // Calucalte time difference
            // in milliseconds
            long difference_In_Time
                = d2.getTime() - d1.getTime();
  
            // Calucalte time difference in
            // seconds, minutes, hours, years,
            // and days
            long difference_In_Seconds
                = (difference_In_Time
                   / 1000)
                  % 60;
  
            long difference_In_Minutes
                = (difference_In_Time
                   / (1000 * 60))
                  % 60;
  
            long difference_In_Hours
                = (difference_In_Time
                   / (1000 * 60 * 60))
                  % 24;
  
            long difference_In_Years
                = (difference_In_Time
                   / (1000l * 60 * 60 * 24 * 365));
  
            long difference_In_Days
                = (difference_In_Time
                   / (1000 * 60 * 60 * 24))
                  % 365;
  
            // Print the date difference in
            // years, in days, in hours, in
            // minutes, and in seconds
  
           return (int)(difference_In_Time/1000);
        
    }
      public int findDifference(evenement promotion)
    {
        Date d1 = promotion.getDateDeb();
        Date d2 = promotion.getDateFin();
        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf
            = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");
  
  
            // parse method is used to parse
            // the text from a string to
            // produce the date
  
            // Calucalte time difference
            // in milliseconds
            long difference_In_Time
                = d2.getTime() - d1.getTime();
  
            // Calucalte time difference in
            // seconds, minutes, hours, years,
            // and days
            long difference_In_Seconds
                = (difference_In_Time
                   / 1000)
                  % 60;
  
            long difference_In_Minutes
                = (difference_In_Time
                   / (1000 * 60))
                  % 60;
  
            long difference_In_Hours
                = (difference_In_Time
                   / (1000 * 60 * 60))
                  % 24;
  
            long difference_In_Years
                = (difference_In_Time
                   / (1000l * 60 * 60 * 24 * 365));
  
            long difference_In_Days
                = (difference_In_Time
                   / (1000 * 60 * 60 * 24))
                  % 365;
  
            // Print the date difference in
            // years, in days, in hours, in
            // minutes, and in seconds
  
           return (int)(difference_In_Time/1000);
        
    }
       public void startTimer(int seconds)
    {
       // System.out.println(seconds);
        setTimeout(() -> {
            //System.out.println(this.getScene());
            Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if(seconds<0){countdown.setText("Finished !!");}
                            else
                            countdown.setText("Still "+String.valueOf(seconds) + "s"+" for the event !");
                        }
                    });

            
            startTimer(seconds-1);}, 1000);
        
    }
       public static void setTimeout(Runnable runnable, int delay){
    new Thread(() -> {
        try {
            Thread.sleep(delay);
            runnable.run();
        }
        catch (Exception e){
            System.err.println(e);
        }
    }).start();
}

}
