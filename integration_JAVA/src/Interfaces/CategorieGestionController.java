/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.jfoenix.controls.JFXButton;
import Entities.Categoriet;
import Entities.Transport;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import Services.CategorietService;
import Services.TransportService;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class CategorieGestionController implements Initializable {

    @FXML
    private TextField inputRech;
    @FXML
    private Button supp;
    @FXML
    private Button Ajouter;
 
    
    @FXML
    private TableColumn<?, ?> type_transport;
    @FXML
    private Button Timage;
    @FXML
    private ImageView imgajoutincours;
    @FXML
    private Label imgpath;
    @FXML
    private TableView<Categoriet> tableview;
   public ObservableList<Categoriet> list;
   CategorietService cs = new CategorietService();
  
   
    @FXML
    private Button Confirmer;
    @FXML
    private TextField inputtransport;
    @FXML
    private Label labelidd;
    @FXML
    private Button modif;
    @FXML
    private Hyperlink cat;
    @FXML
    private Button prec1;
    @FXML
    private JFXButton transport1;
    @FXML
    private JFXButton acceuil;
  
 

   
   /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategorietService pss = new CategorietService();
        ArrayList<Categoriet> c = new ArrayList<>();
        try {
            c = (ArrayList<Categoriet>) pss.AfficherAllcategorie_t();
        } catch (SQLException ex) {
            System.out.println("erreurrrrrrrrrrrrr");
        }
        
        ObservableList<Categoriet> obs2 = FXCollections.observableArrayList(c);
        tableview.setItems(obs2);
        
        
 type_transport.setCellValueFactory(new PropertyValueFactory<>("type_transport"));
    

            try {
            list = FXCollections.observableArrayList(
                    pss.AfficherAllcategorie_t()
            );        
        
        
   FilteredList<Categoriet> filteredData = new FilteredList<>(list, e -> true);
            inputRech.setOnKeyReleased(e -> {
                inputRech.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super Categoriet>) Categoriets -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        if (Categoriets.getType_transport().toLowerCase().contains(lower)) {
                            return true;
                        }

                        return false;
                    });
                });
                SortedList<Categoriet> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
     public void resetTableData() throws SQLDataException, SQLException {

        List<Categoriet> Categoriets = new ArrayList<>();
        Categoriets = cs.AfficherAllcategorie_t();
        ObservableList<Categoriet> data = FXCollections.observableArrayList(Categoriets);
        tableview.setItems(data);
    }
     
     
     
    @FXML
    private void supp(ActionEvent event) throws SQLException {
         if (event.getSource() == supp) {
            Categoriet e = new Categoriet();
            e.setId(tableview.getSelectionModel().getSelectedItem().getId());  
            CategorietService cs = new CategorietService();
            cs.supp2(e);
            resetTableData();  
        
        
    } 
    }    

    @FXML
    private void Modif(ActionEvent event) {
        
    
       
            labelidd.setText(Integer.toString(tableview.getSelectionModel().getSelectedItem().getId()));
         
            
            inputtransport.setText(tableview.getSelectionModel().getSelectedItem().getType_transport());

           Timage.setText(tableview.getSelectionModel().getSelectedItem().getImage_tranport());
               
         
           Confirmer.setVisible(true);  
    }

    @FXML
    private void Ajouter(ActionEvent event) throws SQLException {
        CategorietService productService = new CategorietService();
        
        if (inputtransport.getText().equals("")
              ) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();
            
            
            
            
        }  
               
               
              else if (inputtransport.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")
              ) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText(" doit pas contenir un symbole ");
            a.setHeaderText(null);
            a.showAndWait();
            
        
        }       
               
               
      Categoriet c = new Categoriet(inputtransport.getText(),Timage.getText());

      
              
                    
        
        productService.ajoutercategorie_t(c);
        
        resetTableData();
      
        
        
    }

    @FXML
    private void cat(ActionEvent event) throws SQLException {
        
        
        
        
    }

  
@FXML
    private void addimgcours(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        File file = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            imgajoutincours.setImage(image);
            imgajoutincours.setFitWidth(200);
            imgajoutincours.setFitHeight(200);
            imgajoutincours.scaleXProperty();
            imgajoutincours.scaleYProperty();
            imgajoutincours.setSmooth(true);
            imgajoutincours.setCache(true);
            FileInputStream fin = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fin.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            byte[] person_image = bos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger("ss");
        }
        imgpath.setText(file.getAbsolutePath());
    }

    @FXML
    private void Confirmer(ActionEvent event) throws SQLException, NoSuchAlgorithmException {
         CategorietService productService = new CategorietService();
       
               
             
      Categoriet c = new Categoriet(Integer.parseInt(labelidd.getText()),inputtransport.getText(),Timage.getText());

        productService.modifiercategorie_t(c);
        
        resetTableData();
      
        
        
        
        
    }

    @FXML
    private void prec1(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/Interfaces/TransportGestion.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des transport");
        stage.setScene(scene);
        stage.show();
        
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
    void changeUser(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/Interfaces/ListeUtilisateurBack.fxml"));
       // acpane.getChildren().add(p);

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
    private void openEvenements(ActionEvent event) {
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
