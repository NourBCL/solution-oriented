/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.CommandeService;
import util.Smsapi;

/**
 *
 * @author omaro
 */
public class Start extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("AllBackCom.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("ga3ga3");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
//       CommandeService cs = new CommandeService();
//       System.out.println(cs.recuperer());

    //Smsapi.sendSMS("Test de SMS");
      
       
       
    }

}
