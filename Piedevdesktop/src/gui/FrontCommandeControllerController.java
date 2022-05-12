
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import entite.Commande;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import service.CommandeService;

/**
 * FXML Controller class
 *
 * @author omaro
 */
public class FrontCommandeControllerController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private VBox comlay;
 CommandeService sv = new CommandeService();
private   List<Commande> ls = new ArrayList<>();
    @FXML
    private JFXButton add;
    @FXML
    private JFXButton comm;
    private List<Commande> coms (){
return sv.recuperer();
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//         ls.addAll(coms());
//               for(int i =0;i <ls.size();i++)
//               {
//                   FXMLLoader fxmlloader = new FXMLLoader();
//                   fxmlloader.setLocation(getClass().getResource("Commande.fxml"));
//                   
//                   try {
//                   
//                   HBox hbox = fxmlloader.load();
//                   CommandeController cocon= fxmlloader.getController();
//                  cocon.SetData(ls.get(i));
//                  comlay.getChildren().add(hbox);
//                         
//                          ; }
//               catch(IOException e)
//               {e.printStackTrace();
//               }
//               }

      
        // TODO
    }    

    @FXML
    private void ajout(ActionEvent event) throws IOException { Parent page1 = FXMLLoader.load(getClass().getResource("AjoutCom.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Ajouter une Commande");
        stage.setScene(scene);
        stage.show(); 
    }

    @FXML
    private void comm(ActionEvent event) {
       ls.clear();
        ls.addAll(coms());
         System.out.println(ls);
          comlay.getChildren().clear();
               for(int i =0;i <ls.size();i++)
               {
                   FXMLLoader fxmlloader = new FXMLLoader();
                   fxmlloader.setLocation(getClass().getResource("Commande.fxml"));
                   
                   try {
                   
                   HBox hbox = fxmlloader.load();
                   CommandeController cocon= fxmlloader.getController();
                   
                  cocon.SetData(ls.get(i));
                  
                  comlay.getChildren().add(hbox);
                         
                          ; }
               catch(IOException e)
               {e.printStackTrace();
               }
               }
      
    }
    
}
