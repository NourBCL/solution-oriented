/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Services.RestaurantService;
import Entities.Restaurant;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SHS TECH
 */
public class FrontRestoController implements Initializable {

    @FXML
    private AnchorPane bigCon;
    RestaurantService hot=new RestaurantService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        
                ObservableList<Restaurant> restos= hot.afficher();
              
                int size=1290-250;
     
        int posX=114;
     int posY=100;
          int a=0;
             /* <ImageView fx:id="imgEv" fitHeight="138.0" fitWidth="189.0" layoutX="62.0" layoutY="-11.0" pickOnBounds="true" preserveRatio="true">*/
           //  Image image = new Image("images/272750578_977821313144051_7040848613990936832_n.jpg");
            /* <Rectangle fx:id="recNom" arcHeight="5.0" arcWidth="5.0" fill="#010910" height="49.0" layoutX="-4.0" layoutY="100.0" stroke="BLACK" strokeType="INSIDE" width="150.0" />
       */
   
    for(Restaurant r : restos){
        a++;
        if(a==4){
            a=1;
        posX=114;
        posY+=270;
        }
       // <Label fx:id="labDate" layoutX="4.0" layoutY="49.0" prefHeight="49.0" prefWidth="90.0" text="04/mars/2022" />
            //<Label fx:id="labNom" layoutX="22.0" layoutY="176.0" prefHeight="17.0" prefWidth="107.0" text="Karim gharbi visa" textFill="WHITE" />
            //<Label fx:id="labPrix" layoutX="293.0" layoutY="176.0" text="25DT" />
         Label lab1=new Label();
         lab1.setLayoutX(4);
         lab1.setLayoutY(49);
         lab1.setPrefHeight(49);
         lab1.setPrefWidth(90);
         lab1.setText("Ouvre a : "+r.getHorraire_ouverture());
         
          Label lab2=new Label();
         lab2.setLayoutX(22);
         lab2.setLayoutY(176);
         lab2.setPrefHeight(17);
         lab2.setPrefWidth(107);
         lab2.setText(r.getNom());
         Label lab3=new Label();
         lab3.setLayoutX(293);
         lab3.setLayoutY(176);
         lab3.setPrefHeight(17);
         lab3.setPrefWidth(150);
         lab3.setText("Num : " +Integer.toString(r.getNum()));
         
         AnchorPane container1=new AnchorPane();
     File file = new File(r.getImage());
        Image image = new Image(file.toURI().toString());
        //  <AnchorPane fx:id="container" layoutX="61.0" layoutY="53.0" prefHeight="260.0" prefWidth="337.0">
         container1.setLayoutX(posX);
         container1.setLayoutY(posY);
         container1.setPrefHeight(260);
         container1.setPrefWidth(337);
         bigCon.getChildren().add(container1);
         System.out.println(r.getImage());
            ImageView img=new ImageView(image);
   /*            <ImageView fx:id="imgEv" fitHeight="101.0" fitWidth="121.0" layoutX="73.0" layoutY="-1.0" pickOnBounds="true" preserveRatio="true" visible="false">
        */
   //    <ImageView fx:id="imgEv" fitHeight="149.0" fitWidth="259.0" layoutX="79.0" layoutY="-1.0" pickOnBounds="true">
            img.setFitHeight(149);
            img.setFitWidth(259);
            img.setLayoutX(79);
            img.setLayoutY(-1);
         
      
   /*            <ImageView fx:id="imgEv" fitHeight="101.0" fitWidth="121.0" layoutX="73.0" layoutY="-1.0" pickOnBounds="true" preserveRatio="true" visible="false">
        */
   //    <ImageView fx:id="imgEv" fitHeight="149.0" fitWidth="259.0" layoutX="79.0" layoutY="-1.0" pickOnBounds="true">
        
           //<Rectangle fx:id="recDate" arcHeight="5.0" arcWidth="5.0" fill="DODGERBLUE" height="149.0" layoutX="3.0" layoutY="-1.0" stroke="BLACK" strokeType="INSIDE" width="79.0" />
           // <Rectangle fx:id="recNom" arcHeight="5.0" arcWidth="5.0" fill="#010910" height="76.0" layoutX="4.0" layoutY="147.0" stroke="BLACK" strokeType="INSIDE" width="270.0" />
          //  <Rectangle fx:id="recPrix" arcHeight="5.0" arcWidth="5.0" fill="DODGERBLUE" height="76.0" layoutX="274.0" layoutY="146.0" stroke="BLACK" strokeType="INSIDE" width="66.0" />
            Rectangle rec3=new Rectangle();
              rec3.setArcHeight(0);
             rec3.setArcWidth(0);
           rec3.setHeight(149);
           rec3.setWidth(79);
           rec3.setLayoutX(3);
           rec3.setLayoutY(-1);
           rec3.setStroke(Color.rgb(241, 33, 106));
          rec3.setFill(Color.rgb(241, 33, 106));
            container1.getChildren().add(rec3);
           
   // <Rectangle fx:id="recNom" arcHeight="5.0" arcWidth="5.0" fill="#010910" height="76.0" layoutX="4.0" layoutY="147.0" stroke="BLACK" strokeType="INSIDE" width="270.0" />
         Rectangle rec1=new Rectangle();
           rec1.setArcHeight(0);
           rec1.setArcWidth(0);
           rec1.setHeight(76);
           rec1.setWidth(270);
           rec1.setLayoutX(4);
           rec1.setLayoutY(147);
           rec1.setStroke(Color.WHITE);
           rec1.setFill(Color.WHITE);
          
            container1.getChildren().add(rec1);
            /*            <Rectangle fx:id="recPrix" arcHeight="5.0" arcWidth="5.0" fill="DODGERBLUE" height="49.0" layoutX="146.0" layoutY="100.0" stroke="BLACK" strokeType="INSIDE" width="57.0" />
   */    
            // <Hyperlink fx:id="link" layoutX="62.0" layoutY="150.0" text="Hyperlink" />
             //<Hyperlink fx:id="link" layoutX="139.0" layoutY="223.0" prefHeight="38.0" prefWidth="59.0" text="Hyperlink" visible="false" />
            Hyperlink link1 = new Hyperlink();
            link1.setLayoutX(139);
            link1.setLayoutY(223);
            link1.prefHeight(38);
            link1.prefWidth(59);
            
            link1.setText("participer");
            
           
       
         //  <Rectangle fx:id="recPrix" arcHeight="5.0" arcWidth="5.0" fill="DODGERBLUE" height="76.0" layoutX="274.0" layoutY="146.0" stroke="BLACK" strokeType="INSIDE" width="66.0" />
            Rectangle rec2=new Rectangle();
              rec2.setArcHeight(0);
             rec2.setArcWidth(0);
           rec2.setHeight(76);
           rec2.setWidth(66);
           rec2.setLayoutX(274);
           rec2.setLayoutY(146);
           
          rec2.setStroke(Color.rgb(241, 33, 106));
          rec2.setFill(Color.rgb(241, 33, 106));
            container1.getChildren().add(rec2);
            container1.getChildren().add(lab1);
            container1.getChildren().add(lab2);
            container1.getChildren().add(lab3);
            
            
    posX+=350;}
        
    }
   
    
}
